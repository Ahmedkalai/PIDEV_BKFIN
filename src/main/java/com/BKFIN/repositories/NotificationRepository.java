package com.BKFIN.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.BKFIN.entities.Complaint;
import com.BKFIN.entities.Notification;
@Repository
public interface NotificationRepository extends CrudRepository<Notification, Long> {
	
	
	
	@Query("SELECT  n FROM Notification n  WHERE n.credit.client.id= :cl")
	List<Notification> getNotificationByClient(@Param("cl") Long idClient);
}


