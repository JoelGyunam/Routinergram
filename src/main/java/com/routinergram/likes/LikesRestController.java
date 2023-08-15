package com.routinergram.likes;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.routinergram.likes.service.LikesService;

@RestController
@RequestMapping("/rest")
public class LikesRestController {

	@Autowired
	private LikesService likesService;
	
	@PostMapping("/feed/like")
	public Map<String,String> changeLike(
			@RequestParam("FID") int FID
			,@RequestParam(value="likeCount", required=false) int likeCount
			,HttpSession session
			){
		
		int UID = (int) session.getAttribute("UID");
		
		int result = likesService.changeLike(UID, FID, likeCount);
		
		Map<String,String> resultMap = new HashMap<>();
		if(result == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result","fail");
		}
		
		return resultMap;
	}
	
}
