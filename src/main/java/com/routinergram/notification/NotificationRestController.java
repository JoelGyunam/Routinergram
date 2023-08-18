package com.routinergram.notification;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.routinergram.notification.service.NotificationService;

@RequestMapping("/rest/myinfo/notification")
@RestController
public class NotificationRestController {

	@Autowired
	private NotificationService notificationService;
	
	@PutMapping("/reset")
	public Map<String, Integer> resetSeenNumber(HttpSession session){
		int UID = (int) session.getAttribute("UID");
		int result = notificationService.resetSeen(UID);
		
		Map<String, Integer> resultMap = new HashMap<>();
		resultMap.put("unseenNumber", result);
		return resultMap;
		
	}
	
}
