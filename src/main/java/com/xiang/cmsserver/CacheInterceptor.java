package com.xiang.cmsserver;

import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.xiang.server.HtmlCacheServer;

public class CacheInterceptor extends HandlerInterceptorAdapter{
	@Resource
	HtmlCacheServer htmlCacheServer;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Locale locale = RequestContextUtils.getLocale(request);
		String url=request.getRequestURI();
		Object data=htmlCacheServer.getCache(locale, url);
		if(data!=null) {
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html");
			response.getWriter().write((String)data);
			return false;
		}
		return super.preHandle(request, response, handler);
	}

}
