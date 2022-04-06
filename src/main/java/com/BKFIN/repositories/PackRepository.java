package com.BKFIN.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.BKFIN.entities.Pack;
@Repository
public interface PackRepository extends CrudRepository<Pack,Long> {
	@Query("SELECT f FROM Pack f WHERE f.statePack= :st")
	List<Pack> getstpack(@Param("st") Boolean statePack);

}
