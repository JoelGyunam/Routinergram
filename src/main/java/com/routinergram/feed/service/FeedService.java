package com.routinergram.feed.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.routinergram.activity.service.ActivityService;
import com.routinergram.feed.domain.Feed;
import com.routinergram.feed.repository.FeedRepository;

@Service
public class FeedService {

	@Autowired
	private FeedRepository feedRepository;
	@Autowired
	private ActivityService activityService;
	
	public int postFeed(int UID, String image, String text) {
		int level = activityService.getActivityInfo(UID).getLevel();

		Feed feed = new Feed();

		feed.setUID(UID);
		feed.setImage(image);
		feed.setText(text);
		feed.setLevelValue(level);
		
		return feedRepository.insertFeed(feed);
	}
}
