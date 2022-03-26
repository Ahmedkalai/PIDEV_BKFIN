package com.BKFIN.entities;

import org.springframework.security.core.GrantedAuthority;

public enum RoleName  implements GrantedAuthority{
	ADMIN,
	CLIENT,
	AGENT;
	 @Override
	 public String getAuthority() {
	 return "ROLE_" + name();
	 }
}
