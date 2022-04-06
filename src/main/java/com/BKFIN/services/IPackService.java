package com.BKFIN.services;

import java.util.List;

import com.BKFIN.entities.Pack;

public interface IPackService {
	List<Pack> retrieveAllPacks();

	Pack addPack (Pack pr);
	

	void deletePack (Long id);

	Pack updatePack (Pack pr);

	Pack retrievePack (Long id);
}
