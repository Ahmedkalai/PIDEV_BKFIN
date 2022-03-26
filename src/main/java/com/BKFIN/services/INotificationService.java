package com.BKFIN.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.BKFIN.entities.Notification;



public interface INotificationService {
	List<Notification> retrieveAllNotifications();

	void addNotification();

	void deleteNotification(Long idNotification);

	//Notification updateNotification(Notification N , Long idCredit);

	Notification retrieveNotification(Long idNotification);
	
	List<Notification> retrieveNotificationByClient(Long idClient);
}
