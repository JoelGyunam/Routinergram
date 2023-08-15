package com.routinergram.feed.service;

import java.time.ZonedDateTime;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.routinergram.activity.service.ActivityService;
import com.routinergram.common.DateCounter;
import com.routinergram.common.FileManager;
import com.routinergram.feed.domain.Feed;
import com.routinergram.feed.repository.FeedRepository;
import com.routinergram.interests.service.InterestsService;
import com.routinergram.likes.service.LikesService;
import com.routinergram.user.service.UserNicknameService;

@Service
public class FeedService {

	@Autowired
	private FeedRepository feedRepository;
	@Autowired
	private ActivityService activityService;
	@Autowired
	private UserNicknameService userNicknameService;
	@Autowired
	private InterestsService interestsService;
	@Autowired
	private LikesService likesService;
	
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
	
	public List<Feed> feedLister(List<Feed> feed,int thisUser){
		List<Feed> getList = feed;
		for(int i = 0; i < getList.size(); i++) {
			int UID = getList.get(i).getUID();
			int FID = getList.get(i).getFID();
			int ITRID = getList.get(i).getITRID();
			ZonedDateTime createdAt = getList.get(i).getCreatedAt();
			DateCounter dateCounter = new DateCounter();
			String countedDate = dateCounter.dateCounter(createdAt);
			String nickname = userNicknameService.getUserNicknameByUID(UID);
			String interestName = interestsService.getInterestName(ITRID);
			int likeCount = likesService.countLikeByFID(FID);
			boolean ifILiked = likesService.ifILiked(thisUser,FID);
			getList.get(i).setNickname(nickname);
			getList.get(i).setInterestsName(interestName);
			getList.get(i).setCountedDate(countedDate);
			getList.get(i).setLikeCount(likeCount);
			getList.get(i).setIfILiked(ifILiked);
		}
		return getList;
	}
	
	public List<Feed> listFeedsAll(int thisUser) {
		List<Feed> getList = feedRepository.selectFeedAll();
		return feedLister(getList, thisUser);
	}
	
	public List<Feed> listFeedsByITRID(int ITRID, int thisUser) {
		
		Feed feed = new Feed();
		feed.setITRID(ITRID);
		
		List<Feed> getList = feedRepository.selectFeedByITRID(feed);
		return feedLister(getList, thisUser);
	}
	

	
	public Feed getFeedToEdit(int UID, int FID) {
		
		Feed feed = new Feed();
		feed.setUID(UID);
		feed.setFID(FID);
		
		return feedRepository.selectFeedToEdit(feed);
	}
	
	public int editSubmit(int UID, int FID, String text) {
		Feed feed = new Feed();
		feed.setUID(UID);
		feed.setFID(FID);
		feed.setText(text);
		return feedRepository.updateFeed(feed);
	}
	
	public int deleteFeed(int UID, int FID) {
		Feed feed = new Feed();
		feed.setUID(UID);
		feed.setFID(FID);
		return feedRepository.deleteFeed(feed);
	}
}
