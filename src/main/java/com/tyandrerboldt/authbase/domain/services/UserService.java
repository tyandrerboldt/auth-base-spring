package com.tyandrerboldt.authbase.domain.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyandrerboldt.authbase.domain.exceptions.RuleException;
import com.tyandrerboldt.authbase.domain.models.User;
import com.tyandrerboldt.authbase.domain.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Transactional
	public User save(User user) {
		Optional<User> existingUser = userRepository.findByEmail(user.getEmail());

		if(existingUser.isPresent() && !existingUser.get().equals(user)) {
			throw new RuleException(String.format("Já existe um usuário cadastrado com o e-mail %s", user.getEmail()));
		}
		
		if(user.isNew()) {
			//encriptar senha
		}

		return userRepository.save(user);
	}

}
