package com.routinergram.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.routinergram.user.repository.UserinfoRepository;

@Component
public class ImagePlaceholder {

	@Autowired
	private UserinfoRepository userinfoRepository;
	
	public String profileImageInput(int UID) {
		
		String setLocation = "";
		String getImageLocation = userinfoRepository.selectUserInfoByUID(UID).getProfileImage();
		
		if(getImageLocation == null || getImageLocation.isEmpty() || getImageLocation == "") {
			setLocation = "/static/img/People_circle_big.png";
		} else {
			setLocation = getImageLocation;
		}
		return setLocation;
	}
}
