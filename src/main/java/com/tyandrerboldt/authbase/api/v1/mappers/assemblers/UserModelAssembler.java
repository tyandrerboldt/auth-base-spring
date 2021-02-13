package com.tyandrerboldt.authbase.api.v1.mappers.assemblers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tyandrerboldt.authbase.api.v1.models.UserModel;
import com.tyandrerboldt.authbase.domain.models.User;

@Component
public class UserModelAssembler {
	
	@Autowired
	ModelMapper modelMapper;
	
	public UserModel toModel(User user) {
		UserModel userModel = modelMapper.map(user, UserModel.class);
		return userModel;
	}

}
