package com.routinergram.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.routinergram.user.domain.UserNickname;
import com.routinergram.user.repository.UserNicknameRepository;

@Service
public class UserNicknameService {

	@Autowired
	private UserNicknameRepository userNicknameRepository;
	
	public int countNickname(String nickname) {
		return  userNicknameRepository.nicknameCount(nickname);
	}
	
	public int addNickname(UserNickname userNickname) {
		return userNicknameRepository.insertNickname(userNickname);
	}
	
	public int setNickname(UserNickname userNickname) {
		return userNicknameRepository.updateNickname(userNickname);
	}
	
	public String getUserNicknameByNickID(int NickID) {
		return userNicknameRepository.selectNicknameByNickID(NickID);
	}
}
