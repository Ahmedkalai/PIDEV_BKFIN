package com.BKFIN.services;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User; 
import org.springframework.security.core.userdetails.UserDetails; 
import org.springframework.security.core.userdetails.UserDetailsService; 
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.BKFIN.entities.Admin;
import com.BKFIN.entities.Agent;
import com.BKFIN.entities.Client; 
@Service
public class JwtUserDetailsService implements UserDetailsService { 
  
	@Autowired
	ClientServiceImpl userDetailsService;
	@Autowired
    AdminServiceImpl userDetailsService1;
	@Autowired
    AgentServiceImpl userDetailsService2;
	 
	
	
	@Override 
   public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		
		 UserDetails user =null;
	       Client c= userDetailsService.loadUser(name);
	       Agent a= userDetailsService2.loadUser(name);
	       Admin ad=userDetailsService1.loadUser(name);
	       if(ad!=null)
	       { 
	    	   return user = userDetailsService1.loadUserByUsername(name);
	       }
	       else if (c!=null)
	       { 
	    	   return user = userDetailsService.loadUserByUsername(name); 
	       }
	       else if (a!=null)
	       { 
	    	   return user = userDetailsService2.loadUserByUsername(name);
	       }
	       else if ("randomuser123".equals(name)) { 
         return new User("randomuser123", 
            "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6", 
            new ArrayList<>()); 
      } else { 
         throw new UsernameNotFoundException("User not found with username: " + name); 
      } 
   }
	
	 
}