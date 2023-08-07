package com.routinergram.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.routinergram.user.domain.UserNickname;
import com.routinergram.user.domain.Userinfo;
import com.routinergram.user.service.UserNicknameService;
import com.routinergram.user.service.UserinfoService;

@RestController
@RequestMapping("/reg")
public class RegistrationRestController {

	@Autowired
	private UserinfoService userinfoService;
	
	@Autowired
	private UserNicknameService userNicknameService;
	
	@PostMapping("/submit/if-email-duplicated")
	public Map<String, Boolean> ifDuplicatedEmail(@RequestParam("email") String email){
		Userinfo userinfo = new Userinfo();
		userinfo.setEmail(email);
		int result = userinfoService.emailDupCheck(userinfo);
		
		Map<String,Boolean> resultMap = new HashMap<>();
		if(result == 0) {
			resultMap.put("isDuplicated",false);
		} else {
			resultMap.put("isDuplicated",true);
		}
		return resultMap;
	}
	
	@PostMapping("/submit/set-nickname")
	public Map<String, String> setNickname(
			@RequestParam("NickID") int NickID
			, @RequestParam("UID") int UID
			)
	{
		UserNickname userNickname = new UserNickname();
		userNickname.setNickID(NickID);
		userNickname.setUID(UID);
		int result = userNicknameService.setNickname(userNickname);
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(result == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		return resultMap;
	}
	
	@PostMapping("/submit/if-nickname-duplicated")
	public Map<String, Object> ifNicknameDup(@RequestParam("nickname") String nickname){
		int count = userNicknameService.countNickname(nickname);
		Map<String,Object> resultMap = new HashMap<>();
		if(count == 0) {
			resultMap.put("isDuplicated", "false");
			UserNickname userNickname = new UserNickname();
			userNickname.setNickname(nickname);
			userNicknameService.addNickname(userNickname);
			resultMap.put("NickID", userNickname.getNickID());
			return resultMap;
		}else {
			resultMap.put("isDuplicated", "true");
			return resultMap;
		}
	}
	
	@PostMapping("/submit")
	public Map<String,Object> registration(
			@RequestParam("email") String email
			, @RequestParam("password") String password
			, @RequestParam("NickID") int NickID
			, @RequestParam("ITRID") int ITRID
			, HttpServletRequest request
			){
		
		Userinfo userinfo = new Userinfo();
		
		userinfo.setEmail(email);
		userinfo.setPassword(password);
		userinfo.setNickID(NickID);
		userinfo.setITRID(ITRID);
		
		int result = userinfoService.registrationRequest(userinfo);
		
		Map<String,Object> resultMap = new HashMap<>();
		
		if(result == 1) {
			
			HttpSession session = request.getSession();
			
			String nickname = userNicknameService.getUserNicknameByNickID(NickID);
			
			session.setAttribute("UID", userinfo.getUID());
			session.setAttribute("NickID", userinfo.getNickID());
			session.setAttribute("nickname", nickname);
			
			
			resultMap.put("result","success");
			resultMap.put("UID", userinfo.getUID());
			return resultMap;
		} else {
			resultMap.put("result","fail");
			return resultMap;
		}
	}
}
