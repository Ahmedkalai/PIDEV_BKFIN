package com.BKFIN.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class DuesHistory implements Serializable {
	
	@Id
	@Column(name ="idDues")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDues; 
	@Temporal (TemporalType.DATE)
	private Date DateHistory;
	@ManyToOne
	@JsonIgnore
	private Credit credits;
	
	
	//GET&SET
	public Long getIdDues() {
		return idDues;
	}
	public void setIdDues(Long idDues) {
		this.idDues = idDues;
	}
	public Date getDateHistory() {
		return DateHistory;
	}
	public void setDateHistory(Date dateHistory) {
		DateHistory = dateHistory;
	}
	public Credit getCredits() {
		return credits;
	}
	public void setCredits(Credit credits) {
		this.credits = credits;
	}
	
	
	//CONSTRUCTOR
	
	
	public DuesHistory() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DuesHistory(Long idDues, Date dateHistory, Credit credits) {
		super();
		this.idDues = idDues;
		DateHistory = dateHistory;
		this.credits = credits;
	}
	
	
	
	
}
