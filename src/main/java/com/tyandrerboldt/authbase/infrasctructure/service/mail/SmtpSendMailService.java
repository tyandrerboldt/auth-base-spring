package com.tyandrerboldt.authbase.infrasctructure.service.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.tyandrerboldt.authbase.core.mail.MailProperties;
import com.tyandrerboldt.authbase.domain.services.SendMailService;

import freemarker.template.Configuration;
import freemarker.template.Template;

@Service
public class SmtpSendMailService implements SendMailService {

	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private MailProperties mailProperties;
	
	@Autowired
	private Configuration freemarkerConfig;
	
	@Override
	public void send(Message message) {
		try {
			MimeMessage mimeMessage = createMimeMessage(message);
			
			mailSender.send(mimeMessage);
		} catch (Exception e) {
			throw new EmailException("Não foi possível enviar e-mail", e);
		}
	}
	
	protected MimeMessage createMimeMessage(Message message) throws MessagingException {
		String body = renderTemplate(message);
		
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "UTF-8");
		helper.setFrom(mailProperties.getSender());
		helper.setTo(message.getReceivers().toArray(new String[0]));
		helper.setSubject(message.getSubject());
		helper.setText(body, true);
		
		return mimeMessage;
	}
	
	protected String renderTemplate(Message message) {
		try {
			Template template = freemarkerConfig.getTemplate(message.getBody());
			
			return FreeMarkerTemplateUtils.processTemplateIntoString(
					template, message.getVariables());
		} catch (Exception e) {
			throw new EmailException("Não foi possível montar o template do e-mail", e);
		}
	}

}
