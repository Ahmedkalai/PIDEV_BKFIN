package com.BKFIN.services;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.BKFIN.entities.*;



public interface IClientService {
	List<Client> retrieveAllClient();

	Client addClient(Client c, Long idAgent);

	Client updateClient(Client c);

	Client retrieveClient(Long id);
	
	void removeClient(Long id);

	UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
	Client loadUser(String username);
}
