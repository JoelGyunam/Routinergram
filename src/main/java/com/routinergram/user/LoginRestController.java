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
import com.routinergram.user.service.UserNicknameService;
import com.routinergram.user.service.UserinfoService;

@RestController
@RequestMapping("/login")
public class LoginRestController {

	@Autowired
	private UserinfoService userinfoService;
	
	@Autowired
	private UserNicknameService userNicknameService;
	
	@PostMapping("/enter")
	public Map<String, String> loginRequest(
			@RequestParam("email") String email
			,@RequestParam("password") String password
			,HttpServletRequest request){
		
		Userinfo userinfo = new Userinfo();
		
		userinfo.setEmail(email);
		userinfo.setPassword(password);
		
		Map<String, String> loginResultMap = new HashMap<>();
		
		userinfo = userinfoService.loginRequest(userinfo);
		
		if(userinfo != null) {
			loginResultMap.put("result", "success");
			String nickname = userNicknameService.getUserNicknameByNickID(userinfo.getNickID());
			HttpSession session = request.getSession();
			session.setAttribute("UID", userinfo.getUID());
			session.setAttribute("nickname", nickname);
			session.setAttribute("email", userinfo.getEmail());
		} else {
			loginResultMap.put("result", "fail");
		}
		return loginResultMap;
	}
}
