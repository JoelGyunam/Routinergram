package com.routinergram.interests.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.routinergram.interests.domain.Interests;

@Repository
public interface InterestsRepository {

	public String selectInterestnameByITRID(int ITRID);
	
	public List<Interests> selectInterestsList();
}
