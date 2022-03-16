package com.BKFIN.controllers;

import java.util.List;

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

import com.BKFIN.entities.Event;
import com.BKFIN.services.EventService;



@RestController
@RequestMapping("/Event")

public class EventController {
	
	@Autowired
	EventService eventService;
	
		// http://localhost:8083/BKFIN/Event/retrieve-all-events
		@GetMapping("/retrieve-all-events")
		@ResponseBody
		public List<Event> getEvent() {
		List<Event> listEvent = eventService.retrieveAllEvents();
		return listEvent;
		}
		

		// http://localhost:8083/BKFIN/Event/retrieve-event/1
		@GetMapping("/retrieve-event/{event-id}")
		@ResponseBody
		public Event retrieveEvent(@PathVariable("event-id") Long eventId) {
		return eventService.retrieveEvent(eventId);
		}

		
		// http://localhost:8083/BKFIN/Event/add-event
		@PostMapping("/add-event")
		@ResponseBody
		public Event addEvent(@RequestBody Event e)
		{
			Event event = eventService.addEvent(e);
		return event; 
		}
		
		
		// http://localhost:8083/BKFIN/Event/remove-event/{event-id}
		@DeleteMapping("/remove-event/{event-id}")
		@ResponseBody
		public void removeEvent(@PathVariable("event-id") Long eventId) {
			eventService.deleteEvent(eventId);
		}
		

		// http://localhost:8083/BKFIN/Event/modify-event
		@PutMapping("/modify-event")
		@ResponseBody
		public Event modifyEvent(@RequestBody Event event) {
		return eventService.updateEvent(event);
		}

		// http://localhost:8083/BKFIN/Event/addagev/1/1
		// AFFECTER UN evenement A UN agent 
		@PostMapping("/addagev/{idEvent}/{idAgent}")
		public void assignagev(@PathVariable("idEvent") Long eventid ,@PathVariable("idAgent")Long agentid) {
			eventService.affectereventtoagent(eventid, agentid);
		}
		


}
