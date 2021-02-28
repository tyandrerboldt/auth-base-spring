package com.tyandrerboldt.authbase.infrasctructure.service.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.tyandrerboldt.authbase.core.mail.MailProperties;

public class SandboxSendMailService extends SmtpSendMailService {

	@Autowired
	private MailProperties mailProperties;
	
	@Override
	protected MimeMessage createMimeMessage(Message message) throws MessagingException {
		MimeMessage mimeMessage = super.createMimeMessage(message);
		
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "UTF-8");
		helper.setTo(mailProperties.getSandbox().getReceiver());
		
		return mimeMessage;
	}

}
