package com.xiang.controller.cms;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xiang.bean.vo.BaseListVo;
import com.xiang.bean.vo.CatalogVo;
import com.xiang.bean.vo.ProductVo;
import com.xiang.cms.vo.BannerVo;
import com.xiang.cms.vo.BlockVo;
import com.xiang.cms.vo.CmsNavVo;
import com.xiang.cms.vo.ComProductVo;
import com.xiang.cmsserver.server.BannerServer;
import com.xiang.cmsserver.server.BlockServer;
import com.xiang.cmsserver.server.ComProductServer;
import com.xiang.cmsserver.server.NavServer;
import com.xiang.productserver.CatalogServer;
import com.xiang.productserver.ProductServer;

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
	@Resource
	private ComProductServer comProductServer;
	@Resource
	private CatalogServer catalogServer;
	@Resource
	private ProductServer productServer;
	@RequestMapping(value = "/")
	public String index(ModelMap map) {
		List<CmsNavVo> navs=navServer.getCmsNavs();
		map.put("navs", navs);
		List<BannerVo> banners=bannerServer.getList();
		map.put("banners", banners);
		List<ComProductVo> comVos=comProductServer.getList();
		if(!ObjectUtils.isEmpty(comVos)) {
			for(ComProductVo comVo:comVos) {
				comVo.setProducts(comProductServer.getProductList(comVo.getId()));
			}
		}
		map.put("comproducts", comVos);
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
		List<CatalogVo> catalogs=catalogServer.getCatologTree();
		map.put("catalogs", catalogs);
		
		BaseListVo<ProductVo> products=productServer.queryList(null);
		map.put("productlist", products);
		BlockVo footer=blockServer.get(41787146645798913l);
		map.put("footer", footer.getContent());
		return "categories";
	}
}
