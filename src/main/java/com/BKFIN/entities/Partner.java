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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Partner implements Serializable {
	
	
	@Id
	 @Column(name ="Partner")
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private long idPartner ; 
	 private String activitePartner ; 
	 
	 private String namePartner ;
	 private String sectorPartner ;
	 private String urlPartner; 
	 private String logoPartner;
	 private String emailPartner;
	 public String getEmailPartner() {
		return emailPartner;
	}
	public void setEmailPartner(String emailPartner) {
		this.emailPartner = emailPartner;
	}
	@JsonIgnore
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
	
  
}
