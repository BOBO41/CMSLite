package com.xiang.cmsserver.service;

import com.xiang.bean.po.Banner;
import com.xiang.bean.po.Block;
import com.xiang.service.BaseService;

/**
* @author xiang
* @createDate 2018年12月20日 下午2:18:00
*/
public interface BlockService extends BaseService<Block>{
	public Block get(Long id);
	public void save(Block record);
	public void update(Block record);
}
