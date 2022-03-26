package com.BKFIN.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Role implements Serializable {

@Id
 @GeneratedValue(strategy =GenerationType.AUTO)
private int id;

private RoleName role;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public RoleName getRole() {
	return role;
}

public void setRole(RoleName role) {
	this.role = role;
}

public Role(int id, RoleName role) {
	super();
	this.id = id;
	this.role = role;
}

public Role() {
	super();
	// TODO Auto-generated constructor stub
}

}