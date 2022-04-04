package com.BKFIN.services;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.BKFIN.entities.Pack;
import com.BKFIN.entities.Partner;
import com.BKFIN.entities.Product;
import com.BKFIN.repositories.ProductRepository;
import com.BKFIN.repositories.PackRepository;
import com.BKFIN.repositories.PartnerRepository;

@Service
public class ProductServiceImpl implements IProductService {
	
	@Autowired
	EmailSenderService emsender;
	@Autowired
	ProductRepository ProductRepository;
	@Autowired
	PartnerRepository PartnerRepository;
	@Autowired
	PackRepository PackRepository;

	@Override
	public List<Product> retrieveAllProducts() {
		List<Product> products = (List<Product>) ProductRepository.findAll();
		return products;
	}

	@Override
	public Product addProduct(Product prod, Long partnerid) {
		Partner pr =PartnerRepository.findById(partnerid).get();
		prod.setPartner_product(pr);
	   ProductRepository.save(prod)	;
	  
	 return prod;
		
	}





	@Override
	public void deleteProduct(Long id) {
		ProductRepository.deleteById(id);
		
	}

	@Override
	public Product updateProduct(Product prod, Long partnerid) {
		Partner pr =PartnerRepository.findById(partnerid).get();
		prod.setPartner_product(pr);
	 return  ProductRepository.save(prod)	;
	  
	 

	}

	@Override
	public Product retrieveProduct(Long id) {
		Product prod= ProductRepository.findById(id) .orElse(null) ; 
		return prod ;
		
	}


	@Override
	public void affecterproductpack(Long productid, Long packid) {
		Product p = ProductRepository.findById(productid).get();
		Pack pack = PackRepository.findById(packid).get();
		Set<Product> ps=pack.getProduct_pack();
		ps.add(p);
		pack.setProduct_pack(ps);
		PackRepository.save(pack);
		String em=p.getPartner_product().getEmailPartner();
		emsender.sendSimpleEmail(em, "Votre produit "+p.getNameProduct()+" est désormais dans un nouvau pack "+pack.getPackType(),"Bonjour "+p.getPartner_product().getNamePartner()+" , Nouveau pack !");
		
	}
	@Override
	public void supprimerproductpack(Long productid, Long packid) {
		Product p = ProductRepository.findById(productid).get();
		Pack pack = PackRepository.findById(packid).get();
		Set<Product> ps=pack.getProduct_pack();
		ps.remove(p);
		pack.setProduct_pack(ps);
		PackRepository.save(pack);
		
	}
	@Scheduled(cron = "* * * 05 * *" )
	public void exclusivitePrix() {
	List<Product> pr=(List)(ProductRepository.findAll());
	for (Iterator iterator = pr.iterator(); iterator.hasNext();) {
		Product product = (Product) iterator.next();
		if(product.getValueProduct()<100) {
		product.setValueEXC(product.getValueProduct()*90/100);
		ProductRepository.save(product);}
		else if ((product.getValueProduct()<1000) && (product.getValueProduct()>100)) {
		product.setValueEXC(product.getValueProduct()*92/100);
		ProductRepository.save(product);}
		else {
			product.setValueEXC(product.getValueProduct()*94/100);
			ProductRepository.save(product);
		}
		}
	}
	

	}



