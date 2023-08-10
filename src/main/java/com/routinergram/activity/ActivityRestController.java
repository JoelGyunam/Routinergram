package com.routinergram.activity;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.routinergram.activity.service.ActivityService;

@RequestMapping("/rest/activity")
@RestController
public class ActivityRestController {

	@Autowired
	private ActivityService activityService;
	
	//해당 api가 호출될 때 마다 userActivity 테이블에 있는 visitCount 에 1 올린다.
	
	//역할 나누기
	// controller = session 에서 UID 받아서 서비스에게 넘겨주기
	// 서비스 = 1-1) 그 UID가 userActivity 테이블에 들어 있는지 확인
	// 서비스 = 1-2) 안들어있으면 넣기.
	// 서비스 = 2-1) 오늘 > last update 인지 호가인
	// 서비스 = 2-2) 그렇다면 1 올리기
	
	@PostMapping("/visit-up")
	public Map<String, String> visitCountUp(HttpSession session){
		int UID = (int) session.getAttribute("UID");
		int resultCount=0;
		
		int ifNewUser = activityService.newUserActivity(UID);
		
		if(ifNewUser == 1) {
			resultCount = ifNewUser;
		} else {
			resultCount = activityService.raiseVisitCount(UID);
		};
				
		Map<String,String> resultMap = new HashMap<>();
		if(resultCount == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}
	
	@PostMapping("/upload-up")
	public Map<String, String> uploadCountUp(HttpSession session){
		int UID = (int) session.getAttribute("UID");
		int resultCount=0;
		
		int ifNewUser = activityService.newUserActivity(UID);
		
		if(ifNewUser == 1) {
			resultCount = ifNewUser;
		} else {
			resultCount = activityService.raiseUploadCount(UID);
		};
		
		Map<String,String> resultMap = new HashMap<>();
		if(resultCount == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}
	
}
