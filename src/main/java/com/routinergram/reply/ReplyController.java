package com.routinergram.reply;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.routinergram.common.ImagePlaceholder;
import com.routinergram.reply.domain.Reply;
import com.routinergram.reply.service.ReplyService;

@Controller
@RequestMapping("/main/feed/reply")
public class ReplyController {

	@Autowired
	private ReplyService replyService;
	@Autowired
	private ImagePlaceholder imagePlaceholder;
	
	@GetMapping()
	public String replyView(@RequestParam("FID")int FID, HttpSession session,Model model) {
		
		int UID = (int)session.getAttribute("UID");
		
		List<Reply> replyList = replyService.GetReplyListByFID(FID);
		
		String writerProfileImage = imagePlaceholder.profileImageInput(UID);
		
		model.addAttribute(replyList);
		model.addAttribute("FID",FID);
		model.addAttribute("writerProfileImage",writerProfileImage);
		return "feed/reply";
	}
	
	
}
