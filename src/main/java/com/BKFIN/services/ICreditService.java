package com.BKFIN.services;
import java.util.List;

import com.BKFIN.entities.Credit;


public interface ICreditService  {
	List<Credit> retrieveAllCredits();

	Credit addCredit (Credit credit,Long Id_client,Long Id_fund,Long Id_pack);

	Credit updateCredit (Credit credit,Long Id_client,Long Id_fund,Long Id_pack);

	Credit retrieveCredit(Long idCredit);
	
}
