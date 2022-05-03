package com.BKFIN;


import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


import org.apache.catalina.filters.CorsFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableScheduling
@SpringBootApplication


public class Bkfinv1Application {
  
	/*@Bean public BCryptPasswordEncoder bCryptPasswordEncoder() {
	    return new BCryptPasswordEncoder(); 
	}*/
	
	public static void main(String[] args) {
		SpringApplication.run(Bkfinv1Application.class, args);
	}
	
	

}
