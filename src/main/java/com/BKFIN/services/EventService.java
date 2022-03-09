package com.BKFIN.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BKFIN.entities.Event;
import com.BKFIN.repositories.EventRepository;

@Service
public class EventService implements IEventService{

	@Autowired
	EventRepository eventrepository; 
	
	@Override
	public List<Event> retrieveAllEvents() {
		return (List<Event>) eventrepository.findAll();
	}

	@Override
	public Event addEvent(Event e) {
		return eventrepository.save(e);	
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

}
