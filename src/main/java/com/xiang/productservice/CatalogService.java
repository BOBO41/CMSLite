package com.xiang.productservice;

import java.util.List;

import com.xiang.bean.po.Catalog;
import com.xiang.inventoryserver.service.BaseService;

/**
* @author xiang
* @createDate 2018年12月20日 下午2:18:00
*/
public interface CatalogService extends BaseService<Catalog>{
	public Catalog get(Long id);
	public List<Catalog> getChilds(Long[] id,Boolean del);
	public void save(Catalog catalog);
	public void update(Catalog catalog);
	public Catalog getTopChildren(Long parentId);
	public Catalog getLastChildren(Long parentId);
	public int updateRight(Long id,Long orignRightId,Long rightId);
	public int updateLeft(Long id,Long orignLeftId,Long leftId);
}
