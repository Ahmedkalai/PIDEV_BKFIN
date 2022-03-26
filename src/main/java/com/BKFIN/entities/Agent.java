package com.BKFIN.entities;

import java.io.Serializable;
import java.util.Collection;
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

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class Agent  implements Serializable,UserDetails{
	
	
	
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
<<<<<<< Updated upstream
	
=======
	private String password;
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	 private Set<Role> roles;
	private String fullLocation;
	private String IpAddress;
	private Double latitude;
	private Double longitude;
	private Boolean state ; 
	public Boolean getState() {
		return state;
	}
	public void setState(Boolean state) {
		this.state = state;
	}
	public String getIpAddress() {
		return IpAddress;
	}
	public void setIpAddress(String ipAddress) {
		IpAddress = ipAddress;
	}
	public String getFullLocation() {
		return fullLocation;
	}
	public void setFullLocation(String fullLocation) {
		this.fullLocation = fullLocation;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
	public Agent(Long idAgent, Long localisation, String name, String secondName, Long phoneNum, String email,
			String adresse) {
=======
	
	public Set<Client> getClient() {
		return client;
	}
	public void setClient(Set<Client> client) {
		this.client = client;
	}
	public Set<Event> getEvent() {
		return event;
	}
	public void setEvent(Set<Event> event) {
		this.event = event;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	

	
	public Agent(Long idAgent, Long localisation, String name, String secondName, Long phoneNum, String email,
			String adresse, String password, Set<Role> roles, String fullLocation, String ipAddress, Double latitude,
			Double longitude, Boolean state, Set<Client> client, Set<Event> event, Admin admin) {
>>>>>>> Stashed changes
		super();
		this.idAgent = idAgent;
		this.localisation = localisation;
		this.name = name;
		this.secondName = secondName;
		this.phoneNum = phoneNum;
		this.email = email;
		this.adresse = adresse;
<<<<<<< Updated upstream
	}
	
	
	
	
	
	
	
	
	
	
	
	
=======
		this.password = password;
		this.roles = roles;
		this.fullLocation = fullLocation;
		IpAddress = ipAddress;
		this.latitude = latitude;
		this.longitude = longitude;
		this.state = state;
		this.client = client;
		this.event = event;
		this.admin = admin;
	}
	public Agent() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String getPassword() {
		
		return this.password;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
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
>>>>>>> Stashed changes
	
	
	

}
