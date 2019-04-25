package com.xiang.cmsserver;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;

import com.xiang.cmsserver.server.CacheServer;
import com.xiang.restserver.SpringContextHolder;

import freemarker.template.SimpleHash;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class CacheFreeMarkerView extends FreeMarkerView{
	protected void processTemplate(Template template, SimpleHash model, HttpServletResponse response)
			throws IOException, TemplateException {
		StringWriter writer = null;
		try {
			writer = new StringWriter();
			template.process(model, writer);
			String data = writer.toString();
			response.getWriter().write(data);
			ServletRequestAttributes requestAttrs = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
			if(requestAttrs!=null) {
				HttpServletRequest request=requestAttrs.getRequest();
				Locale locale = RequestContextUtils.getLocale(request);
				CacheServer cacheServer=SpringContextHolder.applicationContext.getBean(CacheServer.class);
				cacheServer.setCache(locale,request.getRequestURI(), data);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
}
