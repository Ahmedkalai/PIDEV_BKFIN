package com.BKFIN.provider;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.BKFIN.entities.Admin;
import com.BKFIN.entities.Agent;
import com.BKFIN.entities.Client;
import com.BKFIN.services.*;



public class AuthenticationProvider extends DaoAuthenticationProvider {
	
	@Autowired
	ClientServiceImpl userDetailsService;
	@Autowired
    AdminServiceImpl userDetailsService1;
	@Autowired
    AgentServiceImpl userDetailsService2;
	
    Authentication token;
	
	 @Override
	    public Authentication authenticate(Authentication authentication) {

	        UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) authentication;
	        
	        UserDetails user =null;
	        String name = auth.getName();
	        String password = auth.getCredentials().toString();
	        
	       Client c= userDetailsService.loadUser(name);
	       Agent a= userDetailsService2.loadUser(name);
	       Admin ad=userDetailsService1.loadUser(name);
	     /*  
	       if(ad!=null)
	       {
	    	    user = userDetailsService1.loadUserByUsername(auth.getName());
	       }
	       else if (c!=null)
	       {
	    	   user = userDetailsService.loadUserByUsername(auth.getName());   
	       }
	       else if (a!=null)
	       {
	    	   user = userDetailsService2.loadUserByUsername(auth.getName());   
	       }
	       */
	       if (user == null) {
	           
			    
	            throw new BadCredentialsException("Username/Password does not match for " + auth.getPrincipal());   
	        }
	       
	    	   
	            // use the credentials
	            // and authenticate against the third-party system
	            return new UsernamePasswordAuthenticationToken(
	              name, password, user.getAuthorities());
	       
	       
	    /*   String token = Jwts
					.builder()
					.setId("softtekJWT")
					.setSubject(username)
					.claim("authorities",
							grantedAuthorities.stream()
									.map(GrantedAuthority::getAuthority)
									.collect(Collectors.toList()))
					.setIssuedAt(new Date(System.currentTimeMillis()))
					.setExpiration(new Date(System.currentTimeMillis() + 600000))
					.signWith(SignatureAlgorithm.HS512,
							secretKey.getBytes()).compact();
	       System.out.println(token);*/
	    	   
    
	    }

	    @Override
	    public boolean supports(Class<?> authentication) {
	    	 return authentication.equals(UsernamePasswordAuthenticationToken.class);

	    }
	
}
