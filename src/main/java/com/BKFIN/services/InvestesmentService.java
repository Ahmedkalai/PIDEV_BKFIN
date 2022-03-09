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
	public Investesment addFund(Investesment i, Long idFund) {
		Fund f = fundRepository.findById(idFund).orElse(null);
		i.setFund(f);
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
