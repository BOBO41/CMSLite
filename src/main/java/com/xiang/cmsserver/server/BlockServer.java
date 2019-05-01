package com.xiang.cmsserver.server;

import java.util.List;
import java.util.Map;

import com.xiang.bean.bo.BlockBo;
import com.xiang.bean.vo.BaseListVo;
import com.xiang.bean.vo.BlockVo;
import com.xiang.server.BaseServer;

public interface BlockServer extends BaseServer{
	public BlockVo add(BlockBo bo);
	public BlockVo update(BlockBo bo);
	public List<BlockVo> getList(Map<String,Object> querys);
	public List<BlockVo> getList();
	public BaseListVo<BlockVo> queryList(Map<String,Object> querys);
	public BlockVo get(Long id);
}
