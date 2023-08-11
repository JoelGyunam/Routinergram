package com.routinergram.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.routinergram.common.Encrypt;
import com.routinergram.user.domain.Userinfo;
import com.routinergram.user.repository.UserinfoRepository;

@Service
public class UserinfoService {

	@Autowired
	private UserinfoRepository userinfoRepository;
	
	public Userinfo getUserInfoByUID(int UID) {
		return userinfoRepository.selectUserInfoByUID(UID);
	}
	
	public int registrationRequest(Userinfo userinfo) {
		
		Encrypt encrypt = new Encrypt();
		String salt = encrypt.getSalt();
		String encPassword = Encrypt.getEncrypt(userinfo.getPassword(),salt);
		
		userinfo.setSalt(salt);
		userinfo.setPassword(encPassword);
		
		return userinfoRepository.insertUserinfo(userinfo);
	}
	
	public Userinfo loginRequest(Userinfo userinfo) {
		
		String getSalt = userinfoRepository.selectSalt(userinfo.getEmail());
		String encPassword = Encrypt.getEncrypt(userinfo.getPassword(),getSalt);
		
		userinfo.setPassword(encPassword);
		
		return userinfoRepository.loginSelect(userinfo);
	}
	
	public int emailDupCheck(Userinfo userinfo) {
		return userinfoRepository.countEmail(userinfo);
	}
	
}
