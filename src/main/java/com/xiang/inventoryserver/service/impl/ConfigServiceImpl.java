package com.xiang.inventoryserver.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.xiang.inventoryserver.service.ConfigService;

@Service("configService")
public class ConfigServiceImpl implements ConfigService{
	@Value("${mail.noice.address:#{null}}")
	private String mailNoiceAddress;

	public String getMailNoiceAddress() {
		return mailNoiceAddress;
	}
}
