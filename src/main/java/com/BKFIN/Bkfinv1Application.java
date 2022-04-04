package com.BKFIN;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@EnableScheduling
@SpringBootApplication

public class Bkfinv1Application {

	
	public static void main(String[] args) {
		SpringApplication.run(Bkfinv1Application.class, args);
	}

}
