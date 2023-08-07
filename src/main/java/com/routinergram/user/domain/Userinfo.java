package com.routinergram.user.domain;

import java.util.Date;

public class Userinfo {

	private int UID;
	private String email;
	private String salt;
	private String password;
	private int NickID;
	private int ITRID;
	private String profileImage;
	private Date createdAt;
	private Date updatedAt;
	public int getUID() {
		return UID;
	}
	public void setUID(int uID) {
		UID = uID;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getNickID() {
		return NickID;
	}
	public void setNickID(int nickID) {
		NickID = nickID;
	}
	public int getITRID() {
		return ITRID;
	}
	public void setITRID(int iTRID) {
		ITRID = iTRID;
	}
	public String getProfileImage() {
		return profileImage;
	}
	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
}
