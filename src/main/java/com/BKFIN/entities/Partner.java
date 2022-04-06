package com.BKFIN.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Partner implements Serializable {
	
	
	@Id
	 @Column(name ="Partner")
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private long idPartner ; 
	 private String activitePartner ; 
	 private Float pricePartner ; 
	 private String namePartner ;
	 private String sectorPartner ;
	 private String urlPartner; 
	 private String logoPartner;
	 @OneToMany(cascade = CascadeType.ALL, mappedBy="partner_product")
		private Set<Product> products;
	public long getIdPartner() {
		return idPartner;
	}
	public void setIdPartner(long idPartner) {
		this.idPartner = idPartner;
	}
	public String getActivitePartner() {
		return activitePartner;
	}
	public void setActivitePartner(String activitePartner) {
		this.activitePartner = activitePartner;
	}
	public Float getPricePartner() {
		return pricePartner;
	}
	public void setPricePartner(Float pricePartner) {
		this.pricePartner = pricePartner;
	}
	public String getNamePartner() {
		return namePartner;
	}
	public void setNamePartner(String namePartner) {
		this.namePartner = namePartner;
	}
	public String getSectorPartner() {
		return sectorPartner;
	}
	public void setSectorPartner(String sectorPartner) {
		this.sectorPartner = sectorPartner;
	}
	public String getUrlPartner() {
		return urlPartner;
	}
	public void setUrlPartner(String urlPartner) {
		this.urlPartner = urlPartner;
	}
	public String getLogoPartner() {
		return logoPartner;
	}
	public void setLogoPartner(String logoPartner) {
		this.logoPartner = logoPartner;
	}
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	public Partner() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Partner(long idPartner, String activitePartner, Float pricePartner, String namePartner, String sectorPartner,
			String urlPartner, String logoPartner, Set<Product> products) {
		super();
		this.idPartner = idPartner;
		this.activitePartner = activitePartner;
		this.pricePartner = pricePartner;
		this.namePartner = namePartner;
		this.sectorPartner = sectorPartner;
		this.urlPartner = urlPartner;
		this.logoPartner = logoPartner;
		this.products = products;
	}

	
	
  
}
