package com.BKFIN.services;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.BKFIN.repositories.PartnerRepository;
import com.BKFIN.entities.Partner;
@Service
public class PartnerServiceImpl implements IPartnerService {
@Autowired 
PartnerRepository PartnerRepository;
	@Override
	public List<Partner> retrieveAllPartners() {
		List<Partner> Partners = (List<Partner>) PartnerRepository.findAll();
		return Partners;
	}

	@Override
	public Partner addPartner(Partner pr) {
		return  PartnerRepository.save(pr);
	}

	@Override
	public void deletePartner(Long id) {
		PartnerRepository.deleteById(id);
		System.out.println("partner deleted");
		
	}

	@Override
	public Partner updatePartner(Partner pr) {
		
		return PartnerRepository.save(pr);
	}

	@Override
	public Partner retrievePartner(Long id) {
		Partner partner= PartnerRepository.findById(id) .orElse(null) ; 
		return partner ;
	}

}
