package com.BKFIN.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.BKFIN.entities.Credit;
@Repository
public interface CreditRepository extends CrudRepository<Credit, Long> {

}
