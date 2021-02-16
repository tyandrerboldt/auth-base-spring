package com.tyandrerboldt.authbase.api.v1.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tyandrerboldt.authbase.api.v1.mappers.assemblers.UserModelAssembler;
import com.tyandrerboldt.authbase.api.v1.mappers.disassemblers.UserInputDTODisassembler;
import com.tyandrerboldt.authbase.api.v1.models.UserModel;
import com.tyandrerboldt.authbase.api.v1.models.dtos.UserWithPasswordInputDTO;
import com.tyandrerboldt.authbase.domain.models.User;
import com.tyandrerboldt.authbase.domain.services.UserService;

@RestController
@RequestMapping("users")
public class UserController {

	@Autowired
	UserInputDTODisassembler userInputDTODisassembler;
	
	@Autowired
	UserModelAssembler userModelAssembler;
	
	@Autowired
	UserService userService;
	
	@PostMapping
	@PreAuthorize("hasAuthority('SCOPE_WRITE') and hasAuthority('CREATE_USER')")
	@ResponseStatus(HttpStatus.CREATED)
	public UserModel add(@RequestBody @Valid UserWithPasswordInputDTO userInput) {
		User user = userInputDTODisassembler.toDomainObject(userInput);
		user = userService.save(user);
		
		return userModelAssembler.toModel(user);
	}
	
	@PostMapping("/userId")
	@PreAuthorize("hasAuthority('SCOPE_WRITE') and "
			+ "(hasAuthority('UPDATE_USER') or (@securityUtils.itsYourProfile(#userId)))")
	public UserModel save(@PathVariable Long userId,
			@RequestBody @Valid UserWithPasswordInputDTO userInput) {
		return null;
	}
	
	@GetMapping("/verify")
	public void verifyAuth() {
		System.out.println(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
	}
	
}
