package com.xiang.inventoryserver.service.impl;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

import com.xiang.bean.po.Message;
import com.xiang.inventoryserver.service.EmailService;
@EnableAsync
public class EmailServiceImpl implements EmailService{

	@Async
	@Override
	public void replyMessage(Message po) {
		
	}

}
