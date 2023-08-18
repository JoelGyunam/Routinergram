package com.routinergram.notification.dto;

import java.time.ZonedDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationDTO {

	
	private int notiID;
	private int UID;
	private int writerUID;
	private String forID;
	private int ofID;
	private int seen;
	private ZonedDateTime createdAt;
	private ZonedDateTime updatedAt;
	
	private String writerNickname;
	private String countedDate;
	private String message;
	private String messageBody;
	private int ifSeen;
	
}
