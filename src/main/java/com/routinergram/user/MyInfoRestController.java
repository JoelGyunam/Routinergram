package com.routinergram.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.routinergram.user.domain.Userinfo;
import com.routinergram.user.service.UserinfoService;

@RestController
@RequestMapping("/rest/myinfo")
public class MyInfoRestController {
	
	@Autowired
	private UserinfoService userinfoService;
	
	@PostMapping("/change-image")
	public Map<String, String> changeProfileImage(
			@RequestParam("image") MultipartFile imageFile
			,HttpSession session
			){
		int UID = (int) session.getAttribute("UID");
		
		int result = userinfoService.changeProfileImage(UID, imageFile);
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(result == 1) {
			resultMap.put("result","success");
		} else {
			resultMap.put("result","fail");
		}
		return resultMap;
	};
	
	@PostMapping("/editPW/pwChecker")
	public Map<String, Boolean> pwChecker(@RequestParam("password") String password
			,HttpSession session){
	
		Userinfo userinfo = new Userinfo();
		int UID = (int) session.getAttribute("UID");
		String email=userinfoService.getUserInfoByUID(UID).getEmail();
		userinfo.setEmail(email);
		userinfo.setPassword(password);
		
		Userinfo resultUserinfo = new Userinfo();
		resultUserinfo = userinfoService.loginRequest(userinfo);
		
		Map<String, Boolean> resultMap = new HashMap<>();
		if(resultUserinfo==null) {
			resultMap.put("ifMatch",false);
		} else {
			resultMap.put("ifMatch",true);
		}
		return resultMap;
	}
	
	@PutMapping("/editPW/submit")
	public Map<String, String> editPW(
			@RequestParam("currentPW") String currentPW
			,@RequestParam("changePW") String changePW
			,HttpSession session){
		int UID = (int) session.getAttribute("UID");
		int result = userinfoService.editPW(UID, currentPW, changePW);
		Map<String, String> resultMap = new HashMap<>();
		if(result == 1) {
			resultMap.put("result","success");
		} else {
			resultMap.put("result","fail");
		}
		return resultMap;
	}
}
