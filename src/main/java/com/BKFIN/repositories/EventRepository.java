package com.BKFIN.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.BKFIN.entities.Event;



@Repository
public interface EventRepository extends CrudRepository<Event, Long> {

}
