package com.BKFIN.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Transaction implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idTransaction")
	private Long idTransaction ; 
	@Temporal (TemporalType.DATE)
	private Date dateTransaction ;
	private String RibRecipient;
	private String RibEmetteur;
	private float amount;
	
	
	
	@ManyToOne()
	Account compte_bancaire ; 
	
	
	 public Long getIdTransaction() {
		return idTransaction;
	}
	public void setIdTransaction(Long idTransaction) {
		this.idTransaction = idTransaction;
	}
	public Date getDateTransaction() {
		return dateTransaction;
	}
	public void setDateTransaction(Date dateTransaction) {
		this.dateTransaction = dateTransaction;
	}
	
	public float getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public Account getCompte_Bancaire() {
		return compte_bancaire;
	}
	public void setCompte_Bancaire(Account compte_Bancaire) {
		this.compte_bancaire = compte_Bancaire;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public String getRibRecipient() {
		return RibRecipient;
	}
	public void setRibRecipient(String ribRecipient) {
		RibRecipient = ribRecipient;
	}
	public String getRibEmetteur() {
		return RibEmetteur;
	}
	public void setRibEmetteur(String ribEmetteur) {
		RibEmetteur = ribEmetteur;
	}
	public Account getCompte_bancaire() {
		return compte_bancaire;
	}
	public void setCompte_bancaire(Account compte_bancaire) {
		this.compte_bancaire = compte_bancaire;
	}
	public Transaction(Long idTransaction, Date dateTransaction, String ribRecipient, String ribEmetteur, float amount,
			Account compte_bancaire) {
		super();
		this.idTransaction = idTransaction;
		this.dateTransaction = dateTransaction;
		this.RibRecipient = ribRecipient;
		this.RibEmetteur = ribEmetteur;
		this.amount = amount;
		this.compte_bancaire = compte_bancaire;
	}
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
	
	
	
	

}
