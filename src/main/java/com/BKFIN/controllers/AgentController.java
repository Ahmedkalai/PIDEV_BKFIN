package com.BKFIN.controllers;

import java.io.IOException;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.BKFIN.entities.ClassEnum;
import com.BKFIN.services.IAgentService;
import com.maxmind.geoip2.exception.GeoIp2Exception;

@CrossOrigin(origins = "http://localhost:4200")
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
	
	
	@GetMapping("/Agents9box/{class}")
	@ResponseBody
	public List<Agent> getAgentsClasse(@PathVariable("class") ClassEnum Per) {
	List<Agent> list= AgentService.retrieveAgentByClass(Per);
	return list;
	}	  
	@GetMapping("/9box/{id}/{per}/{pot}")
	@ResponseBody
	public Agent Talent(@PathVariable("id") long IdAgent,@PathVariable("per") String Per,@PathVariable("pot") String Pot) {
	Agent user= AgentService.SaveClassification9box(Per,Pot, IdAgent);
	return user;
	}	    
	@GetMapping("/9boxClass/{id}")
	@ResponseBody
	public ClassEnum Classification(@PathVariable("id") long IdAgent) {
	ClassEnum user = AgentService.GetClassification9box( IdAgent);
	return user;
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
