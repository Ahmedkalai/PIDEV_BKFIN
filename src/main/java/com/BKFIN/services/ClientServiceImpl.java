package com.BKFIN.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.BKFIN.entities.Agent;
import com.BKFIN.entities.Client;
import com.BKFIN.entities.Role;
import com.BKFIN.repositories.AgentRepository;
import com.BKFIN.repositories.ClientRepository;

@Service

public class ClientServiceImpl implements IClientService {

	@Autowired
	ClientRepository clientR;
	@Autowired
	AgentRepository agentR;
	 @Autowired
	    private PasswordEncoder bcryptEncoder;
	@Override
	public List<Client> retrieveAllClient() {
		
		return (List<Client>)clientR.findAll()  ;
		
	}

	@Override
	public Client addClient(Client c, Long idAgent) {
		Agent a = agentR.findById(idAgent).orElse(null);
		c.setAgent(a);
		 c.setPassword(bcryptEncoder.encode(c.getPassword()));
		//c.setRole();
		clientR.save(c);
		return c ;
	}

	@Override
	public Client updateClient(Client c) {
		clientR.save(c);
		return c ;
		
	}

	@Override
	public Client retrieveClient(Long id) {
		Client c = clientR.findById(id).orElse(null);
		
		return c;
	}

	@Override
	public void removeClient(Long id) {
		clientR.deleteById(id);
		
	}


	@Override
	public Client loadUser(String username) {
		Client user = clientR.findUser(username);
		
		return user;
	}
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Client user = clientR.findUser(username);
		 List<GrantedAuthority> authorities = getUserAuthority(user.getRoles());
		 return new org.springframework.security.core.userdetails.User(user.getEmail(),
		user.getPassword(),true, true, true, true, authorities); 
	}
	private List<GrantedAuthority> getUserAuthority(Set<Role> userRoles) {
		 Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
		 for (Role role : userRoles) {
		 roles.add(new SimpleGrantedAuthority(role.getRole().getAuthority())); }
		 List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
		 return grantedAuthorities;
		 }

	

}
