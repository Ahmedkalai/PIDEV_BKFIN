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

import com.BKFIN.entities.Partner;
import com.BKFIN.services.PartnerServiceImpl;

@RestController
@RequestMapping("/Partner")
public class PartnerRestController {
	@Autowired 
	PartnerServiceImpl PSI;
	//AJOUT PARTENAIRE
	@PostMapping("/ajouterPartner")
	public void ajouterPartner(@RequestBody Partner partner){
		PSI.addPartner(partner);
	}
	//AFFICHAGE LISTE PARTENAIRES
	@GetMapping("/viewPartners")
	@ResponseBody
	public List<Partner> getPartners(){
		List<Partner> lp=PSI.retrieveAllPartners();
		return lp;
	}
	
	//AFFICHAGE PARTENAIRE
	@GetMapping("viewPartner/{idPartner}")
	@ResponseBody
	public Partner getPartner(@PathVariable("idPartner") Long IdPartner) {
		Partner p = PSI.retrievePartner(IdPartner);
		return p;
	}
	//SUPPRESSION PARTENAIRE
	@DeleteMapping("deleteP/{idPartner}")
	public void deletePartner(@PathVariable("idPartner") Long IdPartner) {
		 PSI.deletePartner(IdPartner);
	}
	//MODIFICATION PARTENAIRE
	@PutMapping("/updatePartner")
	@ResponseBody
	public Partner updatePartner(@RequestBody Partner p) {
		Partner par=PSI.updatePartner(p);
		return par;
		
	}
	
}
