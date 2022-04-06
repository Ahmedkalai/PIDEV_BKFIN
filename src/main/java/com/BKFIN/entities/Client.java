package com.BKFIN.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity

public class Client implements Serializable,UserDetails {
	
	
    private static final long serialVersionUID = 1L;

	
	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	private Long cin;
	private String name;
	private String secondName;
	@Temporal (TemporalType.DATE)
	private Date birthDay ;
	private Long phoneNum;
	private String email;
	private String image;
	private String adresse;
	private String password;
	//null par defaut / true autorisé/false non autorisé
	private Boolean Credit_authorization;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="client")
	private Set<Credit> credits;
	@ManyToOne
	@JsonIgnore
	private Agent agent;
	@OneToMany( mappedBy="clientAcc")
	private Set<Account> account;
	@OneToMany(mappedBy="clientcomp")
	private Set<Complaint> complaints;
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
			 private Set<Role> roles;
	
	


	
	public Set<Role> getRoles() {
		return roles;
	}


	public void setRoles(Set<Role> roles) {
		
		this.roles = roles;
	}
	public Boolean getCredit_authorization() {
		return Credit_authorization;
	}
	public void setCredit_authorization(Boolean credit_authorization) {
		Credit_authorization = credit_authorization;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Client(Long id, Long cin, String name, String secondName, Date birthDay, Long phoneNum, String email,
			String image, String adresse, String password, Boolean credit_authorization, Set<Credit> credits,
			Agent agent, Set<Account> account, Set<Complaint> complaints, Set<Role> roles) {
		super();
		this.id = id;
		this.cin = cin;
		this.name = name;
		this.secondName = secondName;
		this.birthDay = birthDay;
		this.phoneNum = phoneNum;
		this.email = email;
		this.image = image;
		this.adresse = adresse;
		this.password = password;
		Credit_authorization = credit_authorization;
		this.credits = credits;
		this.agent = agent;
		this.account = account;
		this.complaints = complaints;
		this.roles = roles;
	}
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
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
	public Set<Credit> getCredits() {
		return credits;
	}
	public void setCredits(Set<Credit> credits) {
		this.credits = credits;
	}
	public Agent getAgent() {
		return agent;
	}
	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	public Set<Account> getAccount() {
		return account;
	}
	public void setAccount(Set<Account> account) {
		this.account = account;
	}
	public Set<Complaint> getComplaints() {
		return complaints;
	}
	public void setComplaints(Set<Complaint> complaints) {
		this.complaints = complaints;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	

	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String getPassword() {
		
		return this.password;
	}


	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.email;
	}


	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}


	
	
	
	
	
	
	
	
	

}
