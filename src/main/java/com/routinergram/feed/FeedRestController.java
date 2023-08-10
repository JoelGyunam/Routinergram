package com.routinergram.feed;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.routinergram.feed.domain.Feed;
import com.routinergram.feed.service.FeedService;

@RequestMapping("/rest")
@RestController
public class FeedRestController {

	@Autowired
	private FeedService feedService;
	
	@PostMapping("/myfeed/upload/submit")
	public Map<String, String> postFeed(@RequestParam("image") String image
			,@RequestParam("text") String text
			,HttpSession session) 
	{
		int UID = (int) session.getAttribute("UID");
		
		int result = feedService.postFeed(UID, image, text);
		Map<String, String> resultMap = new HashMap<>();
		
		if(result == 1) {
			resultMap.put("result","success");
		} else {
			resultMap.put("result","fail");
		}
		return resultMap;
	}
	
}
