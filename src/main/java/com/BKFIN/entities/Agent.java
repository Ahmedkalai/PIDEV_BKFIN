package com.BKFIN.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
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
	private String password;
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	 private Set<Role> roles;
	private String fullLocation;
	private String IpAddress;
	private Double latitude;
	private Double longitude;
	private String performance;
	private String potentiel;
	private ClassEnum classification ;
	private Boolean state ; 
	
	
	


	public Agent(Long idAgent, Long localisation, String name, String secondName, Long phoneNum, String email,
			String adresse, String password, Set<Role> roles, String fullLocation, String ipAddress, Double latitude,
			Double longitude, String performance, String potentiel, ClassEnum classification, Boolean state,
			Set<Client> client, Set<Event> event, Admin admin) {
		super();
		this.idAgent = idAgent;
		this.localisation = localisation;
		this.name = name;
		this.secondName = secondName;
		this.phoneNum = phoneNum;
		this.email = email;
		this.adresse = adresse;
		this.password = password;
		this.roles = roles;
		this.fullLocation = fullLocation;
		IpAddress = ipAddress;
		this.latitude = latitude;
		this.longitude = longitude;
		this.performance = performance;
		this.potentiel = potentiel;
		this.classification = classification;
		this.state = state;
		this.client = client;
		this.event = event;
		this.admin = admin;
	}

	public ClassEnum getClassification() {
		return classification;
	}

	public void setClassification(ClassEnum classification) {
		this.classification = classification;
	}

	@Override
	public int hashCode() {
		return Objects.hash(IpAddress, admin, adresse, classification, client, email, event, fullLocation, idAgent,
				latitude, localisation, longitude, name, password, performance, phoneNum, potentiel, roles, secondName,
				state);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agent other = (Agent) obj;
		return Objects.equals(IpAddress, other.IpAddress) && Objects.equals(admin, other.admin)
				&& Objects.equals(adresse, other.adresse) && classification == other.classification
				&& Objects.equals(client, other.client) && Objects.equals(email, other.email)
				&& Objects.equals(event, other.event) && Objects.equals(fullLocation, other.fullLocation)
				&& Objects.equals(idAgent, other.idAgent) && Objects.equals(latitude, other.latitude)
				&& Objects.equals(localisation, other.localisation) && Objects.equals(longitude, other.longitude)
				&& Objects.equals(name, other.name) && Objects.equals(password, other.password)
				&& Objects.equals(performance, other.performance) && Objects.equals(phoneNum, other.phoneNum)
				&& Objects.equals(potentiel, other.potentiel) && Objects.equals(roles, other.roles)
				&& Objects.equals(secondName, other.secondName) && Objects.equals(state, other.state);
	}

	@Override
	public String toString() {
		return "Agent [idAgent=" + idAgent + ", localisation=" + localisation + ", name=" + name + ", secondName="
				+ secondName + ", phoneNum=" + phoneNum + ", email=" + email + ", adresse=" + adresse + ", password="
				+ password + ", roles=" + roles + ", fullLocation=" + fullLocation + ", IpAddress=" + IpAddress
				+ ", latitude=" + latitude + ", longitude=" + longitude + ", performance=" + performance
				+ ", potentiel=" + potentiel + ", classification=" + classification + ", state=" + state + ", client="
				+ client + ", event=" + event + ", admin=" + admin + "]";
	}

	
	public String getPerformance() {
		return performance;
	}
	public void setPerformance(String performance) {
		this.performance = performance;
	}
	public String getPotentiel() {
		return potentiel;
	}
	public void setPotentiel(String potentiel) {
		this.potentiel = potentiel;
	}
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
			Double longitude, String performance, String potentiel, Boolean state, Set<Client> client,
			Set<Event> event, Admin admin) {
		super();
		this.idAgent = idAgent;
		this.localisation = localisation;
		this.name = name;
		this.secondName = secondName;
		this.phoneNum = phoneNum;
		this.email = email;
		this.adresse = adresse;
		this.password = password;
		this.roles = roles;
		this.fullLocation = fullLocation;
		IpAddress = ipAddress;
		this.latitude = latitude;
		this.longitude = longitude;
		this.performance = performance;
		this.potentiel = potentiel;
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
	
	
	

}
