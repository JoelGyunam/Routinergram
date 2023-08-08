package com.routinergram.activity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main/myinfo")
public class MyInfoController {

	@GetMapping()
	public String myinfoMain() {
		return "/myinfo/myinfoMain";
	}
	
}
