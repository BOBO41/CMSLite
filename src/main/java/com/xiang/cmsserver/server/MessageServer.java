package com.xiang.cmsserver.server;

import java.util.List;
import java.util.Map;

import com.xiang.bean.bo.MessageBo;
import com.xiang.bean.vo.BaseListVo;
import com.xiang.bean.vo.MessageVo;
import com.xiang.server.BaseServer;

public interface MessageServer extends BaseServer{
	public MessageVo add(MessageBo bo);
	public MessageVo update(MessageBo bo);
	public List<MessageVo> getList(Map<String,Object> querys);
	public List<MessageVo> getList();
	public BaseListVo<MessageVo> queryList(Map<String,Object> querys);
	public MessageVo get(Long id);
}
