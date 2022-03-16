package com.BKFIN.services;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.omg.CORBA.Current;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BKFIN.entities.Agent;
import com.BKFIN.entities.Event;
import com.BKFIN.repositories.AgentRepository;
import com.BKFIN.repositories.EventRepository;

@Service
public class EventService implements IEventService{

	@Autowired
	EventRepository eventrepository; 
	@Autowired
	AgentRepository ar;
	
	@Override
	public List<Event> retrieveAllEvents() {
		return (List<Event>) eventrepository.findAll();
	}

	@Override
	public Event addEvent(Event e) {
		Date d2 = e.getDateEvent() ;
		Date d=new Date();
		if (d2.after(d)) {
			 eventrepository.save(e);
		 }
		 return(e);	 
	}

	@Override
	public void deleteEvent(Long idEvent) {
		eventrepository.deleteById(idEvent);	
		
	}

	@Override
	public Event updateEvent(Event ev) {
		eventrepository.save(ev);
		return ev;
	}

	@Override
	public Event retrieveEvent(Long idEvent) {
		return eventrepository.findById(idEvent).orElse(null);	
	}


	@Override
	public void affectereventtoagent(Long evntid, Long agentid) {
		Event e = eventrepository.findById(evntid).get();
		Agent a= ar.findById(agentid).get();
		Set<Agent> la=e.getAgenT();
		String addA= a.getAdresse().toUpperCase();
		String addE = e.getRegion().toUpperCase();
		Boolean dispo = a.getState();
		if ((addA.equals(addE))&& ( dispo = true)){
		la.add(a);
		e.setAgenT(la);
		ar.save(a);
		dispo = false; 
		}}
}
