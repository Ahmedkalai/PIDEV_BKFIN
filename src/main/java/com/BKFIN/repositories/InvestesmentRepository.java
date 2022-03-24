package com.BKFIN.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.BKFIN.entities.Investesment;


@Repository
public interface InvestesmentRepository  extends CrudRepository<Investesment, Long>{

}
