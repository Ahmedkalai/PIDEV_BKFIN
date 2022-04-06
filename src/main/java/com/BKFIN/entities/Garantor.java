package com.BKFIN.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Garantor implements Serializable {
	
	@Id
	 @Column(name ="idGarantor")
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private long idGarantor ; 
	 private String nameGarantor ;
	 private String secondnameGarantor ;
	 private float salaryGarantor ;
	 private String workGarantor ;
	 @OneToOne
	 private Credit credit;
	public long getIdGarantor() {
		return idGarantor;
	}
	public void setIdGarantor(long idGarantor) {
		this.idGarantor = idGarantor;
	}
	public String getNameGarantor() {
		return nameGarantor;
	}
	public void setNameGarantor(String nameGarantor) {
		this.nameGarantor = nameGarantor;
	}
	public String getSecondnameGarantor() {
		return secondnameGarantor;
	}
	public void setSecondnameGarantor(String secondnameGarantor) {
		this.secondnameGarantor = secondnameGarantor;
	}
	public float getSalaryGarantor() {
		return salaryGarantor;
	}
	public void setSalaryGarantor(float salaryGarantor) {
		this.salaryGarantor = salaryGarantor;
	}
	public String getWorkGarantor() {
		return workGarantor;
	}
	public void setWorkGarantor(String workGarantor) {
		this.workGarantor = workGarantor;
	}
	public Credit getCredit() {
		return credit;
	}
	public void setCredit(Credit credit) {
		this.credit = credit;
	}
	 
}
