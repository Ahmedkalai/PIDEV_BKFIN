package com.BKFIN.services;

import java.util.List;

import com.BKFIN.entities.Event;

public interface IEventService {
	
List<Event> retrieveAllEvents();

Event addEvent(Event e);

void deleteEvent(Long idEvent);

Event updateEvent(Event ev);

Event retrieveEvent(Long idEvent);
 void affectereventtoagent(Long evntid, Long agentid);
}
