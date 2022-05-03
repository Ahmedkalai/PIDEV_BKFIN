package com.BKFIN.controllers;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.BKFIN.entities.Product;
import com.BKFIN.services.PDFGeneratorService;
import com.BKFIN.services.ProductServiceImpl;
@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/Produit")
public class ProductRestController {
@Autowired 
ProductServiceImpl PSI;
// AFFECTER UN PRODUIT A UN PACK
@PostMapping("/addprpc/{idProduct}/{idPack}")
public void assignprpc(@PathVariable("idProduct") Long productId ,@PathVariable("idPack")Long packid) {
	PSI.affecterproductpack(productId, packid);
}
//SUPPRIMER UN PRODUIT D UN PACK
@DeleteMapping("/delprpc/{idProduct}/{idPack}")
public void deleteprpc(@PathVariable("idProduct") Long productId ,@PathVariable("idPack")Long packid) {
	PSI.supprimerproductpack(productId, packid);
}
//AJOUTER UN PRODUIT
@PostMapping("/addProduct/{idPartner}")
public void ajouterPrd(@RequestBody Product prd, @PathVariable("idPartner") Long idp ) {
	PSI.addProduct(prd, idp);
}
//AFFICHAGE LISTE PRODUIT
@GetMapping("/viewProducts")
@ResponseBody
public List<Product> getProducts(){
	List<Product> lp=PSI.retrieveAllProducts();
	return lp;
}
//AFFICHAGE PRODUIT
@GetMapping("viewProduct/{idProduct}")
@ResponseBody
public Product getProduct(@PathVariable("idProduct") Long IdProduct) {
	Product p = PSI.retrieveProduct(IdProduct);
	return p;
}

//SUPPRESSION PRODUIT
@DeleteMapping("deleteP/{idProduct}")
public void deleteProduct(@PathVariable("idProduct") Long IdProduct) {
	 PSI.deleteProduct(IdProduct);
}

//MODIFICATION PRODUIT
@PutMapping("/updateProduct/{IdPartner}")
	@ResponseBody
	public Product updateProduct(@RequestBody Product p,@PathVariable("IdPartner") Long id) {
		Product prd=PSI.updateProduct(p, id);
		return prd;
		
	}
@GetMapping(value = "/PDF")
public ResponseEntity<InputStreamResource> employeeReport() throws IOException {
List<Product> p = (List<Product>) PSI.retrieveAllProducts();

ByteArrayInputStream bis = PDFGeneratorService.employeePDFReport(p);
HttpHeaders headers = new HttpHeaders();
headers.add("Content-Disposition", "inline; filename=Products.pdf");

return ResponseEntity.ok().headers(headers)
  .body(new InputStreamResource(bis));
}

	
}

