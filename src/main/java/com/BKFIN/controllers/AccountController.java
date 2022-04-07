package com.BKFIN.controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.BKFIN.entities.Account;
import com.BKFIN.entities.Transaction;
import com.BKFIN.services.AccountPdfExporter;
import com.BKFIN.services.IAccountService;
import com.lowagie.text.DocumentException;

@EnableScheduling
@RestController
@RequestMapping("/Account")
public class AccountController {

	@Autowired 
	IAccountService AccSercice ; 
	
	
	//http://localhost:8083/BKFIN/Account/Listaccounts
	@GetMapping("/Listaccounts")
	@ResponseBody
	public List<Account> getAllAcounts() {
		List <Account> list=AccSercice.retrieveAllAccounts();
		return list ; 
	} 
	//http://localhost:8083/BKFIN/Account/AddAccount
	@PostMapping("/AddAccount/{cinClient}")
	@ResponseBody
	public Account AddAccount (@RequestBody Account a ,@PathVariable ("cinClient")  Long cinClient)
	{
		return AccSercice.addAccount(a,cinClient) ;
	}
	
	//http://localhost:8083/BKFIN/Account/DeleteAccount/1
	@DeleteMapping("/DeleteAccount/{idacc}")
	@ResponseBody
	public void deleteAcc (@PathVariable("idacc") String idacc ) {
		AccSercice.deleteAccount(idacc);
	}
	/*
	//http://localhost:8083/BKFIN/Account/retrieve-TransactionsEmises/1
	@GetMapping("/retrieve-TransactionsEmises/{RibEmet}")
	@ResponseBody
	public List<Transaction> getTransactionsEmisesByRib (@PathVariable("ribEmet") Long rib)
	{
		return AccSercice.retrieveAllTransactionsEmisesByRib(rib) ; 
	}
	
	
	
	
	*/
	    //http://localhost:8083/BKFIN/Account/retrieve-TransactionsEmises/2
		@GetMapping("/retrieve-TransactionsEmises/{Ribemis}")
		@ResponseBody
		public Set<Transaction> getTransactionsEmisesByRib (@PathVariable("Ribemis") String rib)
		{
			return AccSercice.retrieveAllTransactionsEmises1ByRib(rib) ; 
		}
		
		
	    // http://localhost:8083/BKFIN/Account/modify-Account
		@PutMapping("/modify-Account")
		@ResponseBody
		public Account modifyAccount(@RequestBody Account account) {
		return AccSercice.updateAccount(account);
		}
		
		//http://localhost:8083/BKFIN/Account/jereb/""
		
		
/*
		@GetMapping("/jereb/{n}")
		@ResponseBody
		public Long conversion (@PathVariable("n") String n)
		{
			return AccSercice.keyRib(n) ; 
		}
	
		*/
		//http://localhost:8083/BKFIN/Account/jereb1/	
		/*@GetMapping("/jereb1")
				@ResponseBody
				public String generateRib ()
				{
					return AccSercice.GenerateRib() ; 
				}
		*/
		
		//te3 taux d'interet ly bel cron
		//http://localhost:8083/BKFIN/Account/interethehy
		@PostMapping("/interethehy")
		@ResponseBody
		public void jaraaab () {
		AccSercice.GetInterestAmount() ; 
		}		
		
		//http://localhost:8083/BKFIN/Account/port/pdf
		@GetMapping("/export/pdf")
		public void exportToPDF(HttpServletResponse response , @RequestBody Account c) throws DocumentException, IOException {
	    response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=BankingIdentity_" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);
		//Account acc= AccSercice.retrieveAccount(c.getRib());
		AccountPdfExporter exporter = new AccountPdfExporter(c);
		exporter.export(response);
		}

		
}
