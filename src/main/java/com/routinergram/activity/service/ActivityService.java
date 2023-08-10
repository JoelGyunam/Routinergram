package com.routinergram.activity.service;

import java.time.ZonedDateTime;
import java.util.Date;

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
	
	// UID 를 파라미터로 받아, getActivityInfo 로부터 userAcitivy 테이블의 정보를 객체로 받고,
	// 객체가 null 이면 insertUserActivity를 호출한다.
	public int newUserActivity(int UID) {
		
		UserActivity userActivity = getActivityInfo(UID);
		int result = 0;
		if(userActivity == null) {
			result =  activityRepository.insertUserActivity(UID);
		}
		return result;
	}
	
	// UID 를 파라미터로 받아, userAcitivy 테이블의 정보를 객체로 받고,
	// 객체 중 updatedAt과 오늘 날짜를 비교하여
	// updatedAt 날짜가 오늘 보다 전이면
	// updateVisitCount 를 호출.
	public int raiseVisitCount(int UID) {
		
		UserActivity userActivity = getActivityInfo(UID);
		int result = 0;
		
		if(userActivity == null) {
			return result;
		}
		
		Date today = new Date();
		Date lastUpdate = new Date(userActivity.getUpdatedAt().toInstant().toEpochMilli());
		
		if(today.after(lastUpdate)) {
			result = activityRepository.updateVisitCount(UID);
		}
		return result;
	}
}
