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
@Entity
public class Fund  implements Serializable {
	@Id
	 @Column(name ="idFund")
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private long idFund ; 
	 private float amountFund ;
	 private float tauxFund ;
	 @OneToMany(mappedBy="funds")
	 private Set<Credit> credits ;
	 @OneToMany(mappedBy="fund")
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
	 
	 
}
