package com.BKFIN.repositories;


import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.BKFIN.entities.*;



@Repository
public interface AgentRepository extends CrudRepository<Agent,Long> {
	@Query(" select u from Agent u " + " where u.email = ?1")
    Optional<Agent> findUserWithName(String username);
	
	@Query(" select u from Agent u " + " where u.email = ?1")
    Agent findUser (String username);
}
