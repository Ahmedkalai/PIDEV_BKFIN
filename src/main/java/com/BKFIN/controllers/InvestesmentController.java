package com.BKFIN.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.BKFIN.entities.Investesment;
import com.BKFIN.services.InvestesmentService;


@RestController
@RequestMapping("/Investesment")
public class InvestesmentController {
	@Autowired
	InvestesmentService investesmentService;

	
	// http://localhost:8083/BKFIN/Investesment/retrieve-all-investesments
			@GetMapping("/retrieve-all-investesments")
			@ResponseBody
			public List<Investesment> getInvestesment() {
			List<Investesment> listInvestesment = investesmentService.retrieveAllInvestesments();
			return listInvestesment;
			}
			

			// http://localhost:8083/BKFIN/Investesment/retrieve-investesment/1
			@GetMapping("/retrieve-investesment/{investesment-id}")
			@ResponseBody
			public Investesment retrieveInvestesment(@PathVariable("investesment-id") Long investesmentId) {
			return investesmentService.retrieveInvestesment(investesmentId);
			}
			
			
			// http://localhost:8083/BKFIN/Investesment/add-investesment/1
			@PostMapping("/add-investesment/{Fund-id}")
			@ResponseBody
			public Investesment addInvestesment(@RequestBody Investesment i,@PathVariable("Fund-id") Long idFund)
			{
				Investesment investesment = investesmentService.addInvestesment(i,idFund);
			return investesment; 
			}
			
			// http://localhost:8083/BKFIN/Investesment/modify-investesment
			@PutMapping("/investesment-fund")
			@ResponseBody
			public Investesment modifyInvestesment(@RequestBody Investesment investesment,Long idFund) {
			return investesmentService.updateInvestesment(investesment,idFund);
			}
}
