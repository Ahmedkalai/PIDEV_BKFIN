package com.BKFIN.services;

import java.util.List;

import javax.mail.MessagingException;

import com.BKFIN.entities.Product;



public interface IProductService {
	List<Product> retrieveAllProducts();

	Product addProduct (Product pr, Long partnerid);
	
	void deleteProduct (Long id);

	Product updateProduct (Product pr, Long partnerid);
	
	Product retrieveProduct (Long id);
	void affecterproductpack(Long productid, Long packid) throws MessagingException;
	void supprimerproductpack(Long productid, Long packid);
}
