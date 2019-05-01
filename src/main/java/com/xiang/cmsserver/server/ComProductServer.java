package com.xiang.cmsserver.server;

import java.util.List;
import java.util.Map;

import com.xiang.bean.bo.ComProductBo;
import com.xiang.bean.vo.BaseListVo;
import com.xiang.bean.vo.ComProductVo;
import com.xiang.bean.vo.ProductVo;
import com.xiang.server.BaseServer;

public interface ComProductServer extends BaseServer{
	public ComProductVo add(ComProductBo bo);
	public ComProductVo update(ComProductBo bo);
	public List<ComProductVo> getList(Map<String,Object> querys);
	public List<ComProductVo> getList();
	public BaseListVo<ComProductVo> queryList(Map<String,Object> querys);
	public ComProductVo get(Long id);
	public void up(Long id);
	public void down(Long id);
	public List<ProductVo> getProductList(Long id);
}
