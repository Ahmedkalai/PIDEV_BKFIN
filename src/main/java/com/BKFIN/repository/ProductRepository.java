package com.BKFIN.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.BKFIN.entities.Product;
@Repository
public interface ProductRepository extends CrudRepository<Product,Long> {

}
