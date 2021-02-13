package com.tyandrerboldt.authbase.api.v1.models.dtos;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserWithPasswordInputDTO extends UserInputDTO{

	@ApiModelProperty(example = "123", required = true)
	@NotBlank
	private String password;
	
}
