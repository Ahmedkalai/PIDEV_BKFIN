package com.BKFIN.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.BKFIN.entities.Complaint;


public interface IComplaintService {

	List<Complaint> retrieveAllComplaint();

	Complaint addComplaint (Complaint p, Long clientcomp);

	Complaint updateComplaint (Complaint p,Long clientcomp );

	Complaint retrieveComplaint(Long id); 
//	void deleteComplaint(Long id);
	void ChangeState(Long id);
	
	
	List<Complaint> retrieveComplaintByClient(Long idClient);
	
	

	
	
	
	
	
}
