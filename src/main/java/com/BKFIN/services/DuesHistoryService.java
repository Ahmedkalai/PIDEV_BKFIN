package com.BKFIN.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.BKFIN.entities.Credit;
import com.BKFIN.entities.DuesHistory;
import com.BKFIN.repositories.CreditRepository;
import com.BKFIN.repositories.DuesHistoryRepository;

public class DuesHistoryService implements IDuesHistory {
    
	@Autowired
	DuesHistoryRepository DHrepo;
	CreditRepository Crepo;
	
	
	@Override
	public List<DuesHistory> retrieveAllDuesHistorys() {
		return (List<DuesHistory>) DHrepo.findAll();
	}

	@Override
	public DuesHistory addDuesHistory(DuesHistory DH, Long idcredit) {
		Credit credit= Crepo.findById(idcredit).orElse(null);
		DH.setCredits(credit);
		return DH;
	}

	@Override
	public DuesHistory updateDuesHistory(DuesHistory DH, Long idcredit) {
		Credit credit= Crepo.findById(idcredit).orElse(null);
		DH.setCredits(credit);
		return DH;
	}

	@Override
	public DuesHistory retrieveDuesHistory(Long idDuesHistory) {
		DuesHistory DH= DHrepo.findById(idDuesHistory) .orElse(null) ; 
		return DH ;
	}
	
	public void deleteCredit(Long id) {
		DHrepo.deleteById(id);
		}

   

}
