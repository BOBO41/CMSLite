package com.xiang.productserver.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import com.robert.vesta.service.intf.IdService;
import com.xiang.bean.bo.ProductBo;
import com.xiang.bean.po.Product;
import com.xiang.bean.po.ProductEx;
import com.xiang.bean.vo.BaseListVo;
import com.xiang.bean.vo.ProductVo;
import com.xiang.productserver.ProductServer;
import com.xiang.productservice.CatalogService;
import com.xiang.productservice.ProductService;
import com.xiang.restserver.Page;
import com.xiang.server.SystemConfig;
import com.xiang.server.impl.BaseServerImpl;
import com.xiang.service.TranslateService;

/**
 * @author xiang
 * @createDate 2018年12月20日 下午2:18:51
 */
@Service("productServer")
public class ProductServerImpl extends BaseServerImpl implements ProductServer {
	@Resource
	private IdService idService;
	@Resource
	private ProductService productService;
	@Resource
	private CatalogService catalogService;
	@Resource
	private TranslateService translateService;
	@Autowired
	SystemConfig systemConfig;
	@Transactional
	@Override
	public ProductVo add(ProductBo bo) {
		Product po = getPo(bo);
		ProductEx poEx = getPoEx(bo);
		long id = idService.genId();
		po.setId(id);
		po.setAddTime(new Date());
		poEx.setId(po.getId());
		poEx.setAddTime(po.getAddTime());
		productService.save(po);
		productService.saveEx(poEx);
		// 添加国际化
		Locale locale = LocaleContextHolder.getLocale();
		translateService.save(po, locale.toString());
		translateService.save(poEx, locale.toString());
		return getVo(po);
	}

	@Transactional
	@Override
	public ProductVo update(ProductBo bo) {
		Product po = getPo(bo);
		ProductEx poEx = getPoEx(bo);
		//必须先调用国际化，再调用原表更新
		// 更新国际化,会擦拭掉已国际化的字段为null。为null的字段代表不需要再更新，如果不擦拭掉后续的更新将导致其他语言覆盖掉原表的默认语言
		Locale locale = LocaleContextHolder.getLocale();
		translateService.update(po, locale.toString());
		translateService.update(poEx, locale.toString());
		productService.update(po);
		productService.updateEx(poEx);
		return bo;
	}
	
	@Override
	public List<ProductVo> getList(Map<String, Object> querys) {
		List<Product> poList = productService.getList(querys);
		poList=translateService.translateList(poList, LocaleContextHolder.getLocale().toString());
		List<ProductVo> list = new ArrayList<>();
		if (!ObjectUtils.isEmpty(poList)) {
			for (Product po : poList) {
				list.add(getVo(po));
			}
		}
		return list;
	}

	@Override
	public BaseListVo<ProductVo> queryList(Map<String, Object> querys) {
		List<ProductVo> list = getList(querys);
		Page page = productService.getPage(querys);
		BaseListVo<ProductVo> baseListVo = new BaseListVo<ProductVo>();
		baseListVo.setPage(page);
		baseListVo.setResult(list);
		if (!ObjectUtils.isEmpty(list)) {
			baseListVo.setTotal(productService.getCount(querys).intValue());
		}
		return baseListVo;
	}

	@Override
	public ProductVo get(Long id) {
		Product po = productService.get(id);
		po =(Product)translateService.translate(po,LocaleContextHolder.getLocale().toString());
		List<Long> ids = catalogService.getTreeIds(po.getCatalogId());
		Long[] catalogIds = new Long[ids.size()];
		ids.toArray(catalogIds);
		ProductVo vo = this.getVo(po);
		vo.setCatalogIds(catalogIds);
		ProductEx poEx = productService.getEx(id);
		poEx=(ProductEx)translateService.translate(poEx,LocaleContextHolder.getLocale().toString());
		setVoEx(poEx, vo);
		return vo;
	}

	private Product getPo(ProductBo bo) {
		Product po = new Product();
		BeanUtils.copyProperties(bo, po);
		if (!ObjectUtils.isEmpty(bo.getCatalogIds())) {
			po.setCatalogId(bo.getCatalogIds()[bo.getCatalogIds().length - 1]);
		}
		return po;
	}

	private ProductEx getPoEx(ProductBo bo) {
		ProductEx po = new ProductEx();
		BeanUtils.copyProperties(bo, po, "del", "addTime");
		return po;
	}

	private ProductVo getVo(Product po) {
		ProductVo vo = new ProductVo();
		BeanUtils.copyProperties(po, vo);
		return vo;
	}

	private void setVoEx(ProductEx po, ProductVo vo) {
		BeanUtils.copyProperties(po, vo, "del", "addTime");
	}

	

	@Override
	public ProductBo getBo(ProductVo vo) {
		ProductBo bo = new ProductBo();
		BeanUtils.copyProperties(vo, bo);
		return bo;
	}

}
