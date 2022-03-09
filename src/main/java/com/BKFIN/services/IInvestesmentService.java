package com.BKFIN.services;

import java.util.List;

import com.BKFIN.entities.Investesment;


public interface IInvestesmentService {
	List<Investesment> retrieveAllInvestesments();

	Investesment addFund(Investesment i , Long idFund);

	Investesment updateInvestesment(Investesment inv, Long idFund);

	Investesment retrieveInvestesment(Long cinInvestesment);
}
