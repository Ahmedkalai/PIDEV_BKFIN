package com.BKFIN.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Event implements Serializable {

	@Id
	 @Column(name ="idEvent")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private long idEvent ;
	 private String nameEvent ;
	 @Temporal (TemporalType.DATE)
	 private Date dateEvent ;
	 private String region ;
	 private String description ;
	@ManyToMany()
	private Set<Agent> agenT;
	public long getIdEvent() {
		return idEvent;
	}
	public void setIdEvent(long idEvent) {
		this.idEvent = idEvent;
	}
	public String getNameEvent() {
		return nameEvent;
	}
	public void setNameEvent(String nameEvent) {
		this.nameEvent = nameEvent;
	}
	public Date getDateEvent() {
		return dateEvent;
	}
	public void setDateEvent(Date dateEvent) {
		this.dateEvent = dateEvent;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Set<Agent> getAgenT() {
		return agenT;
	}
	public void setAgenT(Set<Agent> agenT) {
		this.agenT = agenT;
	}
	
	
}
