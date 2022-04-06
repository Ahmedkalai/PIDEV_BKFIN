package com.BKFIN.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Fund  implements Serializable {
	@Id
	 @Column(name ="idFund")
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private long idFund ; 
	 private float amountFund ;
	 private float tauxFund ;
	 private float winPourcentage;
	 
	 @OneToMany(mappedBy="funds")
	 private Set<Credit> credits ;
	 @OneToMany(mappedBy="fund")
	 @JsonIgnore
	 private Set<Investesment> invest;
	 
	public long getIdFund() {
		return idFund;
	}
	public void setIdFund(long idFund) {
		this.idFund = idFund;
	}
	public float getAmountFund() {
		return amountFund;
	}
	public void setAmountFund(float amountFund) {
		this.amountFund = amountFund;
	}
	public float getTauxFund() {
		return tauxFund;
	}
	public void setTauxFund(float tauxFund) {
		this.tauxFund = tauxFund;
	}
	public Set<Credit> getCredits() {
		return credits;
	}
	public void setCredits(Set<Credit> credits) {
		this.credits = credits;
	}
	public Set<Investesment> getInvest() {
		return invest;
	}
	public void setInvest(Set<Investesment> invest) {
		this.invest = invest;
	}
	public float getWinPourcentage() {
		return winPourcentage;
	}
	public void setWinPourcentage(float winPourcentage) {
		this.winPourcentage = winPourcentage;
	}
	public Fund(long idFund, float amountFund, float tauxFund, float winPourcentage, Set<Credit> credits,
			Set<Investesment> invest) {
		super();
		this.idFund = idFund;
		this.amountFund = amountFund;
		this.tauxFund = tauxFund;
		this.winPourcentage = winPourcentage;
		this.credits = credits;
		this.invest = invest;
	}
	public Fund() {
		super();
	}
	 
	 
}
