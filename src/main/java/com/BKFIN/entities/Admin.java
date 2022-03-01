package com.BKFIN.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

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
public class Admin implements Serializable {
	
	@Id
	 @Column(name ="idAdmin")
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private long idAdmin ; 
	private String name;
	private String secondName;
	@Temporal (TemporalType.DATE)
	private Date birthDay ;
	private Long phoneNum;
	private String email;
	@OneToMany( mappedBy="admin")
	private Set<Agent> agent;
	public long getIdAdmin() {
		return idAdmin;
	}
	public void setIdAdmin(long idAdmin) {
		this.idAdmin = idAdmin;
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
	public Set<Agent> getAgent() {
		return agent;
	}
	public void setAgent(Set<Agent> agent) {
		this.agent = agent;
	}
	
	
}
