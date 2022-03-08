package com.BKFIN.controller;

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
import com.BKFIN.entities.Credit;
import com.BKFIN.services.ICreditService;


@RestController
@RequestMapping("/Credit")
public class CreditController {
	
	@Autowired
	ICreditService creditservice;
	
	
	// http://localhost:8083/BKFIN/Credit/retrieve-all-Credit
	@GetMapping("/retrieve-all-Credit")
	@ResponseBody
	public List<Credit> getCredit() {
	List<Credit> listCredits = creditservice.retrieveAllCredits();
	return listCredits;
	}
	
	//http://localhost:8083/BKFIN/Credit/retrieve-Credit/1
	@GetMapping("/retrieve-Credit/{Credit-id}")
	@ResponseBody
	public Credit retrieveCredit(@PathVariable("Credit-id") Long CreditId) {
	return creditservice.retrieveCredit(CreditId);
	}
	
	//http://localhost:8083/BKFIN/Credit/add-Credit/1/1/1
	@PostMapping("/add-Credit/{Credit-Id_client}/{Credit-Id_fund}/{Credit-Id_pack}")
	@ResponseBody
	public Credit addcredit(@RequestBody Credit c,@PathVariable("Credit-Id_client") Long Id_client,@PathVariable("Credit-Id_fund") Long Id_fund,@PathVariable("Credit-Id_pack") Long Id_pack)
	{
		Credit Credit = creditservice.addCredit(c,Id_client,Id_fund,Id_pack);
	return Credit;
	}
	
	//http://localhost:8083/BKFIN/Credit/modify-credit/1/1/1
	@PutMapping("/modify-credit/{Credit-Id_client}/{Credit-Id_fund}/{Credit-Id_pack}")
	@ResponseBody
	public Credit modifycredit(@RequestBody Credit credit,@PathVariable("Credit-Id_client") Long Id_client,@PathVariable("Credit-Id_fund") Long Id_fund,@PathVariable("Credit-Id_pack") Long Id_pack) {
	return creditservice.updateCredit(credit,Id_client,Id_fund,Id_pack);
	}
	
	//http://localhost:8083/BKFIN/Credit/remove-credit/10
	@DeleteMapping("/remove-credit/{credit-id}")
	@ResponseBody
	public void removecredit(@PathVariable("credit-id") Long creditId) {
	creditservice.DeleteCredit(creditId);
	}
	
	//http://localhost:8083/BKFIN/Credit/archive-credit/10
		@PutMapping("/archive-credit/{credit-id}")
		@ResponseBody
		public Credit modifycredit(@PathVariable("credit-id") Long idcredit) {
		return creditservice.ArchiveCredit(idcredit);
		}
	
	
	
	
	
	
	
	

}
