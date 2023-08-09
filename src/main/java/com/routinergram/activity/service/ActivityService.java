package com.routinergram.activity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.routinergram.activity.domain.UserActivity;
import com.routinergram.activity.repository.ActivityRepository;

@Service
public class ActivityService {
	
	@Autowired
	private ActivityRepository activityRepository;
	
	public UserActivity getActivityInfo(int UID) {
		return activityRepository.selectUserActivity(UID);
	}
	
	public int newUserActivity(int UID) {
		return activityRepository.insertUserActivity(UID);
	}
	
	public int raiseVisitCount(int UID) {
		return activityRepository.updateVisitCount(UID);
	}
}
