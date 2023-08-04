package com.routinergram.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.routinergram.user.domain.Userinfo;
import com.routinergram.user.service.RegistrationService;

@RestController
@RequestMapping("/reg")
public class RegistrationRestController {

	@Autowired
	private RegistrationService registrationService;
	
	@PostMapping("/submit")
	public Map<String,String> registration(
			@RequestParam("email") String email
			, @RequestParam("password") String password
			, @RequestParam("nickname") String nickname
			, @RequestParam("ITRID") int ITRID
			, HttpServletRequest request
			){
		
		Userinfo userinfo = new Userinfo();
		
		userinfo.setEmail(email);
		userinfo.setPassword(password);
		userinfo.setNickname(nickname);
		userinfo.setITRID(ITRID);
		
		
		int result = registrationService.registrationRequest(userinfo);
		
		Map<String,String> resultMap = new HashMap<>();
		
		if(result == 1) {
			
			HttpSession session = request.getSession();

			
			session.setAttribute("UID", userinfo.getUID());
			session.setAttribute("nickname", userinfo.getNickname());
			
			resultMap.put("result","success");
			return resultMap;
		} else {
			resultMap.put("result","fail");
			return resultMap;
		}
	}
}
