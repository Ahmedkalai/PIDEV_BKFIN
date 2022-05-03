package com.BKFIN.services;

import java.util.List;
import java.util.Set;

import com.BKFIN.entities.Account;
import com.BKFIN.entities.Transaction;



public interface IAccountService {

	List<Account> retrieveAllAccounts();
	
	public Account addAccount (Account a, Long idClient ) ; 
	
	void deleteAccount(String id);
	public String GenerateRib() ; 
	Account updateAccount(Account u , String rib);
    Account retrieveAccount(String id);
	//public List<Transaction> retrieveAllTransactionsEmisesByRib(Long rib) ;
	//public List<Transaction> retrieveAllTransactionsRecuesByRib(Long rib) ;
    public Set<Transaction> retrieveAllTransactionsEmises1ByRib( String rib ); 
    public void GetInterestAmount();
     List<Account> retrieveAllaccountsByclient(Long id) ; 
      void alimenteAcc ( String rib , float amount ) ; 
    
}
