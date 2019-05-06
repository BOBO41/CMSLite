package com.xiang.server;

import java.util.HashMap;
import java.util.Locale;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.LocaleUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SystemConfig {
	@Value("${system.locale.default}")
	 private String defaultLocale;
	
	@Value("${system.locale.supports}")
	private String[] supportsLocale;
	
	private HashMap<String, Locale> supportsLocaleCache;
	@PostConstruct
	private void init() {
		supportsLocaleCache=new HashMap<>();
		for(String locale:supportsLocale) {
			supportsLocaleCache.put(locale,LocaleUtils.toLocale(locale));
		}
	}
	public Locale getDefaultLocale() {
		return supportsLocaleCache.get(defaultLocale);
	}
	public boolean isDefaultLocale(String locale) {
		return defaultLocale.equals(locale);
	}
	public boolean isSupport(String locale) {
		return supportsLocaleCache.containsKey(locale);
	}
	public Locale getLocale(String locale) {
		return supportsLocaleCache.get(locale);
	}
	
}
