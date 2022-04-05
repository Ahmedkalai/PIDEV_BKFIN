package com.BKFIN.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

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
import com.BKFIN.entities.Garantor;
import com.BKFIN.services.Amortissement;
import com.BKFIN.services.CreditService;
import com.BKFIN.services.ICreditService;




@RestController
@RequestMapping("/Credit")
public class CreditController {
	
	@Autowired
	CreditService creditservice;
	
	
	
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
	
	//http://localhost:8083/BKFIN/Credit/add-Credit/1/1/1/1
	@PostMapping("/add-Credit/{Credit-Id_client}/{Credit-Id_fund}/{Credit-Id_pack}/{credit_idgarant}")
	@ResponseBody
	public Credit addcredit(@RequestBody Credit c,@PathVariable("Credit-Id_client") Long Id_client,
			                @PathVariable("Credit-Id_fund") Long Id_fund,
			                @PathVariable("Credit-Id_pack") Long Id_pack,@PathVariable("credit_idgarant") Long Id_garant)
	{
		Credit Credit = creditservice.addCredit(c,Id_client,Id_fund,Id_pack,Id_garant);
	return Credit;
	}
	
	//http://localhost:8083/BKFIN/Credit/modify-credit/1/1/1
	@PutMapping("/modify-credit/{Credit-Id_client}/{Credit-Id_fund}/{Credit-Id_pack}")
	@ResponseBody
	public Credit modifycredit(@RequestBody Credit credit,@PathVariable("Credit-Id_client") Long Id_client,
			                   @PathVariable("Credit-Id_fund") Long Id_fund,
			                   @PathVariable("Credit-Id_pack") Long Id_pack) 
	{
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
		
		
	//http://localhost:8083/BKFIN/Credit/calculm
	@PostMapping("/calculm")
	@ResponseBody
	public float mensualite(@RequestBody Credit c)
	{
		float Credit = creditservice.Calcul_mensualite(c);
		return Credit;
	}	
	
	//http://localhost:8083/BKFIN/Credit/calcultabamortissement
		@PostMapping("/calcultabamortissement")
		@ResponseBody
		public Amortissement[] TabAmortissement(@RequestBody Credit cr)
		{   
			Amortissement[] Credit = creditservice.TabAmortissement(cr);
			//ByteArrayInputStream stream = ExcelFileExporter.contactListToExcelFile(creditservice.TabAmortissement(cr));
			
			return Credit;
		}
		//http://localhost:8083/BKFIN/Credit/export/excel
		@GetMapping("/export/excel")
		@ResponseBody
		public void exportToExcel(HttpServletResponse response,@RequestBody Credit cr) throws IOException {
			response.setContentType("application/octet-stream");
			String headerKey = "Content-Disposition";
			
			String headervalue = "attachment; filename=Tableau_Credit_N_"+cr.getIdCredit()+".xlsx";
			response.setHeader(headerKey, headervalue);
			Amortissement[] credit = creditservice.TabAmortissement(cr);
			List<Amortissement> list = Arrays.asList(credit);
			com.BKFIN.services.UserExcelExporter exp =new com.BKFIN.services.UserExcelExporter(list);
			//UserExcelExporter exp = new UserExcelExporter(list);
			exp.export(response);

		}	
		
		
	
		
		
		
	
	
	
	
	
	
	
	

}
