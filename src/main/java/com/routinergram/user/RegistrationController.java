package com.routinergram.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/reg")
@Controller
public class RegistrationController {

	@GetMapping()
	public String registrationView() {
		return "joiner/reg/reg";
	}
	
	@GetMapping("/welcome")
	public String RegistrationDoneView() {
		return "joiner/reg/welcome";
	}
	
}
