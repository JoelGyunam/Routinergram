package com.routinergram.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.routinergram.interests.service.InterestsService;

@RequestMapping("/reg")
@Controller
public class RegistrationController {

	@Autowired
	private InterestsService interestService;
	
	@GetMapping()
	public String registrationView(Model model) {
		
		model.addAttribute("interestOption", interestService.getInterestList());
		
		return "joiner/reg/reg";
	}
	
	@GetMapping("/welcome")
	public String RegistrationDoneView() {
		return "joiner/reg/welcome";
	}
	
}
