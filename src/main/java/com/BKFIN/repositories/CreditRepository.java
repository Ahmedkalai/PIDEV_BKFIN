package com.BKFIN.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.BKFIN.entities.Credit;

@Repository

public interface CreditRepository extends	CrudRepository<Credit, Long>{


	//Chercher les credits incomplets
	@Query("SELECT c FROM Credit c WHERE c.client.cin= :idclient and c.Completed = false and c.state = true ")
	List<Credit> getIncompletedCreditsByClient(@Param("idclient") Long idClient);	
	
	//Chercher si un client a un credit actif .
	@Query("SELECT c FROM Credit c WHERE c.client.cin= :idclient and c.state = true ")
	List<Credit> getApprovedCreditsByClient(@Param("idclient") Long idClient);
	
	//selectionner le dernier credit complet pour tester son historique
	@Query(value = "SELECT * FROM credit c WHERE c.client_cin=?1 and c.state=true and c.completed=true ORDER BY obtaining_date DESC limit 1" , nativeQuery =true)
	Credit getIDofLatestCompletedCreditsByClient(Long idClient);		
	
	
}
