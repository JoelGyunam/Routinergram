package com.routinergram.likes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.routinergram.feed.service.FeedDetourService;
import com.routinergram.likes.domain.Likes;
import com.routinergram.likes.repository.LikesRepository;
import com.routinergram.notification.service.NotificationService;
import com.routinergram.user.service.UserNicknameService;

@Service
public class LikesService {

	@Autowired
	private LikesRepository likesRepository;
	@Autowired
	private FeedDetourService feedDetourService;
	@Autowired
	private UserNicknameService userNicknameService;
	@Autowired
	private NotificationService notificationService;
	
	public int changeLike(int UID, int FID, int likeCount) {
		
		Likes likes = new Likes();
		int writerID = feedDetourService.selectFeedByFID(FID).getUID();
		
		likes.setUID(UID);
		likes.setFID(FID);
		likes.setWriterID(writerID);
		likes.setLikeCount(likeCount);
		
		int result = likesRepository.insertLike(likes);
		
		// 좋아요 누를 시 노티피케이션 테이블에 인서트
		int LIKD = likes.getLKID();

		if(likeCount==1 && result==1 && UID != writerID) {
			notificationService.addNotificationLine(writerID, UID, "LKID", LIKD);
		}
		
		return result;
		
	}
	
	public Integer countLikeByFID(int FID) {
		Integer result = likesRepository.sumLikeCountByFID(FID);
		if(result == null) {
			return 0;
		} else {
			return result;
		}
	}
	
	public boolean ifILiked(int UID, int FID) {
		Likes likes = new Likes();
		likes.setUID(UID);
		likes.setFID(FID);
		
		Integer result = likesRepository.selectLikesByUIDandFID(likes);
		
		return result != null && result ==1;
	}
	
	public int deleteLikesByFID(int FID) {
		return likesRepository.deleteLikesByFID(FID);
	}
	
	public Likes getLikeByLKID(int LKID) {
		
		Likes result = likesRepository.selectLikeByLKID(LKID);
		
		// 결과 엔티티에서 작성자ID 구해서 닉네임서비스에서 작성자 닉네임 결과 받아서 결과 엔티티에 닉네임 세팅 하기
		result.setWriterNickname(
				userNicknameService.getUserNicknameByUID(result.getWriterID())
				);
		
		return result;
	}
}
