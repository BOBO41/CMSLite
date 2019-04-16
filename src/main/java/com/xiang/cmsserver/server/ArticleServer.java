package com.xiang.cmsserver.server;

import java.util.List;
import java.util.Map;

import com.xiang.bean.bo.ArticleBo;
import com.xiang.bean.vo.BaseListVo;
import com.xiang.cms.vo.ArticleVo;
import com.xiang.inventoryserver.server.BaseServer;

public interface ArticleServer extends BaseServer{
	public ArticleVo add(ArticleBo bo);
	public ArticleVo update(ArticleBo bo);
	public List<ArticleVo> getList(Map<String,Object> querys);
	public BaseListVo<ArticleVo> queryList(Map<String,Object> querys);
	public ArticleVo get(Long id);
}
