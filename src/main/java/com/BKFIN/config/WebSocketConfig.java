package com.BKFIN.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
@ComponentScan("com.BKFIN.controllers")
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

	@Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/chat/register").withSockJS();
		registry.addEndpoint("/chat/send").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
    	 registry.enableSimpleBroker("/topic");
    	 registry.setApplicationDestinationPrefixes("/BKFIN");
    	  //registry.setUserDestinationPrefix("/secured/user");
    }
    @Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }
}
