package com.xiang.controller.report;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author xiang
 *
 */
@CrossOrigin
@Controller
@RequestMapping(value = "/report")
public class ReportController {
	@RequestMapping(value = "/test")
	public ModelAndView test() {
		System.out.println("test");
		 Map<String, String> model = new HashMap<String, String>();  
		 model.put("format", "pdf");
		 return new ModelAndView("testReport", model); 
	}
	@RequestMapping(value = "/testjsp")
	public ModelAndView testjsp() {
		System.out.println("testjsp");
		 Map<String, String> model = new HashMap<String, String>();  
		 model.put("format", "pdf");
		 return new ModelAndView("test", model); 
	}
}
