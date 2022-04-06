package com.BKFIN.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.BKFIN.entities.Client;
@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {

}
