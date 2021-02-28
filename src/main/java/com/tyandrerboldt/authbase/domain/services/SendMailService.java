package com.tyandrerboldt.authbase.domain.services;

import java.util.Map;
import java.util.Set;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Singular;

public interface SendMailService {

	void send(Message message);
	
	@Getter
	@Builder
	class Message {
		
		@Singular
		private Set<String> receivers;
		
		@NonNull
		private String subject;
		
		@NonNull
		private String body;
		
		@Singular("variable")
		private Map<String, Object> variables;
		
	}
	
}