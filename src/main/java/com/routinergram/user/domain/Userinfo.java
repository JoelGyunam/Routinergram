package com.routinergram.user.domain;

import java.time.ZonedDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Userinfo {

	private int UID;
	private String email;
	private String salt;
	private String password;
	private int NickID;
	private int ITRID;
	private String profileImage;
	private ZonedDateTime createdAt;
	private ZonedDateTime updatedAt;
	
	
	
}
