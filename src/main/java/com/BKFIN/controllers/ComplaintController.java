package com.BKFIN.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.BKFIN.entities.Complaint;
import com.BKFIN.services.IComplaintService;








@RestController

@RequestMapping("/Complaint")
public class ComplaintController {
	
	
	@Autowired
	IComplaintService complaintservice;
	
	// http://localhost:8084/BKFIN/Complaint/retrieve-all-complaint
	
	@GetMapping("/retrieve-all-complaint")
	@ResponseBody
	public List<Complaint> getComplaint() {
	List<Complaint> listcom = complaintservice.retrieveAllComplaint();
	return listcom;
	}
	
	// http://localhost:8084/BKFIN/Complaint/retrieve-complaint/1
		@GetMapping("/retrieve-complaint/{complaint-id}")
		@ResponseBody
		public Complaint retrieveComplaint(@PathVariable("complaint-id") Long complaintId) {
		return complaintservice.retrieveComplaint(complaintId);
		}
		
		
		// http://localhost:8084/BKFIN/Complaint/add-complaint/1
		@PostMapping("/add-complaint/{client-id}")
		@ResponseBody
		public Complaint addComplaint(@RequestBody Complaint c ,@PathVariable("client-id") Long clientid) 
		{
		Complaint complaint = complaintservice.addComplaint(c, clientid);
		return complaint;
		}
		
		// http://localhost:8084/BKFIN/Complaint/modify-complaint
		@PutMapping("/modify-complaint")
		@ResponseBody
		public Complaint modifyComplaint(@RequestBody Complaint p) {
		return complaintservice.updateComplaint(p);
		}
		
		
		// http://localhost:8084/BKFIN/Complaint/modify-complaintState
				@PutMapping("/modify-complaintState/{complaint-id}")
				@ResponseBody
				public void modifyState(@PathVariable("complaint-id") Long complaintId) {
				 complaintservice.ChangeState(complaintId);
				}
				
				
				// http://localhost:8084/BKFIN/Complaint/retrieve-complaintByClient/1
				@GetMapping("/retrieve-complaintByClient/{complaint-id}")
				@ResponseBody
				public List<Complaint> retrieveComplaintByclient(@PathVariable("complaint-id") Long complaintId) {
				return complaintservice.retrieveComplaintByClient(complaintId);
				}
		
	
	
	
	
	

}
