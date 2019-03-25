package com.xiang.controller.cms;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xiang.bean.vo.BannerVo;
import com.xiang.cms.vo.CmsNavVo;
import com.xiang.cmsserver.server.BannerServer;
import com.xiang.cmsserver.server.NavServer;

/**
 * @author xiang
 *
 */
@Controller
public class CmsController {
	@Resource
	private NavServer navServer;
	@Resource
	private BannerServer bannerServer;
	@RequestMapping(value = "/")
	public String index(ModelMap map) {
		List<CmsNavVo> navs=navServer.getCmsNavs();
		map.put("navs", navs);
		List<BannerVo> banners=bannerServer.getList();
		map.put("banners", banners);
		return "index";
	}
}
