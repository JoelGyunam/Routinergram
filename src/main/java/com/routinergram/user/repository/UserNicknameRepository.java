package com.routinergram.user.repository;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.routinergram.user.domain.UserNickname;

@Repository
public interface UserNicknameRepository {

	public int nicknameSelect(@Param("nickname") String nickname);
	
	public int insertNickname(UserNickname userNickname);
	
}
