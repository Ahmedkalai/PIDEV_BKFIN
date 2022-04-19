package com.BKFIN.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.BKFIN.entities.Complaint;
import com.BKFIN.entities.Notification;
import com.BKFIN.services.INotificationService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")


@RequestMapping("/Notification")
public class NotificationController {
	
	
	@Autowired
	INotificationService notifservice;
	
	
	// http://localhost:8084/BKFIN/Notification/retrieve-all-notification
	
		@GetMapping("/retrieve-all-notification")
		@ResponseBody
		public List<Notification> getAllnotif() {
		List<Notification> listnotif = notifservice.retrieveAllNotifications();
		return  listnotif ;
		}

		// http://localhost:8084/BKFIN/Notification/retrieve-notification/1
				@GetMapping("/retrieve-notification/{notification-id}")
				@ResponseBody
				public Notification retrieveNotification(@PathVariable("notification-id") Long notifId) {
				return notifservice.retrieveNotification(notifId);
				}
				
				
				// http://localhost:8084/BKFIN/Notification/add-notification/1
				@PostMapping("/add-notification")
				@ResponseBody
				public void addNotif() 
				{
				 notifservice.addNotification();
				
				}
				
				
				// http://localhost:8084/BKFIN/Notification/retrieve-notificationByClient/1
				@GetMapping("/retrieve-notificationByClient/{client-id}")
				@ResponseBody
				public List<Notification> retrieveNotificationByclient(@PathVariable("client-id") Long notifId) {
				return notifservice.retrieveNotificationByClient(notifId);
				}
				
				
		
		
		
}
