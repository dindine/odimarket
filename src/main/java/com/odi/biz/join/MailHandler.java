package com.odi.biz.join;

import java.io.UnsupportedEncodingException;

import javax.activation.DataSource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class MailHandler {
	
	private JavaMailSender mailSender;
	private MimeMessage message;
	private MimeMessageHelper messageHelper;
	
	public MailHandler(JavaMailSender mailSender) throws MessagingException {
		this.mailSender = mailSender;
		message = this.mailSender.createMimeMessage();
		messageHelper = new MimeMessageHelper(message, true, "UTF-8");
	}
	
	public void setSubject(String subject) throws MessagingException {
		messageHelper.setSubject(subject);
	}
	
	public void setText(String htmlContent) throws MessagingException {
		messageHelper.setText(htmlContent, true);
	}
	
	public void setFrom(String cust_email, String cust_nickname) throws UnsupportedEncodingException, MessagingException {
		messageHelper.setFrom(cust_email, cust_nickname);
	}
	
	public void setTo(String cust_email) throws MessagingException {
		messageHelper.setTo(cust_email);
	}
	
	public void addInline(String contentId, DataSource dataSource) throws MessagingException {
		messageHelper.addInline(contentId, dataSource);
	}
	
	public void send() {
		mailSender.send(message);
	}
	
	
	
	

}
