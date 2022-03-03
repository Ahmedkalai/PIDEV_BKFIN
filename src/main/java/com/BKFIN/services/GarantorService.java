package com.BKFIN.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.BKFIN.entities.Credit;
import com.BKFIN.entities.Garantor;
import com.BKFIN.repositories.CreditRepository;
import com.BKFIN.repositories.GarantorRepository;


public class GarantorService implements IGarantorService {
    
	@Autowired
	GarantorRepository GRrepo;
	CreditRepository Crepo;
	
	
	@Override
	public List<Garantor> retrieveAllGarantors() {
		return (List<Garantor>) GRrepo.findAll();
	}

	@Override
	public Garantor addGarantor(Garantor garantor, Long idcredit) {
		Credit credit= Crepo.findById(idcredit).orElse(null);
		garantor.setCredit(credit);
		return garantor;
		
	}

	@Override
	public Garantor updateGarantor(Garantor garantor, Long idcredit) {
		Credit credit= Crepo.findById(idcredit).orElse(null);
		garantor.setCredit(credit);
		return garantor;
	}

	@Override
	public Garantor retrieveGarantor(Long idGarantor) {
		Garantor garantor= GRrepo.findById(idGarantor) .orElse(null) ; 
		return garantor ;
	}
	
	public void deleteCredit(Long id) {
		GRrepo.deleteById(id);
		}

    

    
	
	

}
