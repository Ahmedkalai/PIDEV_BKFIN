package com.BKFIN.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.BKFIN.entities.Admin;
import com.BKFIN.entities.Agent;
import com.BKFIN.entities.Client;
import com.BKFIN.entities.JwtRequestModel;
import com.BKFIN.entities.JwtResponseModel;
import com.BKFIN.provider.TokenManager;
import com.BKFIN.services.AdminServiceImpl;
import com.BKFIN.services.AgentServiceImpl;
import com.BKFIN.services.ClientServiceImpl;
import com.BKFIN.services.JwtUserDetailsService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {
	@Autowired
	ClientServiceImpl userDetailsService3;
	@Autowired
    AdminServiceImpl userDetailsService1;
	@Autowired
    AgentServiceImpl userDetailsService2;
	 @Autowired
	   private JwtUserDetailsService userDetailsService;
	 @Autowired
	   private AuthenticationManager authenticationManager;
	   @Autowired
	   private TokenManager tokenManager;
	   @PostMapping("/login")
	   public ResponseEntity<JwtResponseModel> createToken(@RequestBody JwtRequestModel
	   request) throws Exception {
	      try {
	         authenticationManager.authenticate(
	            new
	            UsernamePasswordAuthenticationToken(request.getUsername(),
	            request.getPassword())
	         );
	      } catch (DisabledException e) {
	         throw new Exception("USER_DISABLED", e);
	      } catch (BadCredentialsException e) {
	         throw new Exception("INVALID_CREDENTIALS", e);
	      }
	      
	      final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
	      final String jwtToken = tokenManager.generateJwtToken(userDetails);
	      return ResponseEntity.ok(new JwtResponseModel(jwtToken));
	   }
	   
	   @GetMapping(value = "findClientByToken")
	    public Client findUserByToken() {
	        return   userDetailsService3.loadUser(SecurityContextHolder.getContext().getAuthentication().getName()) ;
	    }
	   @GetMapping(value = "findAgentByToken")
	    public Agent findAgentByToken() {
	        return   userDetailsService2.loadUser(SecurityContextHolder.getContext().getAuthentication().getName()) ;
	    }
	   @GetMapping(value = "findAdminByToken")
	    public Admin findAdminByToken() {
		   System.out.print(SecurityContextHolder.getContext().getAuthentication().getName());
	        return   userDetailsService1.loadUser(SecurityContextHolder.getContext().getAuthentication().getName()) ;
	    }
	
}
