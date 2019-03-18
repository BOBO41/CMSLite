package com.xiang.productserver;

import java.util.List;
import java.util.Map;

import com.xiang.bean.bo.CatalogBo;
import com.xiang.bean.vo.CatalogVo;
import com.xiang.inventoryserver.server.BaseServer;

public interface CatalogServer extends BaseServer{
	public List<CatalogVo> getCatologTree(Map<String,Object> querys);
	public CatalogVo add(CatalogBo bo);
	public void setDelById(Long[] ids, Boolean del);
	public void up(Long id);
	public void down(Long id);
}
