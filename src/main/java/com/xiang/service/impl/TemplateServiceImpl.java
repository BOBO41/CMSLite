package com.xiang.service.impl;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.xiang.service.TemplateService;

import freemarker.template.Template;

@Service("templateService")
public class TemplateServiceImpl implements TemplateService {
	@Autowired
	private FreeMarkerConfigurer freeMarkerConfigurer;

	@Override
	public String getTemplate(String name, Map<String, Object> dataModel) {
		String html = null;
		StringWriter writer = null;
		try {
			Template template = freeMarkerConfigurer.getConfiguration().getTemplate(name);
			writer = new StringWriter();
			template.process(dataModel, writer);
			html = writer.toString();
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
		return html;
	}

}
