package com.tyandrerboldt.authbase.api.v1.models;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserModel {

	@ApiModelProperty(example = "1")
	private Long id;
	
	@ApiModelProperty(example = "João")
	private String firstName;
	
	@ApiModelProperty(example = "Silva")
	private String lastName;

	@ApiModelProperty(example = "joao@email.com.br")
	private String email;
	
}
