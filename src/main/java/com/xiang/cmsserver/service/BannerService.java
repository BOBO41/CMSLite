package com.xiang.cmsserver.service;

import java.util.Map;

import com.xiang.bean.po.Banner;
import com.xiang.inventoryserver.service.BaseService;

/**
* @author xiang
* @createDate 2018年12月20日 下午2:18:00
*/
public interface BannerService extends BaseService<Banner>{
	public Banner get(Long id);
	public void save(Banner record);
	public void update(Banner record);
	public Banner getPre(Banner record);
	public Banner getNext(Banner record);
}
