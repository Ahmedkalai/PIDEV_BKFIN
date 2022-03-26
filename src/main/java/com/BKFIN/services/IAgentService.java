package com.BKFIN.services;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.BKFIN.entities.Agent;
import com.BKFIN.entities.Client;
import com.maxmind.geoip2.exception.GeoIp2Exception;

public interface IAgentService {

	List<Agent> retrieveAllAgent();

	Agent addAgent(Agent a);

	Agent updateAgent(Agent ag);

	Agent retrieveAgent(Long id);
    
	//Agent assignUserToAgent(Long idAgent);
	
	void removeAgent(Long id);
	Agent loadUser(String username);
	 Agent getIpLocation(String ip, HttpServletRequest request) throws IOException, GeoIp2Exception;
}
