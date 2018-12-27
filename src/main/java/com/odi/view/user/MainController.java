package com.odi.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.odi.biz.user.UserVO;

@Controller
@RequestMapping("/")
public class MainController {

	@RequestMapping("{viewName}/page.do")
	public String getView(@PathVariable String viewName, HttpSession session, Model model) throws Exception {
		UserVO user = (UserVO) session.getAttribute("user");

		if (user == null) {
			return "redirect:login.jsp";
		}

		model.addAttribute("user", user);
		return "/" + viewName + ".jsp";
	}
}
