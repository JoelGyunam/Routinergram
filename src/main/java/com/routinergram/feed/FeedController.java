package com.routinergram.feed;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.routinergram.feed.domain.Feed;
import com.routinergram.feed.service.FeedService;
import com.routinergram.interests.domain.Interests;
import com.routinergram.interests.service.InterestsService;

@Controller
@RequestMapping("/main/feed")
public class FeedController {

	@Autowired
	private FeedService feedService;
	@Autowired
	private InterestsService interestsService;

	@GetMapping()
	public String feedMainView(@RequestParam(value="ITRID", required=false)Integer ITRID
			,Model model
			,HttpSession session) {
		
		List<Feed> feedList = new ArrayList<>();
		
		if(ITRID==null) {
			feedList = feedService.listFeedsAll((int)session.getAttribute("UID"));
		} else {
			feedList = feedService.listFeedsByITRID(ITRID, (int)session.getAttribute("UID"));
		}
		
		List<Interests> interestList = interestsService.getInterestList();
		
		model.addAttribute("feedList",feedList);
		model.addAttribute("interestList",interestList);
		
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
	
	@GetMapping("/myfeed/edit")
	public String feedEditSet(int FID, HttpSession session ,Model model) {
		
		int UID = (int) session.getAttribute("UID");
		
		Feed feed = feedService.getFeedToEdit(UID, FID);
		
		model.addAttribute("feed", feed);
		return "feed/edit";
	}
}
