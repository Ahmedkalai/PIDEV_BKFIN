package com.BKFIN.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.BKFIN.entities.DuesHistory;

@Repository

public interface DuesHistoryRepository extends CrudRepository<DuesHistory, Long> {

}
