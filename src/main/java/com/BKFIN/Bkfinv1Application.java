package com.BKFIN;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.BKFIN.services.EventService;
import com.BKFIN.services.InvestesmentService;



@EnableScheduling
@SpringBootApplication
public class Bkfinv1Application {


	@Autowired
	private EventService eventService;
	
	public static void main(String[] args) {
		SpringApplication.run(Bkfinv1Application.class, args);
	}
//	@EventListener(ApplicationReadyEvent.class)
	//public void sendMail() throws MessagingException {
		//eventService.sendEmail("khadija.azzouz@esprit.tn", "BKfIN Team", "Thank you for your participation","C:\\Users\\Asus\\Desktop\\PI\\BKFIN.png");
	//}
}
