package com.odi.view.user;

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

import com.odi.biz.user.UserVO;
import com.odi.biz.user.service.GoogleService;
import com.odi.biz.user.service.NaverService;
import com.odi.biz.user.service.UserService;



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
			if (user != null) {
				
				model.addAttribute("user", user);
				session.setAttribute("user", user);
				session.setAttribute("cust_id", id);
				session.setAttribute("cust_pwd", password);

				model.addAttribute("cust_id", id);
//				return "/main.jsp";
				return "redirect:http://localhost:8080/odi/getProductList.do?cust_id="+user.getCust_id();
			} else {
				System.out.println("user :"  + user);
				model.addAttribute("msg", "아이디와 비밀번호를 다시 입력해주세요");
				model.addAttribute("url", "/odi/login.jsp");
				return "/alert.jsp";
			}

		} catch (Exception e) {
			System.out.println("오류입니다.");
			e.printStackTrace();
			return "/login.jsp";
		}
	}

	@RequestMapping("naver/login.do")
	public String loginByNaver(Model model, HttpSession session){
		return "redirect:" + naverService.getAuthorizationUrl(session);
	}

	@RequestMapping("google/login.do")
	public String loginByGoogle(Model model) {
		return "redirect:" + googleService.getLoginUrl();
	}

	@RequestMapping("normal/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:http://localhost:8080/odi/main.jsp";
	}

	@RequestMapping("/logout.do")
	public String logout_t(HttpSession session) {
		session.invalidate();
		return "redirect:http://localhost:8080/odi/main.jsp";
	}

	@RequestMapping("/naver/logout.do")
	public String logoutByNaver(HttpSession session) {
		session.invalidate();
		return "redirect:http://localhost:8080/odi/main.jsp";
	}

	@RequestMapping("/google/logout.do")
	public String logoutByGoogle(HttpSession session) {
		session.invalidate();
		return "redirect:http://localhost:8080/odi/main.jsp";
	}

	@RequestMapping(value = "naver/callback.do")
	public String callback(@RequestParam String code, @RequestParam String state, HttpSession session, Model model)
			throws IOException {
		UserVO user = naverService.getUserProfile(session, code, state);
		userService.save(user);
		
		user = userService.findById(user.getCust_id());
		System.out.println("회원 정보 : " + user);
		model.addAttribute("user", user);
		session.setAttribute("user", user);
		
		if(user.getCust_pwd() != null && user.getCust_pwd() != "") {
		session.setAttribute("cust_id", user.getCust_id());
		session.setAttribute("cust_pwd", user.getCust_pwd());
		//return "/main.jsp";
		return "redirect:http://localhost:8080/odi/getProductList.do?cust_id="+user.getCust_id();
		} else {
			model.addAttribute("msg", "[간편 로그인] 을 계속해서 이용하려면, 추가 정보를 입력해주세요!");
			model.addAttribute("url", "/odi/cust_update.jsp");
			return "/alert.jsp";
		}
	}

	@RequestMapping(value = "google/callback.do")
	public String doSessionAssignActionPage(@RequestParam String code, HttpSession session, Model model)
			throws Exception {
		UserVO user = googleService.createUser(code);
		userService.save(user);
		
		user = userService.findById(user.getCust_id());
		System.out.println("회원 정보 : " + user);
		model.addAttribute("user", user);
		session.setAttribute("user", user);
		
		if(user.getCust_pwd() != null && user.getCust_pwd() != "") {
		session.setAttribute("cust_id", user.getCust_id());
		session.setAttribute("cust_pwd", user.getCust_pwd());
		//return "/main.jsp";
		return "redirect:http://localhost:8080/odi/getProductList.do?cust_id="+user.getCust_id();
		} else {
			model.addAttribute("msg", "[간편 로그인] 을 계속해서 이용하려면, 추가 정보를 입력해주세요!");
			model.addAttribute("url", "/odi/cust_update.jsp");
			return "/alert.jsp";
		}
		
	}

	@RequestMapping(value = "/update.do", method = RequestMethod.POST)
	public String update(@ModelAttribute UserVO user, HttpSession session, Model model) throws Exception {
		if (userService.update(user)) {
			model.addAttribute("user", user);
			session.setAttribute("user", user);

			return "redirect:http://localhost:8080/odi/getProductList.do?cust_id="+user.getCust_id();
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
		}else {
			return "/main.jsp";
		}
	}
}