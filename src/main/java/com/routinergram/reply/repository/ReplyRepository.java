package com.routinergram.reply.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.routinergram.reply.domain.Reply;

@Repository
public interface ReplyRepository {

	public int insertReply(Reply reply);
	public List<Reply> selectReplyListByFID(int FID);
	public Reply selectReplyByRPID(int RPID);
	public int deleteReplyByRPID(Reply reply);
	public int deleteReplyByFID(int FID);
	public int replyCountByFID(@Param("FID" )int FID);
}
