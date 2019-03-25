package com.xiang.cmsserver.server;

import java.util.List;
import java.util.Map;

import com.xiang.bean.bo.NavBo;
import com.xiang.bean.vo.BaseListVo;
import com.xiang.bean.vo.NavVo;
import com.xiang.cms.vo.CmsNavVo;
import com.xiang.inventoryserver.server.BaseServer;

public interface NavServer extends BaseServer{
	public NavVo add(NavBo bo);
	public NavVo update(NavBo bo);
	public List<NavVo> getList(Map<String,Object> querys);
	public BaseListVo<NavVo> queryList(Map<String,Object> querys);
	public List<CmsNavVo> getCmsNavs();
	public NavVo get(Long id);
	public void up(Long id);
	public void down(Long id);
}
