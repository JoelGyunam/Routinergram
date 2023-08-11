package com.routinergram.feed;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.routinergram.feed.domain.Feed;
import com.routinergram.feed.service.FeedService;

@Controller
@RequestMapping("/main/feed")
public class FeedController {

	@Autowired
	private FeedService feedService;

	
	
	@GetMapping()
	public String feedMainView(Model model) {
		
		List<Feed> feedList = feedService.listFeedsAll();
		
		model.addAttribute(feedList);
		
		return "feed/feed";
	}
	
	@GetMapping("/myfeed")
	public String myfeedView() {
		return "feed/myfeed";
	}
	
	@GetMapping("/myfeed/upload")
	public String feedUpload() {
		return "feed/upload";
	}
}
