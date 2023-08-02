package com.routinergram.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Hello {

	@GetMapping("/hello")
	@ResponseBody
	public String hello() {
		return "Hello World!";
	};
	
	@GetMapping("/hello/jsp")
	public String helloJsp() {
		return "/WEB-INF/jsp/hello/hello.jsp";
	}
	
}
