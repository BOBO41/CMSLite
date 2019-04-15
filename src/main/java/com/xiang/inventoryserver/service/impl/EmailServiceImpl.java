package com.xiang.inventoryserver.service.impl;

import org.simplejavamail.email.Email;

import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.Mailer;
import org.simplejavamail.springsupport.SimpleJavaMailSpringSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import com.xiang.inventoryserver.service.EmailService;
@Service("emailService")
@EnableAsync
@Import(SimpleJavaMailSpringSupport.class)
public class EmailServiceImpl implements EmailService{
	@Autowired
    private Mailer mailer;
	@Async
	@Override
	public void replyMessage(String email,String content) {
		Email emailBuilder = EmailBuilder.startingBlank().to(email).withSubject("test").withHTMLText(content).buildEmail();
		mailer.sendMail(emailBuilder);
	}

}
