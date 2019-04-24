package com.xiang.cmsserver.service;

import com.xiang.inventoryserver.service.BaseService;
import com.xiang.bean.po.SiteInfo;

public interface SiteInfoService extends BaseService<SiteInfo>{
	public SiteInfo get(Long id);
	public void save(SiteInfo record);
	public void update(SiteInfo record);
}
