package com.xiang.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.xiang.service.ConfigService;

@Service("configService")
public class ConfigServiceImpl implements ConfigService{
	@Value("${mail.noice.address:#{null}}")
	private String mailNoiceAddress;

	public String getMailNoiceAddress() {
		return mailNoiceAddress;
	}
}
