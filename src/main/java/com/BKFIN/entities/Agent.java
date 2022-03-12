package com.BKFIN.entities;

import java.io.Serializable;
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

@Entity

public class Agent  implements Serializable{
	
	
	
	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idAgent")
	private Long idAgent;
	private Long localisation;
	private String name;
	private String secondName;
	private Long phoneNum;
	private String email;
	private String adresse;
	
	@OneToMany( mappedBy="agent")
	private Set<Client> client;
	@ManyToMany(mappedBy="agenT")
	private Set<Event> event;
	@ManyToOne
	private Admin admin;
	
	public Long getIdAgent() {
		return idAgent;
	}
	public void setIdAgent(Long idAgent) {
		this.idAgent = idAgent;
	}
	public Long getLocalisation() {
		return localisation;
	}
	public void setLocalisation(Long localisation) {
		this.localisation = localisation;
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
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public Agent(Long idAgent, Long localisation, String name, String secondName, Long phoneNum, String email,
			String adresse) {
		super();
		this.idAgent = idAgent;
		this.localisation = localisation;
		this.name = name;
		this.secondName = secondName;
		this.phoneNum = phoneNum;
		this.email = email;
		this.adresse = adresse;
	}
	public Agent() {
		super();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
