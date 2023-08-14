package com.routinergram.feed.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.routinergram.feed.domain.Feed;

@Repository
public interface FeedRepository {

	public int insertFeed(Feed feed);
	
	public List<Feed> selectFeedAll();
	
	public Feed selectFeedToEdit(Feed feed);
	
	public int updateFeed(Feed feed);
	
	public int deleteFeed(Feed feed);
}
