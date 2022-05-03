package com.BKFIN.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.BKFIN.entities.unemployedpopulation;
import com.BKFIN.services.UPopulationService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/UPopulation")
public class UPopulationController {
	
	@Autowired
	UPopulationService UPopulationService;
	
	//http://localhost:8083/BKFIN/UPopulation/getRegionByEnvironment
		@GetMapping("/getRegionByEnvironment")
	    @ResponseBody
	    public  List<String> getRegionByEnvironment() {
	       return UPopulationService.getRegionByEnvironmentF();
	    }
		
		//http://localhost:8083/BKFIN/UPopulation/getRegionByRate
		@GetMapping("/getRegionByRate")
	    @ResponseBody
	    public  List<String> getRegionByRate() {
	       return UPopulationService.getRegionByRateF();
	    }
}
