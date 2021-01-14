package com.tyandrerboldt.authbase.domain.exceptions;

public class RuleException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public RuleException(String message) {
		super(message);
	}
	
	public RuleException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
