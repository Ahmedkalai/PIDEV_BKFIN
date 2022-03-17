package com.BKFIN.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.BKFIN.entities.Fund;
import com.BKFIN.entities.Investesment;
import com.BKFIN.repositories.FundRepository;
import com.BKFIN.repositories.InvestesmentRepository;



@Service
public class InvestesmentService implements IInvestesmentService{
	
	@Autowired
	InvestesmentRepository investesmentRepository; 
	
	@Autowired
	FundRepository fundRepository; 
	

	
	@Override
	public List<Investesment> retrieveAllInvestesments() {
		return (List<Investesment>) investesmentRepository.findAll();

	}
	
	
	@Override
	public Investesment addInvestesment(Investesment i, Long idFund) {
		
		Fund f = fundRepository.findById(idFund).orElse(null);
		//le taux d'inves est variable selon le montant choisit 
		i.setTauxInves((i.getAmoutInvestesment())/(pib*100));
		i.setFund(f);
		//incrémentation du fund pour chaque investissement 
		f.setAmountFund(f.getAmountFund()+i.getAmoutInvestesment());
		//incrémentation du taux pour chaque investissement 
		List<Investesment> listInves = (List<Investesment>) investesmentRepository.findAll();
		float s = 0;
		for (Investesment  inv : listInves) {
			s=s+(inv.getAmoutInvestesment());
		}
		s=s+i.getAmoutInvestesment();
		float pourc_inv = (i.getAmoutInvestesment())/s;
		f.setTauxFund(pourc_inv*(i.getTauxInves())+(1-pourc_inv)*f.getTauxFund());
		investesmentRepository.save(i);
		return i;
	}
	

	
	
	@Override
	public Investesment updateInvestesment(Investesment inv, Long idFund) {
		Fund f = fundRepository.findById(idFund).orElse(null);
		inv.setFund(f);
		investesmentRepository.save(inv);
		return inv;
	}

	@Override
	public Investesment retrieveInvestesment(Long cinInvestesment) {
		 Investesment inves =  investesmentRepository.findById(cinInvestesment).orElse(null);
		return inves;

	}
	
	float finalAmount;
	//@Scheduled(cron = "0 0 0 31 12 *" )
	@Override
	public float CalculateAmoutOfInves(Long idInvestissement) {
		//List<Investesment> Investesments = (List<Investesment>) investesmentRepository.findAll();	
		Investesment inves =  investesmentRepository.findById(idInvestissement).orElse(null);
			finalAmount=(inves.getAmoutInvestesment()+(inves.getAmoutInvestesment()*inves.getTauxInves()));
		
		return finalAmount;
	}

	float finalrate;
	float pib=(float) 39.24;
	@Override
	public float CalculateRateOfInves(Long idInvestissement,Long idFund) {
		Investesment inves =  investesmentRepository.findById(idInvestissement).orElse(null);
		Fund f = fundRepository.findById(idFund).orElse(null);
		//formule de l'investissement économique 
		finalrate=(f.getAmountFund())/(pib*100);
		return finalrate;
	}
	



	

}
