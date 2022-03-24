package com.BKFIN.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.BKFIN.entities.Agent;


@Repository
public interface AgentRepository extends CrudRepository<Agent, Long> {

}
