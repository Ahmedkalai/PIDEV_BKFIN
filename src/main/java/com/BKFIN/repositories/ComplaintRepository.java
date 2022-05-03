package com.BKFIN.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.BKFIN.entities.Complaint;

@Repository
public interface ComplaintRepository extends CrudRepository<Complaint,Long >  {
	@Query("SELECT c FROM Complaint c WHERE c.clientcomp.id= :cl")
	List<Complaint> getComplaintByClient(@Param("cl") Long idClient);
}
