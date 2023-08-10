package com.routinergram.feed.repository;

import org.springframework.stereotype.Repository;

import com.routinergram.feed.domain.Feed;

@Repository
public interface FeedRepository {

	public int insertFeed(Feed feed);
	
}
