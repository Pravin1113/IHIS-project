package com.pravin.util;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

@Service
public class EmailUtil {
	
	@Autowired(required=true)
	private JavaMailSender mailSender;
	
	public boolean sendEamil(String to,String subject,String Body, File file) {
		boolean isSent=false;
		try {
			MimeMessage mimeMessage=mailSender.createMimeMessage();
			MimeMessageHelper helper=new MimeMessageHelper(mimeMessage, true);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(Body, true);
			
			helper.addAttachment(file.getName(), file);
			mailSender.send(mimeMessage);
			isSent=true;
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return isSent;
	}

}
