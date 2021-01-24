package com.tyandrerboldt.authbase.core.security.authorizationserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tyandrerboldt.authbase.domain.models.User;
import com.tyandrerboldt.authbase.domain.services.UserService;

@Service
public class JpaUserDetailsService implements UserDetailsService{

	@Autowired
	UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.findByEmail(username);
		return new AuthUser(user);
	}

}
