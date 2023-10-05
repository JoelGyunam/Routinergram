package com.routinergram;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("")
@Controller
public class GreetingController {

	@GetMapping("")
	public String noURI() {
		return "joiner/greeting/greeting";
	};
	
	
	@GetMapping("/greeting")
	public String greetingView() {
		return "joiner/greeting/greeting";
	};
}
