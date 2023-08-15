package com.routinergram.likes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.routinergram.feed.service.FeedDetourService;
import com.routinergram.likes.domain.Likes;
import com.routinergram.likes.repository.LikesRepository;

@Service
public class LikesService {

	@Autowired
	private LikesRepository likesRepository;
	@Autowired
	private FeedDetourService feedDetourService;
	
	public int changeLike(int UID, int FID, int likeCount) {
		
		Likes likes = new Likes();
		int writerID = feedDetourService.selectFeedByFID(FID).getUID();
		
		likes.setUID(UID);
		likes.setFID(FID);
		likes.setWriterID(writerID);
		likes.setLikeCount(likeCount);
		
		return likesRepository.insertLike(likes);
		
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
}
