package com.xiang.cmsserver;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * @author xiang
 * @createDate 2018年10月19日 上午10:41:01
 */
@ControllerAdvice("com.xiang.controller.cms")
public class CmsResponseAdvice {
	@ModelAttribute(value = "default_keywords")
	  public String globalDefaultKeywordsAttribute() {
	    return "Door Handles, Hinges, Locks, Hooks, Closers, Cabinet Feet, Handle, Cabinet Fittings, Hardware Fittings";
	  }
	@ModelAttribute(value = "default_description")
	  public String globalDefaultDescriptionAttribute() {
	    return " CCH is a professional manufacturer of cabinet feet, handle, cabinet fittings and hardware fittings.";
	  }
	@ModelAttribute(value = "default_title")
	  public String globalDefaultTitleAttribute() {
	    return "CCH - China Connection Hardware";
	  }
}
