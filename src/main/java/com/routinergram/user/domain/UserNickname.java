package com.routinergram.user.domain;

import java.util.Date;

public class UserNickname {

	private int NickID;
	private String nickname;
	private int UID;
	private Date createdAt;
	private Date updatedAt;
	
	public int getNickID() {
		return NickID;
	}
	public void setNickID(int nickID) {
		NickID = nickID;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getUID() {
		return UID;
	}
	public void setUID(int uID) {
		UID = uID;
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
