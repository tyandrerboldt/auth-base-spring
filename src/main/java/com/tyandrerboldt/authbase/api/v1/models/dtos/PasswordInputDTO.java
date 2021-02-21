package com.tyandrerboldt.authbase.api.v1.models.dtos;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PasswordInputDTO {

	@NotBlank
	String password;

	@NotBlank
	String passwordConfirm;

}
