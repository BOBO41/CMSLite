package com.xiang.cmsserver.server;

import java.util.List;
import java.util.Map;

import com.xiang.bean.bo.BannerBo;
import com.xiang.bean.vo.BannerVo;
import com.xiang.bean.vo.BaseListVo;
import com.xiang.server.BaseServer;

public interface BannerServer extends BaseServer{
	public BannerVo add(BannerBo bo);
	public BannerVo update(BannerBo bo);
	public List<BannerVo> getList(Map<String,Object> querys);
	public List<BannerVo> getList();
	public BaseListVo<BannerVo> queryList(Map<String,Object> querys);
	public BannerVo get(Long id);
	public void up(Long id);
	public void down(Long id);
}
