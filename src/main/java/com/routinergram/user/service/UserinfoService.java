package com.routinergram.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.routinergram.common.Encrypt;
import com.routinergram.common.FileManager;
import com.routinergram.user.domain.Userinfo;
import com.routinergram.user.repository.UserinfoRepository;

@Service
public class UserinfoService {

	@Autowired
	private UserinfoRepository userinfoRepository;
	
	public Userinfo getByEmail(String email) {
		return userinfoRepository.selectByEmail(email);
	}
	
	public int updateNickIDbyUID(int NickID, int UID) {
		Userinfo userinfo = new Userinfo();
		userinfo.setUID(UID);
		userinfo.setNickID(NickID);
		
		return userinfoRepository.updateNickIDByUID(userinfo);
	}
	
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
	
	public int editPW(int UID, String currentPW, String changePW) {
		
		String email = getUserInfoByUID(UID).getEmail();
		
		Userinfo userinfo = new Userinfo();
		userinfo.setEmail(email);
		userinfo.setPassword(currentPW);
		userinfo = loginRequest(userinfo);
		if(userinfo.getUID()==0) {
			return 0;
		}
		
		Encrypt encrypt = new Encrypt();
		String salt = encrypt.getSalt();
		String encPassword = Encrypt.getEncrypt(changePW,salt);
		
		userinfo.setSalt(salt);
		userinfo.setPassword(encPassword);
		
		return userinfoRepository.updatePW(userinfo);
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
	
	public int changeProfileImage(int UID, MultipartFile imageFile) {
		
		String imagePath = FileManager.saveFile(UID, imageFile);
		Userinfo userinfo = new Userinfo();
		userinfo.setUID(UID);
		userinfo.setProfileImage(imagePath);
		
		return userinfoRepository.updateProfileImageByUID(userinfo);
	}
	
	public int deleteProfileImage(int UID) {
		String imagePath = getUserInfoByUID(UID).getProfileImage();
		int updateResult = userinfoRepository.deleteProfileImage(UID);
		boolean deleteResult = FileManager.deleteFile(imagePath);
		return updateResult;
		
	}
	
	public int updateITRIDbyUID(int UID, int ITRID) {
		Userinfo userinfo = new Userinfo();
		userinfo.setUID(UID);
		userinfo.setITRID(ITRID);
		return userinfoRepository.updateITRIDbyUID(userinfo);
	}
	
}
