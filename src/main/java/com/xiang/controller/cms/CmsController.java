package com.xiang.controller.cms;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xiang
 *
 */
@Controller
public class CmsController {
	@RequestMapping(value = "/")
	public String index(ModelMap map) {
		return "index";
	}
}
