package com.BKFIN.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.BKFIN.entities.Transaction;


public interface TransactionRespository extends CrudRepository<Transaction, Long> {
	
	
	
	@Query("SELECT t FROM Transaction t WHERE t.compte_bancaire.Rib= :rib")
	List<Transaction> getTransactionEmiseByRibAccount(@Param("rib") String rib);
	
	@Query("SELECT T FROM Transaction T WHERE T.RibRecipient= :rib OR T.RibEmetteur= :rib ")
	List<Transaction> getTransactionByRibAccount(@Param("rib") String rib);
	
	
	/*@Query("SELECT t FROM Transaction t WHERE  t.RibRecipient= :rib1 and t.compte_bancaire.typeAccount="SAVINGSACCOUNT" ")
	List<Transaction> getVersementByRibAccount(@Param("rib1") String rib);*/
	
	//@Query("SELECT t FROM Transaction t WHERE t.RibRecipient= :rib OR t.RibRecipient= :RibEmetteur ")
	//List<Transaction> getTransactionByRibAccount(@Param("rib") String rib);
	

}
