package com.BKFIN.services;

import java.util.List;

import com.BKFIN.entities.Partner;


public interface IPartnerService {
	List<Partner> retrieveAllPartners();

	Partner addPartner (Partner pr);
	

	void deletePartner (Long id);

	Partner updatePartner (Partner pr);

	Partner retrievePartner (Long id);
}
