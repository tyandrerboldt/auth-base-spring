package com.tyandrerboldt.authbase.infrasctructure.service.mail;

public class EmailException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmailException(String message, Throwable cause) {
		super(message, cause);
	}

	public EmailException(String message) {
		super(message);
	}

}
