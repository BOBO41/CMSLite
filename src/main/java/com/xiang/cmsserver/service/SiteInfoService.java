package com.xiang.cmsserver.service;

import com.xiang.bean.po.SiteInfo;
import com.xiang.service.BaseService;

public interface SiteInfoService extends BaseService<SiteInfo>{
	public SiteInfo get(Long id);
	public void save(SiteInfo record);
	public void update(SiteInfo record);
}
