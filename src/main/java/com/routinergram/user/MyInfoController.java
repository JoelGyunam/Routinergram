package com.routinergram.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.routinergram.common.ImagePlaceholder;

@Controller
@RequestMapping("/main/myinfo")
public class MyInfoController {
	
	@Autowired
	private ImagePlaceholder imagePlaceholder;

	@GetMapping()
	public String myinfoMain(HttpSession session,Model model) {
		
		int UID = (int) session.getAttribute("UID");
		
		String profileImage = imagePlaceholder.profileImageInput(UID);
		model.addAttribute("profileImage", profileImage);
		
		return "myinfo/myinfoMain";
	}
	
	@GetMapping("/editPW")
	public String editPW() {
		return"myinfo/editPW";
	}
	
}
