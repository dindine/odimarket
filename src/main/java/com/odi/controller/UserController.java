package com.odi.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.odi.domain.UserVO;
import com.odi.service.GoogleService;
import com.odi.service.NaverService;
import com.odi.service.UserService;

@Controller
@RequestMapping("/user")
@SessionAttributes("user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private NaverService naverService;

	@Autowired
	private GoogleService googleService;

	@RequestMapping("/normal/login.do")
	public String login(Model model, HttpSession session, @RequestParam String id, @RequestParam String password) {
		try {
			UserVO user = userService.findOne(id, password);

			model.addAttribute("user", user);
			session.setAttribute("user", user);

			return "/main.jsp";
		} catch (Exception e) {
			return "/login.jsp";
		}
	}

	@RequestMapping("naver/login.do")
	public String loginByNaver(Model model, HttpSession session) {
		return "redirect:" + naverService.getAuthorizationUrl(session);
	}

	@RequestMapping("google/login.do")
	public String loginByGoogle(Model model) {
		return "redirect:" + googleService.getLoginUrl();
	}

	@RequestMapping("normal/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "/login.jsp";
	}

	@RequestMapping("/logout.do")
	public String logout_t(HttpSession session) {
		session.invalidate();
		return "/login.jsp";
	}

	@RequestMapping("/naver/logout.do")
	public String logoutByNaver(HttpSession session) {
		session.invalidate();
		return "/login.jsp";
	}

	@RequestMapping("/google/logout.do")
	public String logoutByGoogle(HttpSession session) {
		session.invalidate();
		return "/login.jsp";
	}

	@RequestMapping(value = "naver/callback.do")
	public String callback(@RequestParam String code, @RequestParam String state, HttpSession session, Model model)
			throws IOException {
		UserVO user = naverService.getUserProfile(session, code, state);
		userService.save(user);

		model.addAttribute("user", user);
		session.setAttribute("user", user);

		return "/main.jsp";
	}

	@RequestMapping(value = "google/callback.do")
	public String doSessionAssignActionPage(@RequestParam String code, HttpSession session, Model model)
			throws Exception {
		UserVO user = googleService.createUser(code);
		userService.save(user);

		model.addAttribute("user", user);
		session.setAttribute("user", user);

		return "/main.jsp";
	}

	@RequestMapping(value = "/update.do", method = RequestMethod.POST)
	public String update(@ModelAttribute UserVO user, HttpSession session, Model model) throws Exception {
		if (userService.update(user)) {
			model.addAttribute("user", user);
			session.setAttribute("user", user);

			return "/main.jsp";
		} else {
			return "redirect:/login.jsp";
		}
	}

	@RequestMapping("/delete.do")
	public String delete(@RequestParam String id, @RequestParam String password, HttpSession session, Model model)
			throws Exception {
		if(userService.delete(id, password)) {
			session.invalidate();
			
			return "redirect:/login.jsp";
		} else {
			return "/main.jsp";
		}
	}

}