package com.BKFIN.services;

import java.util.List;

import javax.mail.MessagingException;

import com.BKFIN.entities.Transaction;





public interface ITransactionService {
	int  addTransaction(Transaction s )throws MessagingException ;
	public String  approveTransaction(Transaction s ) throws MessagingException ; 
	//Transaction updateTransaction(Transaction u);

	Transaction retrieveTransaction(Long id);
	List<Transaction> retrieveAllTransactions();
	public List<Transaction> retrieveAllTransactionsEmisesByRib(Long rib) ; 
	public List<Transaction> retrieveTransactions(String rib) ;

	public List<Transaction> AllTransactionsEmisesByRib(String rib) ; 
	

}
