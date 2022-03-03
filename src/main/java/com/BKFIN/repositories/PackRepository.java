package com.BKFIN.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.BKFIN.entities.Pack;

@Repository
public interface PackRepository extends CrudRepository<Pack, Long> {
	

}
