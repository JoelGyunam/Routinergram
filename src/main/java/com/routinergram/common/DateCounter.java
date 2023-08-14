package com.routinergram.common;

import java.time.Duration;
import java.time.ZonedDateTime;

public class DateCounter {

	public String dateCounter(ZonedDateTime targetDate) {
		ZonedDateTime now = ZonedDateTime.now();
		
		Duration duration = Duration.between(targetDate, now);
		
		long minutes = duration.toMinutes();
		long hours = duration.toHours();
		long days = duration.toDays();
		
		//n분 전
		//120분 미만 일 경우
		if(minutes < 120) {
			return minutes + "분 전";
		} else if(hours < 24) {
			return hours + "시간 전";
		} else {
			return days + "일 전";
		}
		
		//n시간 전
		//24시간 미만일 경우
		
		//n일 전

		
		
	}
}
