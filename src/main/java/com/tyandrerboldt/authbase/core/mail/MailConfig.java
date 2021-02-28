package com.tyandrerboldt.authbase.core.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.tyandrerboldt.authbase.domain.services.SendMailService;
import com.tyandrerboldt.authbase.infrasctructure.service.mail.FakeSendMailService;
import com.tyandrerboldt.authbase.infrasctructure.service.mail.SandboxSendMailService;
import com.tyandrerboldt.authbase.infrasctructure.service.mail.SmtpSendMailService;

public class MailConfig {
	@Autowired
	private MailProperties mailProperties;

	@Bean
	public SendMailService envioEmailService() {
		switch (mailProperties.getImpl()) {
			case FAKE:
				return new FakeSendMailService();
			case SMTP:
				return new SmtpSendMailService();
			case SANDBOX:
				return new SandboxSendMailService();
			default:
				return null;
		}
	}
}
