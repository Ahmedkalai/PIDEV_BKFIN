package com.BKFIN.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.BKFIN.entities.Fund;

@Repository
public interface FundRepository extends CrudRepository<Fund, Long> {
	

}
