package com.routinergram.feed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.routinergram.feed.domain.Feed;
import com.routinergram.feed.service.FeedService;
import com.routinergram.interests.domain.Interests;
import com.routinergram.interests.service.InterestsService;
import com.routinergram.user.service.UserinfoService;

@RequestMapping("/rest")
@RestController
public class FeedRestController {

	@Autowired
	private FeedService feedService;
	@Autowired
	private UserinfoService userinfoService;
	@Autowired
	private InterestsService interestsService;
	
	@GetMapping("/loadFeed")
	public List<Feed> loadFeed(
			@RequestParam(value="ITRID", required=false)Integer ITRID
			,Model model
			,HttpSession session){
		Map<String, Object> responseData = new HashMap<>();
		
		List<Feed> feedList = new ArrayList<>();
		
		if(ITRID==null) {
			feedList = feedService.listFeedsAll((int)session.getAttribute("UID"));
		} else {
			feedList = feedService.listFeedsByITRID(ITRID, (int)session.getAttribute("UID"));
		}
		
		return feedList;
	}
	
	
	@PostMapping("/myfeed/upload/submit")
	public Map<String, String> postFeed(
			@RequestParam(value="image", required=false) MultipartFile imageFile
			,@RequestParam("text") String text
			,HttpSession session) 
	{
		int UID = (int) session.getAttribute("UID");
		int ITRID = userinfoService.getUserInfoByUID(UID).getITRID();
		
		int result = feedService.postFeed(UID, imageFile, text, ITRID);
		Map<String, String> resultMap = new HashMap<>();
		
		if(result == 1) {
			resultMap.put("result","success");
		} else {
			resultMap.put("result","fail");
		}
		return resultMap;
	}
	
	@PostMapping("/myfeed/edit/submit")
	public Map<String, String> feedEditSubmit(
			@RequestParam("FID") int FID
			,@RequestParam("text") String text
			,HttpSession session
			){
		int UID = (int) session.getAttribute("UID");
		
		int result = feedService.editSubmit(UID, FID, text);
		Map<String, String> resultMap = new HashMap<>();
		if(result == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		return resultMap;
	}
	
	@PostMapping("/myfeed/edit/del")
	public Map<String, String> deleteFeed(
			@RequestParam("FID") int FID
			,HttpSession session
			){
		int UID = (int) session.getAttribute("UID");
		int result = feedService.deleteFeed(UID, FID);
		Map<String, String> resultMap = new HashMap<>();
		if(result == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		return resultMap;
	}
}
