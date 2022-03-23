package com.BKFIN.services;

import java.util.List;

import com.BKFIN.entities.unemployedpopulation;

public interface IUPopulationService {

	
	List<String> getRegionByEnvironmentF();
	List<String> getRegionByRateF();

	
}
