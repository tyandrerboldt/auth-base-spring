package com.tyandrerboldt.authbase.core.mail;

import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import lombok.Getter;
import lombok.Setter;

@Validated
@Getter
@Setter
@Component
@ConfigurationProperties("authbase.mail")
public class MailProperties {

	private Implementation impl = Implementation.FAKE;
	
	@NotNull
	private String sender;
	
	private Sandbox sandbox = new Sandbox();
	
	public enum Implementation {
		SMTP, FAKE, SANDBOX
	}
	
	@Getter
	@Setter
	public class Sandbox {
		
		private String receiver;
		
	}
	
}