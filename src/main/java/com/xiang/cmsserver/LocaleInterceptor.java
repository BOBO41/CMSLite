package com.xiang.cmsserver;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.xiang.server.SystemConfig;

public class LocaleInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	SystemConfig systemConfig;
	public final static String LANGUAGEPARAM = "lang";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
		String lang = request.getHeader(LANGUAGEPARAM);
		if(ObjectUtils.isEmpty(lang)) {
			lang = request.getParameter(LANGUAGEPARAM);
		}
		if (!ObjectUtils.isEmpty(lang) && systemConfig.isSupport(lang)) {
			if (localeResolver != null) {
				localeResolver.setLocale(request, response, systemConfig.getLocale(lang));
			}
		} else {
			Locale locale = RequestContextUtils.getLocale(request);
			if (locale == null || !systemConfig.isSupport(locale.toString())) {
				localeResolver.setLocale(request, response, systemConfig.getDefaultLocale());
			}
		}
		return super.preHandle(request, response, handler);
	}
}
