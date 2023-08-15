package com.routinergram.feed.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.routinergram.feed.domain.Feed;
import com.routinergram.feed.repository.FeedRepository;

@Service
public class FeedDetourService {

	@Autowired
	private FeedRepository feedRepository;
	
	
	public Feed selectFeedByFID(int FID) {
		
		Feed feed = new Feed();
		feed.setFID(FID);
		
		return feedRepository.selectFeedByFID(feed);
	}
	
}
