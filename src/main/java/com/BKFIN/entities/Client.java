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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity

public class Client implements Serializable {
	
	
	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="cin")
	private Long cin;
	private String name;
	private String secondName;
	@Temporal (TemporalType.DATE)
	private Date birthDay ;
	private Long phoneNum;
	private String email;
	private String image;
	private String adresse;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="client")
	private Set<Credit> credits;
	
	@ManyToOne
	private Agent agent;
	
	@OneToMany( mappedBy="clientAcc")
	private Set<Account> account;

	
	@OneToMany(mappedBy="clientcomp")
	private Set<Complaint> complaints;
	
	public Long getCin() {
		return cin;
	}
	public void setCin(Long cin) {
		this.cin = cin;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSecondName() {
		return secondName;
	}
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	public Long getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(Long phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public Client(Long cin, String name, String secondName, Date birthDay, Long phoneNum, String email, String image,
			String adresse) {
		super();
		this.cin = cin;
		this.name = name;
		this.secondName = secondName;
		this.birthDay = birthDay;
		this.phoneNum = phoneNum;
		this.email = email;
		this.image = image;
		this.adresse = adresse;
		
	}
	
	
	
	
	
	
	
	

}
