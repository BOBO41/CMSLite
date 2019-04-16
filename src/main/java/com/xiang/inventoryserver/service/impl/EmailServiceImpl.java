package com.xiang.inventoryserver.service.impl;

import org.simplejavamail.email.Email;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.Mailer;
import org.simplejavamail.springsupport.SimpleJavaMailSpringSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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
	@Cacheable(value = "replyMessageCache", key = "#email")//防止恶意攻击，同一个邮箱1分钟只能发一次
	public void replyMessage(String email,String content) {
			sendMessage("CCHCCH Notification",email,  content);
	}
	@Async
	@Override
	public void noiceMessage(String email, String content) {
		sendMessage("CCHCCH有新的留言",email,  content);
	}
	private void sendMessage(String title,String content,String to) {
		try {
			Email emailBuilder = EmailBuilder.startingBlank().to(to).withSubject(title).withHTMLText(content).buildEmail();
			mailer.sendMail(emailBuilder);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
