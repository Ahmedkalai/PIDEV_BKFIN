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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Credit implements Serializable {
	
	@Id
	@Column(name ="idCredit")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCredit; 
	private Long amount;
	@Temporal (TemporalType.DATE)
	private Date dateDemande;
	@Temporal (TemporalType.DATE)
	private Date obtainingDate ;
	private Boolean state;
	@Temporal (TemporalType.DATE)
	private Date monthlyPaymentDate;
	private Long monthlyPaymentAmount;
	private float interestRate;
	@OneToOne(mappedBy="credit")
	private Garantor garantor;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="credit")
	private Set<Notification> notifications ;
	@ManyToOne
	private Client client;
	@ManyToOne
	private Fund funds;
	@OneToMany(mappedBy="credits")
	private Set<DuesHistory> duesHistory ;
	@ManyToOne
    private Pack pack_credit;
	public Long getIdCredit() {
		return idCredit;
	}
	public void setIdCredit(Long idCredit) {
		this.idCredit = idCredit;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public Date getDateDemande() {
		return dateDemande;
	}
	public void setDateDemande(Date dateDemande) {
		this.dateDemande = dateDemande;
	}
	public Date getObtainingDate() {
		return obtainingDate;
	}
	public void setObtainingDate(Date obtainingDate) {
		this.obtainingDate = obtainingDate;
	}
	public Boolean getState() {
		return state;
	}
	public void setState(Boolean state) {
		this.state = state;
	}
	public Date getMonthlyPaymentDate() {
		return monthlyPaymentDate;
	}
	public void setMonthlyPaymentDate(Date monthlyPaymentDate) {
		this.monthlyPaymentDate = monthlyPaymentDate;
	}
	public Long getMonthlyPaymentAmount() {
		return monthlyPaymentAmount;
	}
	public void setMonthlyPaymentAmount(Long monthlyPaymentAmount) {
		this.monthlyPaymentAmount = monthlyPaymentAmount;
	}
	public float getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(float interestRate) {
		this.interestRate = interestRate;
	}
	public Garantor getGarantor() {
		return garantor;
	}
	public void setGarantor(Garantor garantor) {
		this.garantor = garantor;
	}
	public Set<Notification> getNotifications() {
		return notifications;
	}
	public void setNotifications(Set<Notification> notifications) {
		this.notifications = notifications;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Fund getFunds() {
		return funds;
	}
	public void setFunds(Fund funds) {
		this.funds = funds;
	}
	public Set<DuesHistory> getDuesHistory() {
		return duesHistory;
	}
	public void setDuesHistory(Set<DuesHistory> duesHistory) {
		this.duesHistory = duesHistory;
	}
	public Pack getPack_credit() {
		return pack_credit;
	}
	public void setPack_credit(Pack pack_credit) {
		this.pack_credit = pack_credit;
	}
	

}
