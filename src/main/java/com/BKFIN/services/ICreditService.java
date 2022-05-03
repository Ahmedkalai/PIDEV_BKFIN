package com.BKFIN.services;
import java.util.List;

import org.springframework.stereotype.Service;

import com.BKFIN.entities.Credit;
import com.BKFIN.entities.Garantor;

@Service
public interface ICreditService  {
	List<Credit> retrieveAllCredits();

	Credit addCredit (Credit credit,Long Id_client,Long Id_fund,Long Id_pack,Long Id_garant);

	Credit updateCredit (Credit credit,Long Id_client,Long Id_fund,Long Id_pack);

	Credit retrieveCredit(Long idCredit);
	
	Credit ArchiveCredit(Long idCredit);
	
	Amortissement Simulateur(Credit credit);
	
	Credit retrieveActiveCredit(Long clientid);
	
	Credit retrievelastCredit(Long clientid);
	
	public void DeleteCredit(Long id);
	
	float Calcul_mensualite(Credit cr);
	
}
