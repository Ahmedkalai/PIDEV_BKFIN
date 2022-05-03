package com.BKFIN.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.BKFIN.services.IClientService;
import com.BKFIN.entities.*;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/Client")
public class ClientController {
	@Autowired
	IClientService ClientService;
	
	@GetMapping("/getClients")
	@ResponseBody
	public List<Client> getClients() {
	List<Client> list= ClientService.retrieveAllClient();
	return list;
	}	    
    
	//http://localhost:8083/BKFIN/Client/insertClient/{id}
	@PostMapping("/insertClient/{id}")
	@ResponseBody
	public Client AjoutClient (@RequestBody Client c, @PathVariable("id") Long idAgent)
	{
		return ClientService.addClient(c,idAgent) ;
	}
	//http://localhost:8083/BKFIN/Client/getClient/{id}
	@GetMapping("/getClient/{id}")
	@ResponseBody
	public Client getClient( @PathVariable("id") Long idClient) {
	Client c= ClientService.retrieveClient(idClient);
	return c;
	}	   
		
  
	
	@DeleteMapping("/DeleteClient/{cin}")
	@ResponseBody
	public void deleteUser(@PathVariable("cin") long CinClient)
	{
		ClientService.removeClient(CinClient);
	}  
	  

}
