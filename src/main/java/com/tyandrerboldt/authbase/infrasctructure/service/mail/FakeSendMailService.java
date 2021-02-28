package com.tyandrerboldt.authbase.infrasctructure.service.mail;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FakeSendMailService extends SmtpSendMailService {

	@Override
	public void send(Message message) {
		String body = renderTemplate(message);

		log.info("[FAKE E-MAIL] Para: {}\n{}", message.getReceivers(), body);
	}

}
