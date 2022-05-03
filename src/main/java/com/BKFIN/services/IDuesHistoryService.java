package com.BKFIN.services;
import java.util.List;

import com.BKFIN.entities.DuesHistory;

public interface IDuesHistoryService {
	List<DuesHistory> retrieveAllDuesHistorys();
	
	List<DuesHistory> retrieveAllDuesHistory_byCredit(Long idCredit);

	DuesHistory addDuesHistory (DuesHistory p,Long idcredit);

	DuesHistory updateDuesHistory (DuesHistory p,Long idcredit);

	DuesHistory retrieveDuesHistory(Long idDuesHistory);
	
	public void DeleteDuesHistory(Long idDuesHistory);
	
	float PayedAmount(Long idcredit);
}
