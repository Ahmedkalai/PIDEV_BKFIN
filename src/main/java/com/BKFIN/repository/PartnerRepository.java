package com.BKFIN.repository;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.BKFIN.entities.Partner;


@Repository
public interface PartnerRepository extends CrudRepository<Partner,Long> {
	

	

}
