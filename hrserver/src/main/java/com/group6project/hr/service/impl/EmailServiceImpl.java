package com.group6project.hr.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl implements EmailService{
	
	@Autowired
    private JavaMailSender emailSender;
	
	@Override
	public void sendEmail(String to, String subject, String text) {
	    
	    
	    
		 SimpleMailMessage message = new SimpleMailMessage(); 
		  message.setFrom("wsjinniu@gmail.com");
		  message.setTo(to);
		  
		  message.setSubject(subject); 
		  message.setText(text);
	      emailSender.send(message);
		 
	}

}
