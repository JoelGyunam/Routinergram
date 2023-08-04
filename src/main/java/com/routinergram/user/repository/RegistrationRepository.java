package com.routinergram.user.repository;

import org.springframework.stereotype.Repository;

import com.routinergram.user.domain.Userinfo;

@Repository
public interface RegistrationRepository {

	public int insertUserinfo(Userinfo userinfo);
}
