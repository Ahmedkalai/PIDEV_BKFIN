package com.BKFIN.services;
import java.util.List;

import org.springframework.stereotype.Service;

import com.BKFIN.entities.Credit;

@Service
public interface ICreditService  {
	List<Credit> retrieveAllCredits();

	Credit addCredit (Credit credit,Long Id_client,Long Id_fund,Long Id_pack);

	Credit updateCredit (Credit credit,Long Id_client,Long Id_fund,Long Id_pack);

	Credit retrieveCredit(Long idCredit);
	
	Credit ArchiveCredit(Long idCredit);
	
	public void DeleteCredit(Long id);
	
}
