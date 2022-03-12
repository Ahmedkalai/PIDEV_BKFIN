package com.BKFIN.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

}
