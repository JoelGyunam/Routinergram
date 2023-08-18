package com.routinergram.notification;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.routinergram.notification.service.NotificationService;

@Controller
@RequestMapping("/main/myinfo/notification")
public class NotificationController {

	@Autowired
	private NotificationService notificationService;
	
	@GetMapping()
	public String notificationMainView(HttpSession session, Model model) {
		
		int UID = (int) session.getAttribute("UID");
		
		
		model.addAttribute("notificationList",notificationService.getNotificationsByUID(UID));
		model.addAttribute("unseenNumber",notificationService.countUnseen(UID));
		
		return "myinfo/notification";
	}
	
}
