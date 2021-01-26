package com.tyandrerboldt.authbase.core.security.authorizationserver;

import java.util.Collections;

import org.springframework.security.core.userdetails.User;

import lombok.Getter;

@Getter
public class AuthUser extends User{
	
	private static final long serialVersionUID = 1L;
	
	private Long userId;
	private String fullName;
	
	public AuthUser(com.tyandrerboldt.authbase.domain.models.User user) {
		super(user.getEmail(), user.getPassword(), Collections.emptyList());
		
		this.userId = user.getId();
		this.fullName = user.getFirstName() + " " + user.getLastName();
	}
	
}
