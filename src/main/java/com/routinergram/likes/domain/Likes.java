package com.routinergram.likes.domain;

import java.time.ZonedDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Likes {

	private int LKID;
	private int UID;
	private int FID;
	private int writerID;
	private int likeCount;
	private ZonedDateTime createdAt;
	private ZonedDateTime updatedAt;
	
	
}
