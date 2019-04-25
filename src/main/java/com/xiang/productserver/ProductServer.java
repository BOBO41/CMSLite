package com.xiang.productserver;

import java.util.List;
import java.util.Map;

import com.xiang.bean.bo.ProductBo;
import com.xiang.bean.vo.BaseListVo;
import com.xiang.bean.vo.ProductVo;
import com.xiang.inventoryserver.server.BaseServer;

public interface ProductServer extends BaseServer{
	public ProductVo add(ProductBo bo);
	public ProductVo update(ProductBo bo);
	public List<ProductVo> getList(Map<String,Object> querys);
	public BaseListVo<ProductVo> queryList(Map<String,Object> querys);
	public ProductVo get(Long id);
	public ProductBo getBo(ProductVo vo);
}
