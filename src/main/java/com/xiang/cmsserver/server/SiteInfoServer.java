package com.xiang.cmsserver.server;
import java.util.List;
import java.util.Map;
import com.xiang.bean.bo.SiteInfoBo;
import com.xiang.bean.vo.BaseListVo;
import com.xiang.bean.vo.SiteInfoVo;
import com.xiang.server.BaseServer;
public interface SiteInfoServer extends BaseServer{
	public SiteInfoVo add(SiteInfoBo bo);
	public SiteInfoVo update(SiteInfoBo bo);
	public List<SiteInfoVo> getList();
	public List<SiteInfoVo> getList(Map<String,Object> querys);
	public BaseListVo<SiteInfoVo> queryList(Map<String,Object> querys);
	public SiteInfoVo get(Long id);
}
