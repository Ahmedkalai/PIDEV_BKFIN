package com.BKFIN.services;

import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.BKFIN.entities.Client;
import com.BKFIN.entities.Complaint;
import com.BKFIN.repositories.ClientRepository;
import com.BKFIN.repositories.ComplaintRepository;

@Service
public class ComplaintService implements IComplaintService {
	
	
     @Autowired
     ComplaintRepository complaintRepository;
     @Autowired
     ClientRepository clientRepository;
     @Autowired
      private JavaMailSender mailSender;
     
     

	@Override
	public List<Complaint> retrieveAllComplaint() {
		
		return (List<Complaint>) complaintRepository.findAll();
	}

	@Override
	public Complaint addComplaint(Complaint c, Long clientcomp) {
		Client cl =clientRepository.findById(clientcomp).orElse(null);
		c.setClientcomp(cl);
		Date date = new Date();
		c.setDateComplaint(date);
		c.setState(false);
		 complaintRepository.save(c)	;
     return c;
        
        
        
        
      //return c;
	}

	@Override
	public Complaint updateComplaint(Complaint u)
	
	{
		if (u.getState()== false ) {
		
		
		return complaintRepository.save(u);
		
		}
		
		else 
			return null;
	}
	

	@Override
	public Complaint retrieveComplaint(Long id) {
		Complaint cmp= complaintRepository.findById(id) .orElse(null) ; 
		return cmp ;
		
	}
	//@Override

	@Override
	public void ChangeState(Long id) {
		Complaint cmp= complaintRepository.findById(id).orElse(null) ; 
		if (cmp.getState()== false ) {
			cmp.setState(true);
		}
		
		
		complaintRepository.save(cmp);
		SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("bkfinpi@gmail.com");
        message.setTo(cmp.getClientcomp().getEmail());
        message.setText("your claim is handled");
        message.setSubject("claim processing");

        mailSender.send(message);
        System.out.println("Mail Send...");
		
		
		
		
		
	}

	@Override
	public List<Complaint> retrieveComplaintByClient(Long idClient) {
		Client cl = clientRepository.findById(idClient).orElse(null);
		List<Complaint> com = complaintRepository.getComplaintByClient(idClient);
		
		return com ;
	}
	
	
	
	 //public void deleteComplaint(Long id) {
		//complaintRepository.deleteById(id);
		
	//}


}
