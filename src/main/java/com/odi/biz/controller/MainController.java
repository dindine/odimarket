package com.odi.biz.controller;

import com.odi.biz.user.UserVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class MainController {

    @RequestMapping("{viewName}/page.do")
    public String getView(@PathVariable String viewName, HttpSession session, Model model) {
        UserVO user = (UserVO) session.getAttribute("user");

        if (user == null) {
            return "redirect:login.jsp";
        }

        model.addAttribute("user", user);
        return "/" + viewName + ".jsp";
    }
}
