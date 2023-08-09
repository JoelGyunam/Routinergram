package com.routinergram.activity.repository;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.routinergram.activity.domain.UserActivity;

@Repository
public interface ActivityRepository {

	public UserActivity selectUserActivity(@Param("UID") int UID);
	
	public int insertUserActivity(@Param("UID") int UID);
	
	public int updateVisitCount(@Param("UID") int UID);
	
}
