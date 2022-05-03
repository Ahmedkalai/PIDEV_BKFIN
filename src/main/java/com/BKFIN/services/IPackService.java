package com.BKFIN.services;

import java.util.List;
import java.util.Set;

import com.BKFIN.entities.Pack;
import com.BKFIN.entities.Product;

public interface IPackService {
	List<Pack> retrieveAllPacks();
    List<Pack> retrieveAllActivePacks();

	Pack addPack (Pack pr);
	

	void deletePack (Long id);

	Pack updatePack (Pack pr);

	Pack retrievePack (Long id);
	Pack setState(Long id);
	Pack createandaffect(Pack pr,List<Long> p);
	Pack updateandaffect(Pack pr,List<Long> p);
}
