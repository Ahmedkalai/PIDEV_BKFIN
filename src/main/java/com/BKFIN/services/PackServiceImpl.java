package com.BKFIN.services;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.BKFIN.entities.Pack;
import com.BKFIN.entities.Product;
import com.BKFIN.repositories.PackRepository;
@Service
public class PackServiceImpl implements IPackService  {
	@Autowired
	PackRepository PackRepository;
	
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
	public Pack setState(Long id,Boolean val) {
		Pack pack= PackRepository.findById(id) .orElse(null) ; 
		if( pack.getStatePack()!=val) {
			pack.setStatePack(val);}
		 return PackRepository.save(pack);
	}
	
	public void prixPack() {
		List<Pack> pc=(List<Pack>) PackRepository.findAll();
		float c=0;
		for (Pack pack2 : pc) {
			Set<Product> p=pack2.getProduct_pack();
			for(Product pr:p) {
				c=c+pr.getValueProduct();
				}
			pack2.setPriceP(c);
			PackRepository.save(pack2);
			c=0;
			
				 
			
			
			}
		}
	}
	
	

