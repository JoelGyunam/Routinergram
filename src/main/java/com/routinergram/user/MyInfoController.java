package com.routinergram.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.routinergram.common.ImagePlaceholder;
import com.routinergram.interests.service.InterestsService;
import com.routinergram.user.service.UserNicknameService;
import com.routinergram.user.service.UserinfoService;

@Controller
@RequestMapping("/main/myinfo")
public class MyInfoController {
	
	@Autowired
	private ImagePlaceholder imagePlaceholder;
	@Autowired
	private UserNicknameService userNicknameService;
	@Autowired
	private UserinfoService userinfoService;
	@Autowired
	private InterestsService interestsService;
	
	
	@GetMapping()
	public String myinfoMain(HttpSession session,Model model) {
		
		int UID = (int) session.getAttribute("UID");
		
		String profileImage = imagePlaceholder.profileImageInput(UID);
		String nickname = userNicknameService.getUserNicknameByUID(UID);  
		int ITRID = userinfoService.getUserInfoByUID(UID).getITRID();
		String ITRname = interestsService.getInterestName(ITRID);
		
		model.addAttribute("profileImage", profileImage);
		model.addAttribute("nickname", nickname);
		model.addAttribute("ITRname", ITRname);
		
		
		return "myinfo/myinfoMain";
	}
	
	@GetMapping("/editPW")
	public String editPW() {
		return"myinfo/editPW";
	}
	
}
