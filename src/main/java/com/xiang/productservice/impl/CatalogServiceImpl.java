package com.xiang.productservice.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.xiang.bean.po.Catalog;
import com.xiang.bean.po.CatalogExample;
import com.xiang.bean.po.CatalogExample.Criteria;
import com.xiang.inventoryserver.mapper.CatalogMapper;
import com.xiang.inventoryserver.service.impl.BaseServiceImpl;
import com.xiang.productservice.CatalogService;
import com.xiang.restserver.Page;

/**
 * @author xiang
 * @createDate 2018年12月20日 下午2:18:51
 */
@Service("catalogService")
public class CatalogServiceImpl extends BaseServiceImpl<Catalog> implements CatalogService {
	@Autowired
	private CatalogMapper catalogMapper;

	@Override
	public Catalog get(Long id) {
		return catalogMapper.selectByPrimaryKey(id);
	}
	@Override
	public Catalog getLastChildren(Long parentId)
	{
		Map<String, Object> querys=new HashMap<>();
		querys.put("andDelEqualTo", false);
		querys.put("andParentIdEqualTo", parentId);
		querys.put("andRightIdEqualTo", 0l);
		CatalogExample example = getExample(querys);
		List<Catalog> catalogs=catalogMapper.selectByExample(example);
		if(!ObjectUtils.isEmpty(catalogs)) {
			return catalogs.get(0);
		}
		return null;
	}
	@Override
	public Catalog getTopChildren(Long parentId)
	{
		Map<String, Object> querys=new HashMap<>();
		querys.put("andDelEqualTo", false);
		querys.put("andParentIdEqualTo", parentId);
		querys.put("andLeftIdEqualTo", 0l);
		CatalogExample example = getExample(querys);
		List<Catalog> catalogs=catalogMapper.selectByExample(example);
		if(!ObjectUtils.isEmpty(catalogs))
		return catalogs.get(0);
		return null;
	}
	@Override
	public void save(Catalog catalog) {
		catalogMapper.save(catalog);
	}

	@Override
	public void update(Catalog catalog) {
		catalogMapper.updateByPrimaryKeySelective(catalog);
	}

	@Override
	public List<Catalog> getList(Map<String, Object> querys) {
		Page page = this.getPage(querys);
		try {
			CatalogExample example = getExample(querys);
			return catalogMapper.getList(example, page);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private CatalogExample getExample(Map<String, Object> querys){
		if (!ObjectUtils.isEmpty(querys)) {
			CatalogExample example = new CatalogExample();
			Criteria criteria = example.createCriteria();
			setCriteria(criteria,querys);
			return example;
		}
		return null;
	}

	@Override
	public List<Catalog> getChilds(Long[] id,Boolean del) {
		if(!ObjectUtils.isEmpty(id)) {
			return catalogMapper.getChilds(id,del);
		}
		return null;
	}
	@Override
	public int updateRight(Long id, Long orignRightId, Long rightId) {
		return catalogMapper.updateRight( id,  orignRightId,  rightId);
	}
	@Override
	public int updateLeft(Long id, Long orignLeftId, Long leftId) {
		return catalogMapper.updateLeft( id,  orignLeftId,  leftId);
	}
}
