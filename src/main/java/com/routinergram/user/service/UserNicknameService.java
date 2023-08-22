package com.routinergram.user.service;

import java.util.List;

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
	
	public String getUserNicknameByUID(int UID) {
		return userNicknameRepository.selectNicknameByUID(UID);
	}
	
	public int resetNickname(int NickID) {
		return userNicknameRepository.deleteNicknameByNickID(NickID);
	}
	
	public int deletePreviousNicknamesByUID(int UID) {
		List<UserNickname> nicknameList = userNicknameRepository.selectNicknameListByUID(UID);
		int resultSum = 0;
//		if(nicknameList.size() <= 1) {
//			return 0;
//		}
		for(int i = 1; i < nicknameList.size(); i++) {
			resultSum += userNicknameRepository.deleteNicknameByNickID(nicknameList.get(i).getNickID());
		}
		return resultSum;
	}
}
