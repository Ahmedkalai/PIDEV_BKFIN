package com.BKFIN.repositories;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.BKFIN.entities.*;

@Repository
public interface AdminRepository extends CrudRepository<Admin,Long> {
	@Query(" select u from Admin u " + " where u.email = ?1")
    Optional<Admin> findUserWithName(String username);
	@Query(" select u from Admin u " + " where u.email = ?1")
    Admin findUser(String username);
}
