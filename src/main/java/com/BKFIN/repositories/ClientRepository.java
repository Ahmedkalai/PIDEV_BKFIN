package com.BKFIN.repositories;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.BKFIN.entities.*;

@Repository
public interface ClientRepository extends CrudRepository<Client,Long> {

	/*@Query("SELECT c FROM Client c WHERE c.agent=:id")
	Set<Client> getClientsByAgent(@Param("id") Long idAgent);*/
	@Query(" select u from Client u " + " where u.email = ?1")
    Optional<Client> findUserWithName(String username);
	
	@Query(" select u from Client u " + " where u.email = ?1")
    Client findUser(String username);
	
}
