package com.routinergram.user.repository;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.routinergram.user.domain.Userinfo;

@Repository
public interface UserinfoRepository {

	public int insertUserinfo(Userinfo userinfo);
	
	public Userinfo loginSelect(Userinfo userinfo);
	
	public int countEmail(Userinfo userinfo);
	
}