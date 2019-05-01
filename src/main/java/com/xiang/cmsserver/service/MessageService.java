package com.xiang.cmsserver.service;

import com.xiang.bean.po.Message;
import com.xiang.service.BaseService;

/**
* @author xiang
* @createDate 2018年12月20日 下午2:18:00
*/
public interface MessageService extends BaseService<Message>{
	public Message get(Long id);
	public void save(Message record);
	public void update(Message record);
}
