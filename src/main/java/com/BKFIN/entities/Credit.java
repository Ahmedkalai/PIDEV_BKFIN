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

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Credit implements Serializable {
	
	@Id
	@Column(name ="idCredit")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCredit; 
	private float amount;
	@Temporal (TemporalType.DATE)
	private Date dateDemande;
	@Temporal (TemporalType.DATE)
	private Date obtainingDate ;
	private Boolean state;
	//0 PAS DE DIFFERE 1 SI CREDIT A DIFFERE TOTAL
	private Boolean différé; 
	// PERIODE DE DIFFERE 
	private float DIFF_period;
	@Temporal (TemporalType.DATE)
	private Date monthlyPaymentDate;
	private float monthlyPaymentAmount;
	//taux d'interet en année
	private float interestRate;
	//periode de credit en année
	private float creditPeriod;
	private float Risk;
	private Boolean Completed;
	private String Reason;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="credit")
	private Set<Notification> notifications ;
	@ManyToOne
	@JsonIgnore
	private Client client;
	@ManyToOne
	private Fund funds;
	@OneToMany(mappedBy="credits")
	private Set<DuesHistory> duesHistory ;
	@ManyToOne
    private Pack pack_credit;
	@OneToOne(mappedBy="credit")
	private Garantor garantor;
	
	//GET&SET
	public float getCreditPeriod() {
		return creditPeriod;
	}
	public void setCreditPeriod(float creditPeriod) {
		this.creditPeriod = creditPeriod;
	}
	public float getRisk() {
		return Risk;
	}
	public void setRisk(float risk) {
		Risk = risk;
	}
	public Long getIdCredit() {
		return idCredit;
	}
	public void setIdCredit(Long idCredit) {
		this.idCredit = idCredit;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
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
	public float getMonthlyPaymentAmount() {
		return monthlyPaymentAmount;
	}
	public void setMonthlyPaymentAmount(float monthlyPaymentAmount) {
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
	public long getFunds() {
		return funds.getIdFund();
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
	public long getPack_credit() {
		return pack_credit.getIdPack();
	}
	public void setPack_credit(Pack pack_credit) {
		this.pack_credit = pack_credit;
	}
	
	public Boolean getCompleted() {
		return Completed;
	}
	public void setCompleted(Boolean completed) {
		Completed = completed;
	}
	public Boolean getDifféré() {
		return différé;
	}
	public void setDifféré(Boolean différé) {
		this.différé = différé;
	}
	public float getDIFF_period() {
		return DIFF_period;
	}
	public void setDIFF_period(float dIFF_period) {
		DIFF_period = dIFF_period;
	}
	public Credit() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Credit(Long idCredit, float amount, Date dateDemande, Date obtainingDate, Boolean state, Boolean différé,
			float dIFF_period, Date monthlyPaymentDate, float monthlyPaymentAmount, float interestRate,
			float creditPeriod, float risk, Boolean completed, String reason, Set<Notification> notifications,
			Client client, Fund funds, Set<DuesHistory> duesHistory, Pack pack_credit, Garantor garantor) {
		super();
		this.idCredit = idCredit;
		this.amount = amount;
		this.dateDemande = dateDemande;
		this.obtainingDate = obtainingDate;
		this.state = state;
		this.différé = différé;
		DIFF_period = dIFF_period;
		this.monthlyPaymentDate = monthlyPaymentDate;
		this.monthlyPaymentAmount = monthlyPaymentAmount;
		this.interestRate = interestRate;
		this.creditPeriod = creditPeriod;
		Risk = risk;
		Completed = completed;
		Reason = reason;
		this.notifications = notifications;
		this.client = client;
		this.funds = funds;
		this.duesHistory = duesHistory;
		this.pack_credit = pack_credit;
		this.garantor = garantor;
	}
	public String getReason() {
		return Reason;
	}
	public void setReason(String reason) {
		Reason = reason;
	}
	
	
	
	
	
	
}
