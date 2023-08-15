package com.routinergram.reply;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.routinergram.reply.service.ReplyService;

@RestController
@RequestMapping("/rest/reply")
public class ReplyRestController {

	@Autowired
	private ReplyService replyService;
	
	public Map<String, String> replyPost(@RequestParam("FID")int FID, HttpSession session){
		int UID = (int) session.getAttribute("UID");
		int result = replyService.postReply(UID, FID);
		
		Map<String, String> resultMap = new HashMap<>();
		if(result == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		return resultMap;
	}
	
	@DeleteMapping("/delete")
	public Map<String, String> replyDelete(@RequestParam("RPID")int RPID, HttpSession session){
		int UID = (int) session.getAttribute("UID");
		int result = replyService.deleteReply(UID, RPID);
		Map<String, String> resultMap = new HashMap<>();
		if(result == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		return resultMap;
	}
}
