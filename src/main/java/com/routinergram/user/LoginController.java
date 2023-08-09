package com.routinergram.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main/login")
public class LoginController {

	@GetMapping
	public String loginView() {
		return "joiner/login/login";
	};
	
	
	@GetMapping("/forgotpw")
	public String forgotPwView() {
		return "joiner/login/forgotpw";
	};
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/main/login";
	}
}
