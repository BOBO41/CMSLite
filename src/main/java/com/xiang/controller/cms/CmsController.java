package com.xiang.controller.cms;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xiang.cms.vo.BannerVo;
import com.xiang.cms.vo.BlockVo;
import com.xiang.cms.vo.CmsNavVo;
import com.xiang.cmsserver.server.BannerServer;
import com.xiang.cmsserver.server.BlockServer;
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
	@Resource
	private BlockServer blockServer;
	@RequestMapping(value = "/")
	public String index(ModelMap map) {
		List<CmsNavVo> navs=navServer.getCmsNavs();
		map.put("navs", navs);
		List<BannerVo> banners=bannerServer.getList();
		map.put("banners", banners);
		
		BlockVo business=blockServer.get(41803997949984769l);//业务信息
		map.put("business", business.getContent());
		
		BlockVo contect=blockServer.get(41788914024841217l);//联系信息
		map.put("contect", contect.getContent());
		
		BlockVo footer=blockServer.get(41787146645798913l);
		map.put("footer", footer.getContent());
		return "index";
	}
	@RequestMapping(value = "/categories")
	public String categories(ModelMap map) {
		List<CmsNavVo> navs=navServer.getCmsNavs();
		map.put("navs", navs);
		List<BannerVo> banners=bannerServer.getList();
		map.put("banners", banners);
		
		BlockVo business=blockServer.get(41803997949984769l);//业务信息
		map.put("business", business.getContent());
		
		BlockVo contect=blockServer.get(41788914024841217l);//联系信息
		map.put("contect", contect.getContent());
		
		BlockVo footer=blockServer.get(41787146645798913l);
		map.put("footer", footer.getContent());
		return "index";
	}
}
