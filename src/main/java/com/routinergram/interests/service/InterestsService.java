package com.routinergram.interests.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.routinergram.interests.domain.Interests;
import com.routinergram.interests.repository.InterestsRepository;

@Service
public class InterestsService {

	@Autowired
	private InterestsRepository interestsRepository;
	
	public String getInterestName(int ITRID) {
		return interestsRepository.selectInterestnameByITRID(ITRID);
	}
	
	public List<Interests> getInterestList() {
		return interestsRepository.selectInterestsList();
	}
	
}
