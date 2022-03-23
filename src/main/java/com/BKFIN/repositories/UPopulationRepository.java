package com.BKFIN.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.BKFIN.entities.unemployedpopulation;



@Repository
public interface UPopulationRepository extends CrudRepository<unemployedpopulation, Long>{

	@Query(value = "SELECT DISTINCT regions FROM unemployedpopulation WHERE environment= ?1", nativeQuery = true)
	List<String> getRegionByEnvironment(String environment);
	
	
		
}
