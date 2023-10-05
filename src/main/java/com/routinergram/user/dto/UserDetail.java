package com.routinergram.user.dto;

import java.time.ZonedDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDetail {

	//userinfo
	private int UID;
	private String email;
	private String salt;
	private String password;
	private int NickID;
	private int ITRID;
	private String profileImage;
	private ZonedDateTime createdAt;
	private ZonedDateTime updatedAt;
	
	//userActivity
	private int activityUID;
	private int uploadCount;
	private int replyCount;
	private int visitCount;
	private int level;

	//usernickname
	private String Nickname;
	
	//interests
	private String interestName;

	
}
