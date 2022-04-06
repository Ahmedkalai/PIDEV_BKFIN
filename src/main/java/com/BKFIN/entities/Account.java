package com.BKFIN.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
//import java.util.Date;
//
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
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
public class Account implements Serializable {
	
	
	@Id
	@Column(name="Rib")
	private String Rib ; 
	private float sold ;
//ces deux attributs nous serons utiles pour le calcul du taux d'interet 
	private float interest;
//cette variable s'incremente à chaque fois que le cron programmé s'execute 
	private int index_interest;
	//@DateTimeFormat(pattern = "yyyy-MM-dd")
	//@Temporal (TemporalType.DATE)
	//private Date openDate ;
	 @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd H:m:s.S")
    private LocalDate openDate;
	
	private Boolean state;
	@Enumerated(EnumType.STRING)
	public Typeaccount typeAccount;
    
	@ManyToOne
  
	private Client clientAcc;
   
   @OneToMany(mappedBy = "compte_bancaire")

	private Set<Transaction> Transactions ;  
    
   public int getindex_interest() {
		return index_interest;
	}
	public void setindex_interest(int index_interest) {
		this.index_interest = index_interest;
	}
	public float getInterest() {
		return interest;
	}
	public void setInterest(float interest) {
		this.interest = interest;
	}
	public String getRib() {
	return Rib;
    }
public void setRib(String rib) {
	Rib = rib;
}
	public float getSold() {
		return sold;
	}
	public void setSold(float sold) {
		this.sold = sold;
	}
	/*
	public Date getOpenDate() {
		return openDate;
	}
	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}
	*/
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
	public Set<Transaction> getTransactions() {
		return Transactions;
	}
	public void setTransactions(Set<Transaction> transactions) {
		Transactions = transactions;
	}
	
	
	public LocalDate getOpenDate() {
		return openDate;
	}
	public void setOpenDate(LocalDate openDate) {
		this.openDate = openDate;
	}

	
	@Override
	public String toString() {
		return "Account [Rib=" + Rib + ", sold=" + sold + ", openDate=" + openDate
				+ ", state=" + state + ", typeAccount=" + typeAccount + ", clientAcc=" + clientAcc + ", Transactions="
				+ Transactions + "]";
	}
	public Account(String rib, Long idAccount, float sold, LocalDate openDate, Boolean state, Typeaccount typeAccount,
			Client clientAcc,int index_interest, float interest, Set<Transaction> transactions) {
		super();
		this.Rib = rib;
		this.sold = sold;
		this.openDate = openDate;
		this.state = state;
		this.typeAccount = typeAccount;
		this.clientAcc = clientAcc;
		this.interest = interest;
		this.index_interest = index_interest;
		Transactions = transactions;
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	
 
	
    
	
	

}
