package com.routinergram.notification.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.routinergram.common.DateCounter;
import com.routinergram.likes.repository.LikesRepository;
import com.routinergram.notification.domain.Notification;
import com.routinergram.notification.dto.NotificationDTO;
import com.routinergram.notification.repository.NotificationRepository;
import com.routinergram.reply.service.ReplyDetourService;
import com.routinergram.user.service.UserNicknameService;

@Service
public class NotificationService {

	@Autowired
	private NotificationRepository notificationRepository;
	@Autowired
	private ReplyDetourService replyDetourService;
	@Autowired
	private UserNicknameService userNicknameService;
	@Autowired
	private LikesRepository likesRepository;
	
	public List<NotificationDTO> getNotificationsByUID(int UID){
		
		List<Notification> resultDomainList = notificationRepository.selectNotificationListByUID(UID);
		List<NotificationDTO> resultList = new ArrayList<>();
		
		DateCounter dateCounter = new DateCounter();
		
		for(int i = 0; i < resultDomainList.size(); i++) {
			NotificationDTO notificationDTO = new NotificationDTO();
			String forID = resultDomainList.get(i).getForID();
			int ofID = resultDomainList.get(i).getOfID();
			notificationDTO.setCountedDate(dateCounter.dateCounter(resultDomainList.get(i).getCreatedAt())); //남은 일수 DTO 세팅
			notificationDTO.setIfSeen(resultDomainList.get(i).getSeen()); //확인여부 DTO 세팅
			notificationDTO.setWriterNickname(userNicknameService.getUserNicknameByUID(resultDomainList.get(i).getWriterUID())); // 작성자 닉네임 DTO 세팅
			
			if(forID.equals("LKID")) {
				notificationDTO.setMessage("내 게시글에 좋아요를 눌러줬어요!"); // 좋아요 눌렀음 메세지 DTO 세팅
				notificationDTO.setFID(likesRepository.selectLikeByLKID(ofID).getFID());
				
			} else if(forID.equals("RPID")) {
				notificationDTO.setMessage("내 게시글에 댓글을 달았어요!"); // 좋아요 눌렀음 메세지 DTO 세팅
				notificationDTO.setMessageBody(replyDetourService.getReplyByRPID(ofID).getReplyText());
				notificationDTO.setFID(replyDetourService.getReplyByRPID(ofID).getFID());
			};
			resultList.add(notificationDTO);
		}
		return resultList;
	}
	
	public int addNotificationLine(int UID, int writerUID, String forID, int ofID) {
		Notification notification = new Notification();
		notification.setUID(UID);
		notification.setWriterUID(writerUID);
		notification.setForID(forID);
		notification.setOfID(ofID);
		return notificationRepository.insertNotificationFor(notification);
	}
	
	public int resetSeen(int UID) {
		return notificationRepository.updateSeen(UID);
	}
	
	public int countUnseen(int UID) {
		return notificationRepository.countUnseen(UID);
	}
}

