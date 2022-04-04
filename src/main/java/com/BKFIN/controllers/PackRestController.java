package com.BKFIN.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.BKFIN.entities.Pack;

import com.BKFIN.services.PackServiceImpl;

@RestController
@RequestMapping("/Pack")
public class PackRestController {
	@Autowired
	PackServiceImpl PCI;
//AJOUT PACK
	@PostMapping("/ajouterPack")
	public void ajouterPack(@RequestBody Pack pack) {
		PCI.addPack(pack);
		}
//AFFICHAGE LISTE PACK
@GetMapping("/viewPacks")
@ResponseBody
	public List<Pack> getPacks(){
		List<Pack> lp=PCI.retrieveAllPacks();
		return lp;
	}
//AFFICHAGE LISTE PACK ACTIFS
@GetMapping("/viewPacksActif")
@ResponseBody
	public List<Pack> getPacksActifs(){
		List<Pack> lp=PCI.retrieveAllActivePacks();
		return lp;
	}

//AFFICHAGE PACK
@GetMapping("/viewPack/{idPack}")
@ResponseBody
    public Pack getPack(@PathVariable("idPack") Long IdPack) {
	Pack p= PCI.retrievePack(IdPack);
	return p;
}

//SUPPRESSION PACK
@DeleteMapping("deleteP/{idPack}")
public void deletePack(@PathVariable("idPack") Long IdPack) {
	 PCI.deletePack(IdPack);
}

//MODIFICATION PACK 
@PutMapping("/updatePack")
@ResponseBody
public Pack updatePack(@RequestBody Pack p) {
	Pack pack =PCI.updatePack(p);
	return pack;
}
//state 
@PutMapping("/statepack/{idPack}/{statePack}")
@ResponseBody
public Pack statePack(@PathVariable("idPack") Long id,@PathVariable("statePack") Boolean valeur ) {
	Pack pack =PCI.setState(id, valeur);
	return pack;
	
}

@PutMapping("/priceP")
@ResponseBody
public void affecter() {
PCI.prixPack();
	
}


}
