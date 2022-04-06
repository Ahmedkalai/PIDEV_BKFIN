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

@Entity
public class Admin implements Serializable,UserDetails {
	//ajouter le role admin
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
	private String password;
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	 private Set<Role> roles;
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
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
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
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Admin(long idAdmin, String name, String secondName, Date birthDay, Long phoneNum, String email,
			String password, Set<Role> roles, Set<Agent> agent) {
		super();
		this.idAdmin = idAdmin;
		this.name = name;
		this.secondName = secondName;
		this.birthDay = birthDay;
		this.phoneNum = phoneNum;
		this.email = email;
		this.password = password;
		this.roles = roles;
		this.agent = agent;
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
