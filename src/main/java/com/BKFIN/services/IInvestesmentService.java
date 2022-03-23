package com.BKFIN.services;

import java.util.List;

import com.BKFIN.entities.Investesment;


public interface IInvestesmentService {
	List<Investesment> retrieveAllInvestesments();

	Investesment addInvestesment(Investesment i , Long idFund);

	Investesment updateInvestesment(Investesment inv, Long idFund);

	Investesment retrieveInvestesment(Long cinInvestesment);
	
	float CalculateAmoutOfInves(Long idInvestissement);
	
	float CalculateRateOfInves(Long idInvestissement,Long idFund);

}
