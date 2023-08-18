package com.routinergram.reply.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.routinergram.reply.domain.Reply;
import com.routinergram.reply.repository.ReplyRepository;

@Service
public class ReplyDetourService {

	@Autowired
	private ReplyRepository replyRepository;
	
	
	public Reply getReplyByFID(int FID) {
		if(replyRepository.selectReplyByRPID(FID) == null) {
			return null;
		}
		return replyRepository.selectReplyByRPID(FID);
	}
}
