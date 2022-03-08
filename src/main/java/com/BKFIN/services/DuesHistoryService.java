package com.BKFIN.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BKFIN.entities.Credit;
import com.BKFIN.entities.DuesHistory;
import com.BKFIN.repositories.CreditRepository;
import com.BKFIN.repositories.DuesHistoryRepository;
@Service
public class DuesHistoryService implements IDuesHistoryService {
    
	@Autowired
	DuesHistoryRepository DHrepo;
	@Autowired
	CreditRepository Crepo;
	
	
	@Override
	public List<DuesHistory> retrieveAllDuesHistorys() {
		return (List<DuesHistory>) DHrepo.findAll();
	}

	@Override
	public DuesHistory addDuesHistory(DuesHistory DH, Long idcredit) {
		Credit credit= Crepo.findById(idcredit).orElse(null);
		DH.setCredits(credit);
		DHrepo.save(DH);
		return DH;
	}

	@Override
	public DuesHistory updateDuesHistory(DuesHistory DH, Long idcredit) {
		Credit credit= Crepo.findById(idcredit).orElse(null);
		DH.setCredits(credit);
		DHrepo.save(DH);
		return DH;
	}

	@Override
	public DuesHistory retrieveDuesHistory(Long idDuesHistory) {
		DuesHistory DH= DHrepo.findById(idDuesHistory) .orElse(null) ; 
		return DH ;
	}
	
	

	@Override
	public void DeleteDuesHistory(Long idDuesHistory) {
		DHrepo.deleteById(idDuesHistory);
	}

   

}
