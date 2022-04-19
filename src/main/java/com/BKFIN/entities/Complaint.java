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
public class Complaint implements Serializable {
	
	@Id
	 @Column(name ="idComplaint")
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private long idComplaint ; 
	 private String informationText ; 
	 private Boolean state ; 
	 @Temporal (TemporalType.DATE)
	 private Date dateComplaint ;
	 private String object ; 
	@ManyToOne
	@JsonIgnore
     private Client clientcomp;
	public long getIdComplaint() {
		return idComplaint;
	}
	public void setIdComplaint(long idComplaint) {
		this.idComplaint = idComplaint;
	}
	public String getInformationText() {
		return informationText;
	}
	public void setInformationText(String informationText) {
		this.informationText = informationText;
	}
	public Boolean getState() {
		return state;
	}
	public void setState(Boolean state) {
		this.state = state;
	}
	public Date getDateComplaint() {
		return dateComplaint;
	}
	public void setDateComplaint(Date dateComplaint) {
		this.dateComplaint = dateComplaint;
	}
	public String getObject() {
		return object;
	}
	public void setObject(String object) {
		this.object = object;
	}
	public Client getClientcomp() {
		return clientcomp;
	}
	public void setClientcomp(Client clientcomp) {
		this.clientcomp = clientcomp;
	}
	
	 
	 
	 
	 
	 
}
