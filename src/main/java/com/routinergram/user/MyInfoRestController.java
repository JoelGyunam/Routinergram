package com.routinergram.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
	
}
