package com.BKFIN.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BKFIN.entities.Pack;
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
	
	
}
