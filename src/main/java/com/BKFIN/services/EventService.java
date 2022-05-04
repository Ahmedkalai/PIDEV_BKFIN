package com.BKFIN.services;

import java.io.File;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

//import org.omg.CORBA.Current;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.BKFIN.entities.Agent;
import com.BKFIN.entities.Event;
import com.BKFIN.entities.Investesment;
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
	//on ne peut pas creer un event ayant une date inf à la date actuelle 
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
	public Event updateEvent(Event ev,Long idEvent) {
		Event event =eventrepository.findById(idEvent).orElse(null);
		event.setNameEvent(ev.getNameEvent());
		event.setDescription(ev.getDescription());
		event.setDateEvent(ev.getDateEvent());
		event.setRegion(ev.getRegion());
		eventrepository.save(event);
		return ev;
	}
	
	@Override
	public Event retrieveEvent(Long idEvent) {
		return eventrepository.findById(idEvent).orElse(null);	
	}

	
//	@Override	
	@Autowired
	private JavaMailSender mailSender;
	public void affectereventtoagent(Long evntid, Long agentid,String toEmail,String subject,String body) throws MessagingException {
		Event e = eventrepository.findById(evntid).get();
		Agent a= ar.findById(agentid).get();
		Set<Agent> la=e.getAgenT();
		String addA= a.getAdresse().toUpperCase();
		String addE = e.getRegion().toUpperCase();
		Boolean dispo = a.getState();
//l'event n'est ajouté si seulement si l'agent et l'event appart à la meme region
//l'agent est disponible
	if ((addA.equals(addE))&& ( dispo == true)){
		la.add(a);
		e.setAgenT(la);
		ar.save(a);
//l'agent devient donc indispo
		dispo = false; 
		a.setState(dispo);
		ar.save(a);
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHealper = new MimeMessageHelper(mimeMessage,true);
//SimpleMailMessage message=new SimpleMailMessage();
		mimeMessageHealper.setFrom("khadija.azzouz@esprit.tn");
		mimeMessageHealper.setTo(toEmail);
		mimeMessageHealper.setText(body);
		mimeMessageHealper.setSubject(subject);
		//ajouté l'invitation de l'event 
		mailSender.send(mimeMessage);
		System.out.println("Mail sent successfully ! ");
		}
	}

/*	@Override
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
		}
	}
*/	

/*	@Autowired
	private JavaMailSender mailSender;
		public void sendEmail (String toEmail,String subject,String body,String attachment) throws MessagingException{
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHealper = new MimeMessageHelper(mimeMessage,true);
		mimeMessageHealper.setFrom("khadija.azzouz@esprit.tn");
		mimeMessageHealper.setTo(toEmail);
		mimeMessageHealper.setText(body);
		mimeMessageHealper.setSubject(subject);		
		FileSystemResource fileSystem = new FileSystemResource(new File(attachment));
		mimeMessageHealper.addAttachment(fileSystem.getFilename(), fileSystem);
		mailSender.send(mimeMessage);
		System.out.println("Mail sent successfully ! ");		
	}
*/	
}
