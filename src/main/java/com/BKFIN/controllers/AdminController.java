package com.BKFIN.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.BKFIN.entities.Admin;
import com.BKFIN.services.IAdminService;

@RestController
@RequestMapping("/Admin")
public class AdminController {

	@Autowired
	IAdminService AdminService;
	
	@GetMapping("/Admins")
	@ResponseBody
	public List<Admin> getAdmins() {
	List<Admin> list= AdminService.retrieveAllAdmin();
	return list;
	}	    
    
	
	@PostMapping("/AjoutAdmin")
	@ResponseBody
	public Admin AjoutAdmin (@RequestBody Admin a)
	{
		return AdminService.addAdmin(a) ;
	}
		
		
  
	
	@DeleteMapping("/DeleteAdmin/{id}")
	@ResponseBody
	public void deleteUser(@PathVariable("id") long IdAdmin)
	{
		AdminService.removeAdmin(IdAdmin);
	}  
}
