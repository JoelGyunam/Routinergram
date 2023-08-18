package com.routinergram.notification.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.routinergram.notification.domain.Notification;

@Repository
public interface NotificationRepository {

	public List<Notification> selectNotificationListByUID(int UID);
	public int insertNotificationFor (Notification notification);
	public int updateSeen(int UID);
	public int countUnseen(int UID);
}
