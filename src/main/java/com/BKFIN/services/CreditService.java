package com.BKFIN.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.BKFIN.entities.Client;
import com.BKFIN.entities.Credit;
import com.BKFIN.entities.Fund;
import com.BKFIN.entities.Pack;
import com.BKFIN.repositories.ClientRepository;
import com.BKFIN.repositories.CreditRepository;
import com.BKFIN.repositories.FundRepository;
import com.BKFIN.repositories.PackRepository;




public class CreditService implements ICreditService {
    
	@Autowired
	CreditRepository Crepo;
	ClientRepository ClientRepo;
	FundRepository FundRepo;
	PackRepository PackRepo;
	
	@Override
	public List<Credit> retrieveAllCredits() {
		return (List<Credit>) Crepo.findAll();
		}

	@Override
	public Credit addCredit(Credit credit, Long Id_client, Long Id_fund, Long Id_pack) {
		Client client= ClientRepo.findById(Id_client).orElse(null);
		Fund fund=FundRepo.findById(Id_fund).orElse(null);
		Pack pack=PackRepo.findById(Id_pack).orElse(null);
		 credit.setClient(client);
		 credit.setFunds(fund);
		 credit.setPack_credit(pack);
        return credit;
		
	}

	@Override
	public Credit updateCredit(Credit credit, Long Id_client, Long Id_fund, Long Id_pack) {
		Client client= ClientRepo.findById(Id_client).orElse(null);
		Fund fund=FundRepo.findById(Id_fund).orElse(null);
		Pack pack=PackRepo.findById(Id_pack).orElse(null);
		 credit.setClient(client);
		 credit.setFunds(fund);
		 credit.setPack_credit(pack);
        return credit;
		
	}

	@Override
	public Credit retrieveCredit(Long idCredit) {
		Credit credit= Crepo.findById(idCredit) .orElse(null) ; 
		return credit ;
	}
	
	public void deleteCredit(Long id) {
		Crepo.deleteById(id);
		}
   

}
