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

	
	public static void main(String[] args) {
		SpringApplication.run(Bkfinv1Application.class, args);
	}

}
