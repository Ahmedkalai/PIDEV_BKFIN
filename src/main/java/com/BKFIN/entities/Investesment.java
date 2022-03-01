package com.BKFIN.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Investesment  implements Serializable{
	@Id
	 @Column(name ="cinInvestesment")
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private long cinInvestesment ; 
	 private String nameInvestesment ;
	 private String secondnnameInvestesment ;
	 private String professionInvestesment ;
	 private float amoutInvestesment;
	 @ManyToOne
	 private Fund fund;
	public long getCinInvestesment() {
		return cinInvestesment;
	}
	public void setCinInvestesment(long cinInvestesment) {
		this.cinInvestesment = cinInvestesment;
	}
	public String getNameInvestesment() {
		return nameInvestesment;
	}
	public void setNameInvestesment(String nameInvestesment) {
		this.nameInvestesment = nameInvestesment;
	}
	public String getSecondnnameInvestesment() {
		return secondnnameInvestesment;
	}
	public void setSecondnnameInvestesment(String secondnnameInvestesment) {
		this.secondnnameInvestesment = secondnnameInvestesment;
	}
	public String getProfessionInvestesment() {
		return professionInvestesment;
	}
	public void setProfessionInvestesment(String professionInvestesment) {
		this.professionInvestesment = professionInvestesment;
	}
	public float getAmoutInvestesment() {
		return amoutInvestesment;
	}
	public void setAmoutInvestesment(float amoutInvestesment) {
		this.amoutInvestesment = amoutInvestesment;
	}
	public Fund getFund() {
		return fund;
	}
	public void setFund(Fund fund) {
		this.fund = fund;
	}
	 

}
