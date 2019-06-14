package com.tyss.app.controller;

import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tyss.app.model.Email;

@Controller
@RequestMapping("/controller")
public class EmailController {

	@RequestMapping("/")
	public String welcome(Map<String, Object> map) {
		map.put("email", new Email());
		return "email";
	}

	@RequestMapping("/validate")
	public String validate(@ModelAttribute("email") Email email) {

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		// get Session
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(email.getFrom(), email.getPassword());
			}
		});
		// compose message
		try {
			MimeMessage message = new MimeMessage(session);
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(email.getTo()));
			message.setSubject(email.getSubject());
			message.setText(email.getBody());
			// send message
			Transport.send(message);
			System.out.println("email sent successfully");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		return "success";
	}
}
