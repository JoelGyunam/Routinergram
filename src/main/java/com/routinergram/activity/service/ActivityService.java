package com.routinergram.activity.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.routinergram.activity.domain.UserActivity;
import com.routinergram.activity.repository.ActivityRepository;
import com.routinergram.common.FileManager;

@Service
public class ActivityService {
	
	@Autowired
	private ActivityRepository activityRepository;
	
	public int raiseUploadCount(int UID) {
		UserActivity userActivity = getActivityInfo(UID);
		int result = 0;
		
		if(userActivity == null) {
			return result;
		} else {
			result = activityRepository.updateUploadCount(UID);
		}
		return result;
	}
	
	
	public UserActivity getActivityInfo(int UID) {
		if(activityRepository.selectUserActivity(UID)==null) {
			return null;
		} else {
			return activityRepository.selectUserActivity(UID);
		}
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
		
		LocalDate today = LocalDate.now();
		LocalDate lastDate = userActivity.getUpdatedAt().toLocalDate();
		
		if(lastDate.isBefore(today)) {
			result = activityRepository.updateVisitCount(UID);
		}
		return result;
	}

}
