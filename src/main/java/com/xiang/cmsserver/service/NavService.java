package com.xiang.cmsserver.service;

import com.xiang.bean.po.Nav;
import com.xiang.service.BaseService;

/**
* @author xiang
* @createDate 2018年12月20日 下午2:18:00
*/
public interface NavService extends BaseService<Nav>{
	public Nav get(Long id);
	public void save(Nav record);
	public void update(Nav record);
	public Nav getPre(Nav record);
	public Nav getNext(Nav record);
}
