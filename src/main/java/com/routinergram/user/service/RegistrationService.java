package com.routinergram.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.routinergram.common.Encrypt;
import com.routinergram.user.domain.Userinfo;
import com.routinergram.user.repository.RegistrationRepository;

@Service
public class RegistrationService {

	@Autowired
	private RegistrationRepository registrationRepository;
	
	public int registrationRequest(Userinfo userinfo) {
		
		String salt = Encrypt.getSalt();
		String encPassword = Encrypt.getEncrypt(userinfo.getPassword(),salt);
		
		userinfo.setPassword(encPassword);
		
		return registrationRepository.insertUserinfo(userinfo);
	}
	
}
