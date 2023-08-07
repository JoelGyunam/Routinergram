package com.routinergram.feed;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main/feed")
public class FeedController {

	@GetMapping()
	public String feedMainView() {
		return "feed/feed";
	}
}
