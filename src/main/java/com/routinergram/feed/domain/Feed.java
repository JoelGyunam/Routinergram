package com.routinergram.feed.domain;

import java.time.ZonedDateTime;
import java.util.List;

import com.routinergram.reply.domain.Reply;

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
	private int ITRID;
	private ZonedDateTime createdAt;
	private ZonedDateTime updatedAt;
	
	private String nickname;
	private String interestsName;
	private String countedDate;
	private String profileImage;
	private int likeCount;
	private boolean ifILiked;
	private List<Reply> replyList;
	private int replyCount;
}
