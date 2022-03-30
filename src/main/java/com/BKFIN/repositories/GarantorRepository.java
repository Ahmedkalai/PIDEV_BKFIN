package com.BKFIN.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.BKFIN.entities.Garantor;

@Repository

public interface GarantorRepository extends CrudRepository<Garantor, Long> {

}