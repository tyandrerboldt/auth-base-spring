package com.tyandrerboldt.authbase.api.v1.mappers.disassemblers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tyandrerboldt.authbase.api.v1.models.dtos.UserInputDTO;
import com.tyandrerboldt.authbase.domain.models.User;

@Component
public class UserInputDTODisassembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public User toDomainObject(UserInputDTO userInputDTO) {
		return modelMapper.map(userInputDTO, User.class);
	}
	
	public void copyToDomainObject(UserInputDTO userInputDTO, User user) {
		modelMapper.map(userInputDTO, user);
	}
}
