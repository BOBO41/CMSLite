package com.xiang.cmsserver.server.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import com.robert.vesta.service.intf.IdService;
import com.xiang.bean.bo.ComProductBo;
import com.xiang.bean.po.ComProduct;
import com.xiang.bean.po.Nav;
import com.xiang.bean.po.Product;
import com.xiang.bean.vo.BaseListVo;
import com.xiang.bean.vo.ComProductVo;
import com.xiang.bean.vo.ProductVo;
import com.xiang.cmsserver.server.ComProductServer;
import com.xiang.cmsserver.service.ComProductService;
import com.xiang.productservice.ProductService;
import com.xiang.restserver.APIException;
import com.xiang.restserver.ErrorCodes;
import com.xiang.restserver.Page;
import com.xiang.server.impl.BaseServerImpl;
import com.xiang.service.TranslateService;

/**
 * @author xiang
 * @createDate 2018年12月20日 下午2:18:51
 */
@Service("comProductServer")
public class ComProductServerImpl extends BaseServerImpl implements ComProductServer {
	@Resource
	private IdService idService;
	@Resource
	private ComProductService comProductService;
	@Resource
	private ProductService productService;
	@Resource
	private TranslateService translateService;
	@Transactional
	@Override
	public ComProductVo add(ComProductBo bo) {
		ComProduct po = getPo(bo);
		long id = idService.genId();
		po.setId(id);
		po.setAddTime(new Date());
		Long sort = comProductService.getMax("com_product", "sort");
		if (Objects.isNull(sort)) {
			sort = 0l;
		}
		po.setSort(sort.intValue() + 1);
		comProductService.save(po);
		// 添加国际化
				Locale locale = LocaleContextHolder.getLocale();
				translateService.save(po, locale.toString());
		return getVo(po);
	}

	@Transactional
	@Override
	public ComProductVo update(ComProductBo bo) {
		ComProduct po = getPo(bo);
		// 必须先调用国际化，再调用原表更新
				// 更新国际化,会擦拭掉已国际化的字段为null。为null的字段代表不需要再更新，如果不擦拭掉后续的更新将导致其他语言覆盖掉原表的默认语言
				Locale locale = LocaleContextHolder.getLocale();
				translateService.update(po, locale.toString());
		comProductService.update(po);
		return bo;
	}

	private ComProduct getPo(ComProductBo bo) {
		ComProduct po = new ComProduct();
		BeanUtils.copyProperties(bo, po);
		if(!ObjectUtils.isEmpty(bo.getProductIds())) {
			po.setContent(StringUtils.join(bo.getProductIds(), ","));
		}
		return po;
	}

	private ComProductVo getVo(ComProduct po) {
		ComProductVo vo = new ComProductVo();
		BeanUtils.copyProperties(po, vo);
		if(!StringUtils.isEmpty(po.getContent())) {
			String[] ids=StringUtils.split(po.getContent(), ",");
			Long[] productIds=new Long[ids.length];
			for(int i=0;i<ids.length;i++) {
				productIds[i]=Long.valueOf(ids[i]);
			}
			vo.setProductIds(productIds);
		}
		return vo;
	}

	@Override
	public List<ComProductVo> getList(Map<String, Object> querys) {
		List<ComProduct> poList = comProductService.getList(querys);
		poList = translateService.translateList(poList, LocaleContextHolder.getLocale().toString());
		List<ComProductVo> list = new ArrayList<>();
		if (!ObjectUtils.isEmpty(poList)) {
			for (ComProduct po : poList) {
				list.add(getVo(po));
			}
		}
		return list;
	}

	@Override
	public BaseListVo<ComProductVo> queryList(Map<String, Object> querys) {
		List<ComProductVo> list = getList(querys);
		Page page = comProductService.getPage(querys);
		BaseListVo<ComProductVo> baseListVo = new BaseListVo<ComProductVo>();
		baseListVo.setPage(page);
		baseListVo.setResult(list);
		if (!ObjectUtils.isEmpty(list)) {
			baseListVo.setTotal(comProductService.getCount(querys).intValue());
		}
		return baseListVo;
	}

	@Override
	public ComProductVo get(Long id) {
		ComProduct po = comProductService.get(id);
		po = (ComProduct) translateService.translate(po, LocaleContextHolder.getLocale().toString());
		ComProductVo vo = this.getVo(po);
		return vo;
	}

	@Override
	public List<ComProductVo> getList() {
		Map<String, Object> querys = new HashMap<String, Object>();
		querys.put(Page.SORT, "+sort");
		querys.put("andDelEqualTo", false);
		return getList(querys);
	}

	@Transactional
	@Override
	public void up(Long id) {
		ComProduct po = comProductService.get(id);
		ComProduct pre = comProductService.getPre(po);
		if (Objects.isNull(pre)) {
			throw new APIException(ErrorCodes.SORT_TOP);
		}
		if (pre.getSort().compareTo(po.getSort()) == 0) {
			pre.setSort(pre.getSort() - 1);
			if (pre.getSort() < 1) {
				throw new APIException(ErrorCodes.SORT_TOP);
			}
		}
		ComProduct update = new ComProduct();
		update.setId(po.getId());
		update.setSort(pre.getSort());
		comProductService.update(update);
		update = new ComProduct();
		update.setId(pre.getId());
		update.setSort(po.getSort());
		comProductService.update(update);
	}

	@Transactional
	@Override
	public void down(Long id) {
		// TODO Auto-generated method stub
		ComProduct po = comProductService.get(id);
		ComProduct next = comProductService.getNext(po);
		if (Objects.isNull(next)) {
			throw new APIException(ErrorCodes.SORT_BOTTOM);
		}
		if (next.getSort().compareTo(po.getSort()) == 0) {
			next.setSort(next.getSort() + 1);
		}
		ComProduct update = new ComProduct();
		update.setId(po.getId());
		update.setSort(next.getSort());
		comProductService.update(update);
		update = new ComProduct();
		update.setId(next.getId());
		update.setSort(po.getSort());
		comProductService.update(update);
	}

	@Override
	public List<ProductVo> getProductList(Long id) {
		ComProduct po = comProductService.get(id);
		if (!ObjectUtils.isEmpty(po.getContent())) {
			List<Long> idIn = new ArrayList<>();
			String[] ids = po.getContent().split(",");
			for (String productId : ids) {
				idIn.add(Long.valueOf(productId));
			}
			Map<String, Object> querys = new HashMap<String, Object>();
			querys.put("andIdIn", idIn);
			List<Product> products = productService.getList(querys);
			products = translateService.translateList(products, LocaleContextHolder.getLocale().toString());
			
			if (!ObjectUtils.isEmpty(products)) {
				List<ProductVo> result = new ArrayList<>(products.size());
				for (Product productPo : products) {
					ProductVo vo = new ProductVo();
					BeanUtils.copyProperties(productPo, vo);
					result.add(vo);
				}
				return result;
			}
		}
		return new ArrayList<ProductVo>(0);
	}
}
