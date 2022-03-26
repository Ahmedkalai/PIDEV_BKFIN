package com.BKFIN.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BKFIN.repositories.UPopulationRepository;

@Service
public class UPopulationService implements IUPopulationService{

	@Autowired
	UPopulationRepository UPRepo;

	@Override
	public List<String> getRegionByEnvironmentF() {
		return ( List<String>) UPRepo.getRegionByEnvironment("Rural");
	
	}

	@Override
	public List<String> getRegionByRateF() {
		
		return ( List<String>) UPRepo.getRegionByRate(null);

	}
	
}
