package com.routinergram.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.routinergram.common.Encrypt;
import com.routinergram.user.domain.Userinfo;
import com.routinergram.user.repository.UserinfoRepository;

@Service
public class UserinfoService {

	@Autowired
	private UserinfoRepository userinfoRepository;
	
	public int registrationRequest(Userinfo userinfo) {
		
		String salt = Encrypt.getSalt();
		String encPassword = Encrypt.getEncrypt(userinfo.getPassword(),salt);
		
		userinfo.setPassword(encPassword);
		
		return userinfoRepository.insertUserinfo(userinfo);
	}
	
	public Userinfo loginRequest(Userinfo userinfo) {
		String salt = Encrypt.getSalt();
		String encPassword = Encrypt.getEncrypt(userinfo.getPassword(),salt);
		
		userinfo.setPassword(encPassword);
		
		return userinfoRepository.loginSelect(userinfo);
	}
	
	public int emailDupCheck(Userinfo userinfo) {
		return userinfoRepository.countEmail(userinfo);
	}
	
}
