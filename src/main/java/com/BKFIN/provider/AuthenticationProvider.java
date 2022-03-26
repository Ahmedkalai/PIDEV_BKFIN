package com.BKFIN.provider;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

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

	
	 @Override
	    public Authentication authenticate(Authentication authentication) {

	        UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) authentication;
	        UserDetails user = null;
	        String name = auth.getName();
	        String password = auth.getCredentials().toString();
	        
	       Client c= userDetailsService.loadUser(name);
	       Agent a= userDetailsService2.loadUser(name);
	       Admin ad=userDetailsService1.loadUser(name);
	       
	       if(ad!=null)
	       {
	    	    user = userDetailsService1.loadUserByUsername(name);
	       }
	       else if (c!=null)
	       {
	    	   user = userDetailsService.loadUserByUsername(name);   
	       }
	       else if (a!=null)
	       {
	    	   user = userDetailsService2.loadUserByUsername(name);   
	       }
	       
	       if (user == null) {
	           
			    
	            throw new BadCredentialsException("Username/Password does not match for " + auth.getPrincipal());   
	        }
	       
             
	       
	        return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());

	    }

	    @Override
	    public boolean supports(Class<?> authentication) {
	        return true;

	    }
	
}
