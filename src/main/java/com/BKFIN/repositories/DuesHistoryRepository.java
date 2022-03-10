package com.BKFIN.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.BKFIN.entities.Credit;
import com.BKFIN.entities.DuesHistory;

@Repository

public interface DuesHistoryRepository extends CrudRepository<DuesHistory, Long> {

	
	@Query("SELECT d FROM DuesHistory d WHERE d.credits.idCredit= :id_credit ")
	List<DuesHistory> getCredit_DuesHistory(@Param("id_credit") Long idcredit);	
}
