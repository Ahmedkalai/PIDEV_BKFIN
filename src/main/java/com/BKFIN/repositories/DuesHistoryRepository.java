package com.BKFIN.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.BKFIN.entities.Account;
import com.BKFIN.entities.Credit;
import com.BKFIN.entities.DuesHistory;
import com.BKFIN.entities.Typeaccount;

@Repository

public interface DuesHistoryRepository extends CrudRepository<DuesHistory, Long> {

	
	@Query("SELECT d FROM DuesHistory d WHERE d.credits.idCredit= :id_credit ")
	List<DuesHistory> getCredit_DuesHistory(@Param("id_credit") Long idcredit);	
	
	@Query(value = "SELECT MAX(`supposed_date`) FROM `dues_history` WHERE `credits_id_credit`= ?1" , nativeQuery = true)
	List<Date> getLast_date(Long idcredit);	
}
