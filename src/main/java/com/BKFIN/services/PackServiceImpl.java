package com.BKFIN.services;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.BKFIN.entities.Pack;
import com.BKFIN.entities.Product;
import com.BKFIN.repositories.PackRepository;
import com.BKFIN.repositories.ProductRepository;
@Service
public class PackServiceImpl implements IPackService  {
	@Autowired
	PackRepository PackRepository;
	@Autowired
	ProductRepository prdrepo;
	@Override
	public List<Pack> retrieveAllPacks() {
		List<Pack> packs = (List<Pack>) PackRepository.findAll();
		
		return packs;
	}
	//
	@Override
	public List<Pack> retrieveAllActivePacks() {
		List<Pack> packs = (List<Pack>) PackRepository.getstpack(true);
		
		return packs;
	}
	
	@Override
	public Pack addPack(Pack p) {
		return  PackRepository.save(p);
		
	}
	@Override
	public void deletePack(Long id) {
		PackRepository.deleteById(id);
		System.out.println("pack deleted");
	}
	@Override
	public Pack updatePack(Pack pack) {
		
			return PackRepository.save(pack);
		}

	
	@Override
	public Pack retrievePack(Long id) {
		Pack pack= PackRepository.findById(id) .orElse(null) ; 
		return pack ;
	}
	@Override
	public Pack setState(Long id){
		Pack pack= PackRepository.findById(id) .orElse(null) ; 
		if( pack.getStatePack()==null  ) {
			pack.setStatePack(false);}
		else if (pack.getStatePack()==false) {
			pack.setStatePack(true);
		}
		else pack.setStatePack(false);
		 return PackRepository.save(pack);
	}
	
	public void prixPack() {
		List<Pack> pc=(List<Pack>) PackRepository.findAll();
		float c=0;
		for (Pack pack2 : pc) {
		c=c+pack2.getPriceP();
		Set<Product> p=pack2.getProduct_pack();
		for(Product pr:p) {
		c=c+pr.getValueProduct();
		}
		pack2.setPriceP(c);
		PackRepository.save(pack2);
		c=0;
		}
		}
	
	@Override
	public Pack createandaffect(Pack pr, List<Long> p) {
		Set<Product> prod=new HashSet<Product>();
		float price=0;
		for(Long idp:p) {
			Product product= prdrepo.findById(idp).orElse(null) ;
			prod.add(product);
			
		}
		pr.setProduct_pack(prod);
		for (Product produit:prod) {
			if(produit.getValueProduct()<100)
				price=price + produit.getValueProduct()*93/100;
			else if ((produit.getValueProduct()<1000) && (produit.getValueProduct()>100))
				price = price + produit.getValueProduct()*95/100;
			else {
				price= price + produit.getValueProduct()*97/100;
		}}
		pr.setPriceP(price);
		
		 return PackRepository.save(pr);
		  
		
	}
	@Override
	public Pack updateandaffect(Pack pr, List<Long> p) {
		Set<Product> prod=new HashSet<Product>();
		float price=0;
		for(Long idp:p) {
			Product product= prdrepo.findById(idp).orElse(null) ;
			prod.add(product);
			
		}
		pr.setProduct_pack(prod);
		for (Product produit:prod) {
			if(produit.getValueProduct()<100)
				price=price + produit.getValueProduct()*93/100;
			else if ((produit.getValueProduct()<1000) && (produit.getValueProduct()>100))
				price = price + produit.getValueProduct()*95/100;
			else {
				price= price + produit.getValueProduct()*97/100;
		}}
		pr.setPriceP(price);
		
		 return PackRepository.save(pr);
		  
	}
}
	
	

