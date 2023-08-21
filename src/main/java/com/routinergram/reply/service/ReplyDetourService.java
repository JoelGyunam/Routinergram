package com.routinergram.reply.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.routinergram.reply.domain.Reply;
import com.routinergram.reply.repository.ReplyRepository;

@Service
public class ReplyDetourService {

	@Autowired
	private ReplyRepository replyRepository;
	
	
	public Reply getReplyByRPID(int RPID) {
		if(replyRepository.selectReplyByRPID(RPID) == null) {
			return null;
		}
		return replyRepository.selectReplyByRPID(RPID);
	}
}
