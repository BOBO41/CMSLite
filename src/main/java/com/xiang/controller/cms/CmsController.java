package com.xiang.controller.cms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.xiang.bean.vo.BaseListVo;
import com.xiang.bean.vo.CatalogVo;
import com.xiang.bean.vo.ProductVo;
import com.xiang.cms.vo.ArticleVo;
import com.xiang.cms.vo.BannerVo;
import com.xiang.cms.vo.BlockVo;
import com.xiang.cms.vo.CmsNavVo;
import com.xiang.cms.vo.ComProductVo;
import com.xiang.cmsserver.server.ArticleServer;
import com.xiang.cmsserver.server.BannerServer;
import com.xiang.cmsserver.server.BlockServer;
import com.xiang.cmsserver.server.ComProductServer;
import com.xiang.cmsserver.server.NavServer;
import com.xiang.productserver.CatalogServer;
import com.xiang.productserver.ProductServer;
import com.xiang.restserver.Page;

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
	@Resource
	private ArticleServer articleServer;

	private void include(ModelMap map) {
		List<CmsNavVo> navs = navServer.getCmsNavs();
		map.put("navs", navs);
		BlockVo footer = blockServer.get(41787146645798913l);
		map.put("footer", footer.getContent());
	}

	@RequestMapping(value = "/")
	public String index(ModelMap map) {
		include(map);
		List<BannerVo> banners = bannerServer.getList();
		map.put("banners", banners);
		List<ComProductVo> comVos = comProductServer.getList();
		if (!ObjectUtils.isEmpty(comVos)) {
			for (ComProductVo comVo : comVos) {
				comVo.setProducts(comProductServer.getProductList(comVo.getId()));
			}
		}
		map.put("comproducts", comVos);
		BlockVo business = blockServer.get(41803997949984769l);// 业务信息
		map.put("business", business.getContent());

		BlockVo contect = blockServer.get(41788914024841217l);// 联系信息
		map.put("contect", contect.getContent());

		return "index";
	}

	@RequestMapping(value = { "/categories", "/categories/{id}", "/categories/{page}/{limit}/{id}",
			"/categories/{page}/{limit}" })
	public String categories(ModelMap map, @PathVariable(name = "page", required = false) Integer page,
			@PathVariable(name = "limit", required = false) Integer limit,
			@PathVariable(name = "id", required = false) Long id) {
		include(map);
		if (Objects.isNull(page)) {
			page = 1;
		}
		if (Objects.isNull(limit)) {
			limit = 12;
		}
		if (Objects.isNull(id)) {
			id = 0l;
		}
		map.put("id", id);

		List<CatalogVo> catalogs = catalogServer.getCatologTree();
		map.put("catalogs", catalogs);
		Map<String, Object> querys = new HashMap<String, Object>();
		querys.put("andDelEqualTo", false);
		querys.put(Page.PAGE, page);
		querys.put(Page.LIMIT, limit);
		if (!Objects.isNull(id) && id.compareTo(0l) != 0) {
			map.put("currentCatalog", catalogServer.get(id));
			querys.put("andCatalogIdIn", catalogServer.getLeafChilds(id));
		}
		BaseListVo<ProductVo> products = productServer.queryList(querys);
		map.put("productlist", products);
		return "categories";
	}

	@RequestMapping(value = { "/detail/{id}" })
	public String detail(ModelMap map, @PathVariable(name = "id") Long id) {
		include(map);
		map.put("product", productServer.get(id));
		return "detail";
	}

	@RequestMapping(value = { "/about" })
	public String about(ModelMap map) {
		include(map);
		BlockVo content = blockServer.get(43267799040131073l);// 关于我们
		map.put("introContent", content.getContent());
		content = blockServer.get(43268543143215105l);
		map.put("introAbout", content.getContent());
		content = blockServer.get(43268614010175489l);
		map.put("team", content.getContent());
		content = blockServer.get(43268769702739969l);
		map.put("customer", content.getContent());
		return "about";
	}

	@RequestMapping(value = "/search", method = { RequestMethod.POST, RequestMethod.GET })
	public String search(ModelMap map, @RequestParam(name = "word", required = false) String word) {
		map.put(Page.PAGE, 1);
		map.put(Page.LIMIT, 12);
		include(map);
		List<CatalogVo> catalogs = catalogServer.getCatologTree();
		map.put("catalogs", catalogs);
		Map<String, Object> querys = new HashMap<String, Object>();
		querys.put("andDelEqualTo", false);
		if (!StringUtils.isEmpty(word)) {
			querys.put("andNameLike", "%" + word.trim() + "%");
		}
		querys.put(Page.PAGE, 1);
		querys.put(Page.LIMIT, 12);
		BaseListVo<ProductVo> products = productServer.queryList(querys);
		if (!Objects.isNull(products) && !ObjectUtils.isEmpty(products.getResult())) {
			products.setTotal(products.getResult().size());
		}
		map.put("productlist", products);
		return "categories";
	}
	@RequestMapping(value = { "/news", "/news/{page}/{limit}"})
public String categories(ModelMap map, @PathVariable(name = "page", required = false) Integer page,
	@PathVariable(name = "limit", required = false) Integer limit) {
		include(map);
		if (Objects.isNull(page)) {
			page = 1;
		}
		if (Objects.isNull(limit)) {
			limit = 12;
		}
		Map<String, Object> querys = new HashMap<String, Object>();
		querys.put("andDelEqualTo", false);
		querys.put(Page.PAGE, page);
		querys.put(Page.LIMIT, limit);
		querys.put(Page.SORT, "+addTime");
		map.put("articles", articleServer.queryList(querys));
		return "news";
	}
	@RequestMapping(value = { "/article/{id}" })
	public String article(ModelMap map, @PathVariable(name = "id") Long id) {
		include(map);
		ArticleVo vo=articleServer.get(id);
		map.put("article", vo);
		return "article";
	}
}
