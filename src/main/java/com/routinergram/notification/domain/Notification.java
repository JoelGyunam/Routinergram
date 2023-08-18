package com.routinergram.notification.domain;

import java.time.ZonedDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Notification {

	private int notiID;
	private int UID;
	private int writerUID;
	private String forID;
	private int ofID;
	private int seen;
	private ZonedDateTime createdAt;
	private ZonedDateTime updatedAt;
	
}
