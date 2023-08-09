package com.routinergram.activity.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserActivity {

	private int activityUID;
	private int UID;
	private int uploadCount;
	private int replyCount;
	private int visitCount;
	private int level;
	private Date createdAt;
	private Date updatedAt;
	
}
