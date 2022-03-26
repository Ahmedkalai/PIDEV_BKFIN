package com.BKFIN.services;

import java.util.List;
import com.BKFIN.entities.Fund;


public interface IFundService {
	
	
List<Fund> retrieveAllFunds();

Fund addFund(Fund f);

void deleteFund(Long idFund);

Fund updateFund(Fund fun);

Fund retrieveFund(Long idFund);

}
