package com.routinergram.reply.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.routinergram.reply.domain.Reply;

@Repository
public interface ReplyRepository {

	public int insertReply(Reply reply);
	public List<Reply> selectReplyListByFID(@Param("FID" )int FID);
	public int deleteReplyByRPID(Reply reply);
}
