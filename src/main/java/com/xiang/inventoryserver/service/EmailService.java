package com.xiang.inventoryserver.service;

public interface EmailService {
	public void replyMessage(String email,String content);
	public void noiceMessage(String email,String content);
}
