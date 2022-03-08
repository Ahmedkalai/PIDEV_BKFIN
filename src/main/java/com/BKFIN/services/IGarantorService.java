package com.BKFIN.services;

import java.util.List;


import com.BKFIN.entities.Garantor;

public interface IGarantorService {
	
	List<Garantor> retrieveAllGarantors();

	Garantor addGarantor (Garantor garantor,Long idcredit);

	Garantor updateGarantor (Garantor garantor);

	Garantor retrieveGarantor(Long idGarantor);
	
	public void DeleteGarantor(Long idGarantor);
	
}
