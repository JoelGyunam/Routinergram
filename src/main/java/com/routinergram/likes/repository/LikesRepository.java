package com.routinergram.likes.repository;

import org.springframework.stereotype.Repository;

import com.routinergram.likes.domain.Likes;

@Repository
public interface LikesRepository {

	public int insertLike(Likes likes);
	
	public Integer sumLikeCountByFID(int FID);
	
	public Integer selectLikesByUIDandFID(Likes likes);
	
	public int deleteLikesByFID(int FID);
}
