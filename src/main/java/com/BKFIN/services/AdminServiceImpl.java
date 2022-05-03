package com.BKFIN.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.BKFIN.entities.Admin;
import com.BKFIN.entities.Agent;
import com.BKFIN.entities.Client;
import com.BKFIN.entities.Role;
import com.BKFIN.repositories.AdminRepository;

@Service
public class AdminServiceImpl implements IAdminService {

	@Autowired
	AdminRepository adminR;
	 @Autowired
	    private PasswordEncoder bcryptEncoder;
	@Override
	public List<Admin> retrieveAllAdmin() {
		
		return (List<Admin>)adminR.findAll();
	}

	@Override
	public Admin addAdmin(Admin ad) {
		 ad.setPassword(bcryptEncoder.encode(ad.getPassword()));
		adminR.save(ad);
		return ad;
	}

	@Override
	public Admin updateAdmin(Admin ad) {
		adminR.save(ad);
		return ad;
	}

	@Override
	public Admin retrieveAdmin(Long id) {
		Admin a= adminR.findById(id).orElse(null);
		return a;
	}

	@Override
	public void removeAdmin(Long id) {
		adminR.deleteById(id);
		
	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Admin user = adminR.findUser(username);
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

	@Override
	public Admin loadUser(String username) {
		Admin a=adminR.findUser(username);
		return a;
	}
	

}
