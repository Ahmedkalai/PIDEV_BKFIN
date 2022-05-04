package com.BKFIN.services;

import java.util.List;

import com.BKFIN.entities.Investesment;


public interface IInvestesmentService {
	List<Investesment> retrieveAllInvestesments();

	Investesment addInvestesment(Investesment i , Long idFund);
	
	Investesment updateInvestesment(Investesment i);

	Investesment retrieveInvestesment(Long cinInvestesment);
	
	void CalculateAmoutOfInves(Long idInvestesment);
	
	float CalculateRateOfInves(Long idInvestissement);

	void finalAmount();
}
