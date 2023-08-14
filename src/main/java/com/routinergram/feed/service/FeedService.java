package com.routinergram.feed.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.routinergram.activity.service.ActivityService;
import com.routinergram.common.FileManager;
import com.routinergram.feed.domain.Feed;
import com.routinergram.feed.repository.FeedRepository;
import com.routinergram.user.service.UserNicknameService;

@Service
public class FeedService {

	@Autowired
	private FeedRepository feedRepository;
	@Autowired
	private ActivityService activityService;
	@Autowired
	private UserNicknameService userNicknameService;
	
	public int postFeed(int UID, MultipartFile imageFile, String text, int ITRID) {
		int level = activityService.getActivityInfo(UID).getLevel();

		Feed feed = new Feed();
		
		String imagePath = FileManager.saveFile(UID, imageFile);

		feed.setUID(UID);
		feed.setImage(imagePath);
		feed.setText(text);
		feed.setLevelValue(level);
		feed.setITRID(ITRID);
		
		return feedRepository.insertFeed(feed);
	}
	
	public List<Feed> listFeedsAll() {
		List<Feed> getList = feedRepository.selectFeedAll();
		
		for(int i = 0; i < getList.size(); i++) {
			int UID = getList.get(i).getUID();
			String nickname = userNicknameService.getUserNicknameByUID(UID);
			getList.get(i).setNickname(nickname);
		}
		
		return getList;
	}
}
