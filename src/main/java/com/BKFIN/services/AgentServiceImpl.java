package com.BKFIN.services;

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.BKFIN.entities.Agent;
import com.BKFIN.entities.ClassEnum;
import com.BKFIN.entities.Client;
import com.BKFIN.entities.Role;
//import com.BKFIN.entities.Client;
import com.BKFIN.repositories.AgentRepository;
import com.BKFIN.repositories.ClientRepository;
import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;



@Service
public class AgentServiceImpl implements IAgentService,UserDetailsService {

	@Autowired
	AgentRepository agentR;
	@Autowired
	ClientRepository clientR;
	
	private final DatabaseReader databaseReader;
	
    
    
	
	public AgentServiceImpl(DatabaseReader databaseReader) {
		super();
		this.databaseReader = databaseReader;
	}

	@Override
	public List<Agent> retrieveAllAgent() {
		return (List<Agent>)agentR.findAll();
	}

	@Override
	public Agent addAgent(Agent a) {
		
		agentR.save(a);
		
		return a;
	}

	@Override
	public Agent updateAgent(Agent ag) {
		agentR.save(ag);
		return ag;
		}

	@Override
	public Agent retrieveAgent(Long id) {
		Agent a= agentR.findById(id).orElse(null);
		return a;
	}

	@Override
	public void removeAgent(Long id) {
		agentR.deleteById(id);
		
	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Agent user = agentR.findUser(username);
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
	public Agent loadUser(String username) {
		Agent a= agentR.findUser(username);
		return a;
	}




    @Override
    public Agent getIpLocation(String ip, HttpServletRequest request) throws IOException, GeoIp2Exception {

        Agent position = new Agent();
        String location;

        InetAddress ipAddress = InetAddress.getByName(ip);

        CityResponse cityResponse = databaseReader.city(ipAddress);
        if ((cityResponse!=null) && (cityResponse.getCity()!=null)) {

            String continent = (cityResponse.getContinent() != null) ? cityResponse.getContinent().getName() : "";
            String country = (cityResponse.getCountry() != null) ? cityResponse.getCountry().getName() : "";

            location = String.format("%s, %s, %s", continent, country, cityResponse.getCity().getName());
           // position.setCity(cityResponse.getCity().getName());
            position.setFullLocation(location);
            position.setLatitude((cityResponse.getLocation() != null) ? cityResponse.getLocation().getLatitude() : 0);
            position.setLongitude((cityResponse.getLocation() != null) ? cityResponse.getLocation().getLongitude() : 0);
          //position.setDevice(getDeviceDetails(request.getHeader("user-agent")));
            position.setIpAddress(ip);

        }
        return position;
    }

	@Override
	public Agent SaveClassification9box(String per, String pot , Long id) {
		Agent user = agentR.findUserWithID(id);
		user.setPerformance(per);
		user.setPotentiel(pot);
		agentR.save(user);
          
		return user;
	}

	@Override
	public ClassEnum GetClassification9box(Long id) {
		Agent user = agentR.findUserWithID(id);
		
		
		if ((user.getPerformance().equals("below expected"))&&(user.getPotentiel().equals("low")))
		{
			user.setClassification(ClassEnum.Underperformer);
			agentR.save(user);
		}
		else if ((user.getPerformance().equals("below expected"))&&(user.getPotentiel().equals("moderate")))
		{
			user.setClassification(ClassEnum.InconsistentPlayer);
			agentR.save(user);
		}
		else if ((user.getPerformance().equals("below expected"))&&(user.getPotentiel().equals("high")))
		{
			user.setClassification(ClassEnum.RoughDiamond);
			agentR.save(user);
		}
		else if ((user.getPerformance().equals("moderate"))&&(user.getPotentiel().equals("low")))
		{
			user.setClassification(ClassEnum.Underperformer);
			agentR.save(user);
		}
		else if ((user.getPerformance().equals("moderate"))&&(user.getPotentiel().equals("moderate")))
		{
			user.setClassification(ClassEnum.InconsistentPlayer);
			agentR.save(user);
		}
		else if ((user.getPerformance().equals("moderate"))&&(user.getPotentiel().equals("high")))
		{
			user.setClassification(ClassEnum.RoughDiamond);
			agentR.save(user);
		}
		else if ((user.getPerformance().equals("above expected"))&&(user.getPotentiel().equals("low")))
		{
			user.setClassification(ClassEnum.Underperformer);
			agentR.save(user);
		}
		else if ((user.getPerformance().equals("above expected"))&&(user.getPotentiel().equals("moderate")))
		{
			user.setClassification(ClassEnum.InconsistentPlayer);
			agentR.save(user);
		}
		else if ((user.getPerformance().equals("above expected"))&&(user.getPotentiel().equals("high")))
		{
			user.setClassification(ClassEnum.RoughDiamond);
			agentR.save(user);
		}
		else
		{user.setClassification(ClassEnum.notbeenTested);
		agentR.save(user);
			
		}
		return user.getClassification();
	}

	@Override
	public List<Agent> retrieveAgentByClass(ClassEnum c) {
		return (List<Agent>)agentR.findAgentClass(c);
	}

	/*@Override
	public Agent assignUserToAgent(Long idAgent) {
	     Agent a =agentR.findById(idAgent).orElse(null);
	    Set<Client> c=clientR.getClientsByAgent(idAgent);
	     a.setClient(c);
	     agentR.save(a);
	     return a;
	}*/
	

}
