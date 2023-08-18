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
		if(replyRepository.selectReplyListByFID(FID).size() == 0) {
			return null;
		}
		return replyRepository.selectReplyListByFID(FID).get(0);
	}
}
