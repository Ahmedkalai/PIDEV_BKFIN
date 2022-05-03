package com.BKFIN.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.BKFIN.entities.Account;
import com.BKFIN.entities.Transaction;
import com.BKFIN.entities.Typeaccount;


public interface AccountRepository extends JpaRepository<Account, String>{
	    //@Query("SELECT c FROM Account c WHERE c.Typeaccount= :=CURRENTACCOUNT")
		//List<Account>retrieveCurrentAccounts(
		//@Param("CURRENTACCOUNT") Typeaccount typCURRENTACCOUNTeaccount );
	
	List<Account> findByTypeAccount(Typeaccount type);
	
	@Query("SELECT c FROM Account c WHERE c.clientAcc.id= :id ")
	List<Account> getlistAccCLIENT(@Param("id") Long id);
	/*
	@Query("SELECT c FROM Account c WHERE c.Transactions= :rib")
	List<Transaction> getTransactionRecuesByRibRecipientAccount(@Param("rib") Long rib);
*/
}
