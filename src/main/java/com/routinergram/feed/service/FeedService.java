package com.routinergram.feed.service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.routinergram.activity.service.ActivityService;
import com.routinergram.common.DateCounter;
import com.routinergram.common.FileManager;
import com.routinergram.common.ImagePlaceholder;
import com.routinergram.feed.domain.Feed;
import com.routinergram.feed.repository.FeedRepository;
import com.routinergram.interests.service.InterestsService;
import com.routinergram.likes.service.LikesService;
import com.routinergram.reply.domain.Reply;
import com.routinergram.reply.repository.ReplyRepository;
import com.routinergram.reply.service.ReplyService;
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
	@Autowired
	private ReplyService replyService;
	@Autowired
	private ImagePlaceholder imagePlaceholder;
	
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
			//thisUser : 로그인한 사용자의 UID
			//UID : 피드 게시자의 UID
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
			
			//FID를 가지고 GetReplyListByFID 통해서 댓글리스트 리턴.
			//Feed DTO 에 List<Reply> 등록해서 셋 함.
			//model 내 feedList 내 replyList에 넣어주기 위함.
			List<Reply> replyList = new ArrayList<>();
			replyList = replyService.GetReplyListByFID(FID);
			getList.get(i).setReplyList(replyList);
			int replyCount = replyService.replyCountByFID(FID);
			getList.get(i).setReplyCount(replyCount);
			
			//프로필 이미지 null여부 확인 및 플레이스홀더 출력여부
			String img = imagePlaceholder.profileImageInput(UID);
			getList.get(i).setProfileImage(img);
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
	
	public List<Feed> listFeedsByUID(int UID) {
		
		List<Feed> getList = feedRepository.selectFeedListByUID(UID);
		return feedLister(getList, UID);
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
		
		feed.setFID(FID);
		int writerID = feedRepository.selectFeedByFID(feed).getUID();
		if(writerID != UID) {
			return 0;
		}
		feed.setUID(UID);
		
		String feedImage = feedRepository.selectFeedByFID(feed).getImage();
		if(feedImage == null) {
			replyService.deleteReplyByFID(FID);
			likesService.deleteLikesByFID(FID);
			return feedRepository.deleteFeed(feed);
		} else {
			if(FileManager.deleteFile(feedImage)) {
				replyService.deleteReplyByFID(FID);
				likesService.deleteLikesByFID(FID);
				return feedRepository.deleteFeed(feed);
			} else return 0;
		}
	}
}
