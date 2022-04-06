package com.BKFIN.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Product implements Serializable {
	@Id
	 @Column(name ="idProduct")
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private long idProduct ; 
	 private String nameProduct ;
	 private Float valueProduct ;
	 @ManyToMany(mappedBy="product_pack", cascade = CascadeType.ALL)
	 @JsonIgnore
	 private Set<Pack> packs;
	 @JsonIgnore
	 @ManyToOne
		private Partner partner_product;
	public long getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(long idProduct) {
		this.idProduct = idProduct;
	}
	public String getNameProduct() {
		return nameProduct;
	}
	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}
	public Float getValueProduct() {
		return valueProduct;
	}
	public void setValueProduct(Float valueProduct) {
		this.valueProduct = valueProduct;
	}
	public Set<Pack> getPacks() {
		return packs;
	}
	public void setPacks(Set<Pack> packs) {
		this.packs = packs;
	}
	public Partner getPartner_product() {
		return partner_product;
	}
	public void setPartner_product(Partner partner_product) {
		this.partner_product = partner_product;
	}
	 

}
