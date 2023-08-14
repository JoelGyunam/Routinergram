package com.routinergram.interests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.routinergram.interests.service.InterestsService;

@RequestMapping("/rest/itr")
@RestController
public class InterestsRestController {
	@Autowired
	private InterestsService interestsService;
	
	@GetMapping("/list")
	@PostMapping("/list")
	public List<Map<Object,String>> getInterestName(){
		Map<Object, String> resultMap = new HashMap<>();
		Map<Object, String> listMap = new HashMap<>();
		List<Map<Object,String>> resultList = new ArrayList<>();
		
		if(interestsService.getInterestList() != null) {
			resultMap.put("result", "success");
			resultList.add(resultMap);
			for(int i = 0; i < interestsService.getInterestList().size(); i++) {
				listMap.put(interestsService.getInterestList().get(i).getITRID()
						, interestsService.getInterestList().get(i).getInterestName());
			}
			resultList.add(listMap);
		} else {
			resultMap.put("result","fail");
			resultList.add(resultMap);
		}
		return resultList;
	}
}
