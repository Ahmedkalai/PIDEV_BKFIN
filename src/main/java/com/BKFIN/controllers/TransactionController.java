package com.BKFIN.controllers;

import java.util.List;

import javax.mail.MessagingException;

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

import com.BKFIN.entities.Transaction;
import com.BKFIN.services.ITransactionService;



@RestController
@RequestMapping("/Transaction")
public class TransactionController {

	@Autowired
	ITransactionService TransactionService ; 
	
	// http://localhost:8083/bkfin/Transaction/retrieve-all-Transactions
	@GetMapping("/retrieve-all-Transactions")
	@ResponseBody
	public List<Transaction> getTransactions() {
	List<Transaction> listTransactions = TransactionService.retrieveAllTransactions();
	return listTransactions;
	}
	
	// http://localhost:8083/bkfin/Transaction/retrieve-Transaction/8
	@GetMapping("/retrieve-Transaction/{Transaction}")
	@ResponseBody
	public Transaction retrieveTransaction(@PathVariable("Transaction") Long TransactionId) {
	return TransactionService.retrieveTransaction(TransactionId);
	}
	
	// http://localhost:8083/bkfin/Transaction/add-Transaction/200
	@PostMapping("/add-Transaction")
	@ResponseBody
	public int addTransaction(@RequestBody Transaction o ) throws MessagingException
	{
	int Transaction = TransactionService.addTransaction(o) ; 
	return Transaction ;
	}
	
	
	// http://localhost:8083/bkfin/Transaction/app-Transaction
		@PostMapping("/app-Transaction")
		@ResponseBody
		public String approveTransaction(@RequestBody Transaction o  ) throws MessagingException
		{
		String Transaction = TransactionService.approveTransaction(o) ; 
		return Transaction ;
		}
	
	
	//http://localhost:8083/bkfin/Transaction/retrieve-TransactionsEmises/2831
	@GetMapping("/retrieve-TransactionsEmises/{ribEmet}")
	@ResponseBody
	public List<Transaction> getTransactionsEmisesByRib (@PathVariable("ribEmet") Long rib)
	{
		return TransactionService.retrieveAllTransactionsEmisesByRib(rib) ; 
	}
	
	
	// http://localhost:8083/bkfin/Transaction/modify-Transaction
	//@PutMapping("/modify-Transaction")
	//@ResponseBody
	//public Transaction modifyTransaction(@RequestBody Transaction Transaction) {
	//return TransactionService.updateTransaction(Transaction);
	//}
}
