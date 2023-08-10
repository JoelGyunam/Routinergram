package com.routinergram.feed.domain;

import java.time.ZonedDateTime;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Feed {

	private int FID;
	private String image;
	private String text;
	private int levelValue;
	private int UID;
	private ZonedDateTime createdAt;
	private ZonedDateTime updatedAt;
	
	
}
