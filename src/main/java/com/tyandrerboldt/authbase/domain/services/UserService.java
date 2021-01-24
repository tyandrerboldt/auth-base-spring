package com.tyandrerboldt.authbase.domain.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tyandrerboldt.authbase.domain.exceptions.RuleException;
import com.tyandrerboldt.authbase.domain.models.User;
import com.tyandrerboldt.authbase.domain.repositories.UserRepository;

@Service
public class UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public User findByEmail(String email) throws UsernameNotFoundException {
		
		User existingUser = userRepository.findByEmail(email)
				.orElseThrow(() -> new RuntimeException("Usuario nao encontrado"));
		
		return existingUser;
	}

	@Transactional
	public User save(User user) {
		Optional<User> existingUser = userRepository.findByEmail(user.getEmail());

		if(existingUser.isPresent() && !existingUser.get().equals(user)) {
			throw new RuleException(String.format("Já existe um usuário cadastrado com o e-mail %s", user.getEmail()));
		}
		
		if(user.isNew()) {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
		}

		return userRepository.save(user);
	}
	
	@Transactional
	public void changePassword(Long userId, String password, String newPassword) {
	    User user = findOrFail(userId);
	    
	    if (!passwordEncoder.matches(password, user.getPassword())) {
	        throw new RuleException("Senha atual informada não coincide com a senha do usuário.");
	    }
	    
	    user.setPassword(passwordEncoder.encode(newPassword));
	}
	
	public User findOrFail(Long userId) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new EntityNotFoundException("Usuário com id: " + userId + " não encontrado!"));
		return user;
	}

}
