package com.odi.controller;

import javax.servlet.http.HttpSession;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.odi.domain.ChatMessage;
import com.odi.domain.UserVO;

@Controller
public class MainController {

	@RequestMapping("view/{viewName}")
	public String getView(@PathVariable String viewName, HttpSession session, Model model) throws Exception {
		UserVO user = (UserVO) session.getAttribute("user");

		if (user == null) {
			return "redirect:login.jsp";
		}

		model.addAttribute("user", user);
		return "/" + viewName + ".jsp";
	}

	
    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
        return chatMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(@Payload ChatMessage chatMessage,
                               SimpMessageHeaderAccessor headerAccessor) {
        // Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }

}
