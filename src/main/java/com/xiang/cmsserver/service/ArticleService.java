package com.xiang.cmsserver.service;

import com.xiang.bean.po.Article;
import com.xiang.bean.po.ArticleEx;
import com.xiang.inventoryserver.service.BaseService;

/**
* @author xiang
* @createDate 2018年12月20日 下午2:18:00
*/
public interface ArticleService extends BaseService<Article>{
	public Article get(Long id);
	public ArticleEx getEx(Long id);
	public void save(Article record);
	public void saveEx(ArticleEx record);
	public void update(Article record);
	public void updateEx(ArticleEx record);
}
