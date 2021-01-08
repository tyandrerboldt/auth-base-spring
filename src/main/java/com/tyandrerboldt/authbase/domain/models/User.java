package com.tyandrerboldt.authbase.domain.models;

import java.time.OffsetDateTime;

public class User {

	private Long id;
	
	private String name;
	
	private String email;
	
	private String password;
	
	private OffsetDateTime createdAt;
	
	private OffsetDateTime updatedAt;
}
