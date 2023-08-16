package com.routinergram.feed.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.routinergram.feed.domain.Feed;

@Repository
public interface FeedRepository {

	public int insertFeed(Feed feed);
	
	public List<Feed> selectFeedAll();
	
	public List<Feed> selectFeedByITRID(Feed feed);
	
	public Feed selectFeedByFID(Feed feed);
	
	public List<Feed> selectFeedListByUID(int UID);
	
	public Feed selectFeedToEdit(Feed feed);
	
	public int updateFeed(Feed feed);
	
	public int deleteFeed(Feed feed);
}
