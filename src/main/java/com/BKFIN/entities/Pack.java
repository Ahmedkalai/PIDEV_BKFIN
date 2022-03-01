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
import javax.persistence.OneToMany;

@Entity
public class Pack implements Serializable {
	
	
	
	
	@Id
	 @Column(name ="idPack")
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private long idPack ; 
	 private String packType ; 
	 private String descriptionPack ; 
	 private String secteurPack ;
	 private Boolean statePack ;
	 private String imagePack; 
	 @OneToMany(cascade = CascadeType.ALL, mappedBy="pack_credit")
		private Set<Credit> credit;
	 @ManyToMany(cascade = CascadeType.ALL)
	 private Set<Product> product_pack;
	public long getIdPack() {
		return idPack;
	}
	public void setIdPack(long idPack) {
		this.idPack = idPack;
	}
	public String getPackType() {
		return packType;
	}
	public void setPackType(String packType) {
		this.packType = packType;
	}
	public String getDescriptionPack() {
		return descriptionPack;
	}
	public void setDescriptionPack(String descriptionPack) {
		this.descriptionPack = descriptionPack;
	}
	public String getSecteurPack() {
		return secteurPack;
	}
	public void setSecteurPack(String secteurPack) {
		this.secteurPack = secteurPack;
	}
	public Boolean getStatePack() {
		return statePack;
	}
	public void setStatePack(Boolean statePack) {
		this.statePack = statePack;
	}
	public String getImagePack() {
		return imagePack;
	}
	public void setImagePack(String imagePack) {
		this.imagePack = imagePack;
	}
	public Set<Credit> getCredit() {
		return credit;
	}
	public void setCredit(Set<Credit> credit) {
		this.credit = credit;
	}
	public Set<Product> getProduct_pack() {
		return product_pack;
	}
	public void setProduct_pack(Set<Product> product_pack) {
		this.product_pack = product_pack;
	}
	 

}
