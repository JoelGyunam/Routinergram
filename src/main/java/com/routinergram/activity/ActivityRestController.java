package com.routinergram.activity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.routinergram.activity.domain.UserActivity;
import com.routinergram.activity.service.ActivityService;

@RequestMapping("/rest/activity")
@RestController
public class ActivityRestController {

	@Autowired
	private ActivityService activityService;
	
	@PostMapping("/visit-up")
	public Map<String, String> visitCountUp(HttpSession session){
		int UID = (int) session.getAttribute("UID");
		int resultCount=0;
		UserActivity userActivity = activityService.getActivityInfo(UID);
		
		if(userActivity == null) {
			activityService.newUserActivity(UID);
		}
		
		Date nowDate = new Date();
		Date latestDate = null;
		if(userActivity == null) {
			latestDate = nowDate;
		} else {
			latestDate = userActivity.getUpdatedAt();
		}
		
		if(latestDate == null || latestDate.before(nowDate)) {
			resultCount = activityService.raiseVisitCount(UID);
		}
		
		Map<String,String> resultMap = new HashMap<>();
		if(resultCount == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}
	
}
