package com.BKFIN.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.BKFIN.entities.Agent;
import com.BKFIN.services.IAgentService;
import com.maxmind.geoip2.exception.GeoIp2Exception;

@RestController
@RequestMapping("/Agent")
public class AgentController {
	@Autowired
	IAgentService AgentService;
	

	@GetMapping("/Agents")
	@ResponseBody
	public List<Agent> getAgents() {
	List<Agent> list= AgentService.retrieveAllAgent();
	return list;
	}	    
    
	//http://localhost:8083/BKFIN/Agent/AddAgent
	@PostMapping("/AddAgent")
	@ResponseBody
	public Agent AjoutAgent (@RequestBody Agent a)
	{
		return AgentService.addAgent(a) ;
	}
	//http://localhost:8083/BKFIN/Agent/assignClientToAgent/{id}
	/*@PutMapping("/assignClientToAgent/{id}")
	@ResponseBody
	public Agent assignClientToAgent (@RequestBody Agent a, @PathVariable("id") Long idAgent)
	{
		return AgentService.assignUserToAgent(idAgent) ;
		
	}*/
		
  
	
	@DeleteMapping("/DeleteAgent/{id}")
	@ResponseBody
	public void deleteUser(@PathVariable("id") long IdAgent)
	{
		AgentService.removeAgent(IdAgent);
	}  
	
	//http://localhost:8083/BKFIN/Agent/geoIP/{ipAddress}
	 @GetMapping("/geoIP/{ipAddress}")
	    public Agent getLocation(@PathVariable String ipAddress, HttpServletRequest request) throws IOException, GeoIp2Exception {
	        return  AgentService.getIpLocation(ipAddress, request);
	    }
	

}
