package com.tyandrerboldt.authbase.core.security.authorizationserver;

import java.util.Collections;

import org.springframework.security.core.userdetails.User;

class DomainUser extends com.tyandrerboldt.authbase.domain.models.User {
	public DomainUser(DomainUser user) {super();}
};

public class AuthUser extends User{
	
	private static final long serialVersionUID = 1L;
	
	private String fullName;
	
	public AuthUser(DomainUser user) {
		super(user.getEmail(), user.getPassword(), Collections.emptyList());
		
		this.fullName = user.getFirstName() + " " + user.getLastName();
	}
	
}
