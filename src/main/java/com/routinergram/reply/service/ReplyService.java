package com.routinergram.reply.service;

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.routinergram.common.DateCounter;
import com.routinergram.common.ImagePlaceholder;
import com.routinergram.feed.service.FeedDetourService;
import com.routinergram.notification.service.NotificationService;
import com.routinergram.reply.domain.Reply;
import com.routinergram.reply.repository.ReplyRepository;
import com.routinergram.user.service.UserNicknameService;

@Service
public class ReplyService {

	@Autowired
	private ReplyRepository replyRepository;
	@Autowired
	private UserNicknameService userNicknameService;
	@Autowired
	private ImagePlaceholder imagePlaceholder;
	@Autowired
	private NotificationService notificationService;
	@Autowired
	private FeedDetourService feedDetourService;
	
	public int deleteReply(int UID, int RPID) {
		Reply reply = new Reply();
		reply.setUID(UID);
		reply.setRPID(RPID);
		
		return replyRepository.deleteReplyByRPID(reply);
	}
	
	public int deleteReplyByFID(int FID) {
		return replyRepository.deleteReplyByFID(FID);
	}
	
	
	public int postReply(int UID, int FID, String replyText) {
		
		Reply reply = new Reply();
		reply.setUID(UID);
		reply.setFID(FID);
		reply.setReplyText(replyText);
		
		int result = replyRepository.insertReply(reply);
		
		//댓글 작성 시 해당 글의 작성자의 노티피케이션 테이블에 인서트
		int writerUID = feedDetourService.selectFeedByFID(FID).getUID();
		int RPID = reply.getRPID();
		if(result == 1) {
			notificationService.addNotificationLine(UID, writerUID, "RPID", RPID);
		}
		
		return result;
	};
	
	public List<Reply> GetReplyListByFID(int FID){
		
		List<Reply> replyList = replyRepository.selectReplyListByFID(FID);
		
		for(int i=0; i<replyList.size(); i++) {
			int replyUID = replyList.get(i).getUID();
			String replyNickname = userNicknameService.getUserNicknameByUID(replyUID);
			replyList.get(i).setReplyNickname(replyNickname);
			ZonedDateTime writtenDateTime = replyList.get(i).getCreatedAt();
			DateCounter dataCounter = new DateCounter();
			String countedDate = dataCounter.dateCounter(writtenDateTime);
			replyList.get(i).setCountedDate(countedDate);
			String replyProfileImage = imagePlaceholder.profileImageInput(replyUID);
			replyList.get(i).setReplyProfileImage(replyProfileImage);
		}
		return replyList;
	};

	
	public int replyCountByFID(int FID) {
		return replyRepository.replyCountByFID(FID);
	}
	
}
