package com.routinergram.user.service;

import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.routinergram.activity.service.ActivityService;
import com.routinergram.interests.service.InterestsService;
import com.routinergram.user.dto.UserDetail;

@Service
public class UserDetailService {

	@Autowired
	private UserinfoService userinfoService;
	@Autowired
	private UserNicknameService userNicknameService;
	@Autowired
	private ActivityService activityService;
	@Autowired
	private InterestsService interestsService;
	

	public UserDetail getUserDetail(int UID) {
		UserDetail userDetail = new UserDetail();
		
		 String email = userinfoService.getUserInfoByUID(UID).getEmail();
		 int NickID = userinfoService.getUserInfoByUID(UID).getNickID();
		 int ITRID = userinfoService.getUserInfoByUID(UID).getITRID();
		 String profileImage = userinfoService.getUserInfoByUID(UID).getProfileImage();
		 ZonedDateTime createdAt = userinfoService.getUserInfoByUID(UID).getCreatedAt();
		 ZonedDateTime updatedAt = userinfoService.getUserInfoByUID(UID).getUpdatedAt();
		 
		 int activityUID = activityService.getActivityInfo(UID).getActivityUID();
		 int uploadCount = activityService.getActivityInfo(UID).getUploadCount();
		 int replyCount = activityService.getActivityInfo(UID).getReplyCount();
		 int visitCount = activityService.getActivityInfo(UID).getVisitCount();
		 int level = activityService.getActivityInfo(UID).getLevel();

		 String Nickname = userNicknameService.getUserNicknameByUID(UID);
		 
		 String interestName = interestsService.getInterestName(ITRID);
		
		 userDetail.setEmail(email);
		 userDetail.setNickID(NickID);
		 userDetail.setITRID(ITRID);
		 userDetail.setProfileImage(profileImage);
		 userDetail.setCreatedAt(createdAt);
		 userDetail.setUpdatedAt(updatedAt);
		 userDetail.setActivityUID(activityUID);
		 userDetail.setUploadCount(uploadCount);
		 userDetail.setReplyCount(replyCount);
		 userDetail.setVisitCount(visitCount);
		 userDetail.setLevel(level);
		 userDetail.setNickname(Nickname);
		 userDetail.setInterestName(interestName);
		 
		 return userDetail;
	}
	
}
