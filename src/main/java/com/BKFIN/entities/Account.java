package com.BKFIN.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Account implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Rib")
	private Long Rib ; 
	private Long idAccount;
	private Long sold;
	@Temporal (TemporalType.DATE)
	private Date openDate ;
	private Boolean state;
	@Enumerated(EnumType.STRING)
	private Typeaccount typeAccount;
    @ManyToOne
	private Client clientAcc;
    @ManyToMany
	private Set<Transaction> accountT;
	public Long getRib() {
		return Rib;
	}
	public void setRib(Long rib) {
		Rib = rib;
	}
	public Long getIdAccount() {
		return idAccount;
	}
	public void setIdAccount(Long idAccount) {
		this.idAccount = idAccount;
	}
	public Long getSold() {
		return sold;
	}
	public void setSold(Long sold) {
		this.sold = sold;
	}
	public Date getOpenDate() {
		return openDate;
	}
	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}
	public Boolean getState() {
		return state;
	}
	public void setState(Boolean state) {
		this.state = state;
	}
	public Typeaccount getTypeAccount() {
		return typeAccount;
	}
	public void setTypeAccount(Typeaccount typeAccount) {
		this.typeAccount = typeAccount;
	}
	public Client getClientAcc() {
		return clientAcc;
	}
	public void setClientAcc(Client clientAcc) {
		this.clientAcc = clientAcc;
	}
	public Set<Transaction> getAccountT() {
		return accountT;
	}
	public void setAccountT(Set<Transaction> accountT) {
		this.accountT = accountT;
	}
    
	
	

}
