package com.clarence.fightreservation.util;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.clarence.fightreservation.services.ReservationServiceImpl;

@Component
public class EmailUtil {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmailUtil.class);
	
	@Value("${com.clarence.fightreservation.itinerary.email.subject}")
	private String EMAIL_SUBJECT;
	
	@Value("${com.clarence.fightreservation.itinerary.email.body}")
	private String EMAIL_BODY;
	
	@Autowired
	public JavaMailSender sender;

	public void sendItinerary(String toAddress, String filePath) {
		
		LOGGER.info("inside sendItinerary");
		MimeMessage message = sender.createMimeMessage();
		try {
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, true);
			mimeMessageHelper.setTo(toAddress);
			mimeMessageHelper.setSubject(EMAIL_SUBJECT);
			mimeMessageHelper.setText(EMAIL_BODY);
			mimeMessageHelper.addAttachment("Itinerary", new File(filePath));
			sender.send(message);
		} catch (MessagingException e) {
			LOGGER.error("Exception inside sendItinerary =" + e);
		}
	}
}
