package com.tyandrerboldt.authbase.api.v1.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
	@ResponseStatus(HttpStatus.CREATED)
	public UserModel add(@RequestBody @Valid UserWithPasswordInputDTO userInput) {
		User user = userInputDTODisassembler.toDomainObject(userInput);
		user = userService.save(user);
		
		return userModelAssembler.toModel(user);
	}
	
}
