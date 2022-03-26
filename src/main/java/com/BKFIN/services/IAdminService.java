package com.BKFIN.services;

import java.util.List;

import com.BKFIN.entities.Admin;
import com.BKFIN.entities.Agent;

public interface IAdminService {
	List<Admin> retrieveAllAdmin();

	Admin addAdmin(Admin ad);

	Admin updateAdmin(Admin ad);

	Admin retrieveAdmin(Long id);

	void removeAdmin(Long id);
	 public Admin loadUser(String username);
}
