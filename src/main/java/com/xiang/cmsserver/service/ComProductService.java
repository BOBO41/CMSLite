package com.xiang.cmsserver.service;

import com.xiang.bean.po.ComProduct;
import com.xiang.inventoryserver.service.BaseService;

/**
* @author xiang
* @createDate 2018年12月20日 下午2:18:00
*/
public interface ComProductService extends BaseService<ComProduct>{
	public ComProduct get(Long id);
	public void save(ComProduct record);
	public void update(ComProduct record);
	public ComProduct getPre(ComProduct record);
	public ComProduct getNext(ComProduct record);
}
