package com.routinergram.reply.domain;

import java.time.ZonedDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Reply {
	private int RPID;
	private String replyText;
	private int FID;
	private int UID;
	private ZonedDateTime createdAt;
	private ZonedDateTime updatedAt;
	
	private String replyNickname;
	private String countedDate;
	private String replyProfileImage;
}