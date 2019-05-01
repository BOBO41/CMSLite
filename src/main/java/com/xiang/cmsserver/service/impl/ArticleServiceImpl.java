package com.xiang.cmsserver.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.xiang.bean.po.Article;
import com.xiang.bean.po.ArticleEx;
import com.xiang.bean.po.ArticleExample;
import com.xiang.bean.po.ArticleExample.Criteria;
import com.xiang.cmsserver.service.ArticleService;
import com.xiang.mapper.ArticleExMapper;
import com.xiang.mapper.ArticleMapper;
import com.xiang.restserver.Page;
import com.xiang.service.impl.BaseServiceImpl;

/**
 * @author xiang
 * @createDate 2018年12月20日 下午2:18:51
 */
@Service("articleService")
public class ArticleServiceImpl extends BaseServiceImpl<Article> implements ArticleService {
	@Autowired
	private ArticleMapper articleMapper;
	@Autowired
	private ArticleExMapper articleExMapper;
	@Override
	public Article get(Long id) {
		return articleMapper.selectByPrimaryKey(id);
	}
	@Override
	public void save(Article record) {
		articleMapper.save(record);
	}

	@Override
	public void update(Article record) {
		articleMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<Article> getList(Map<String, Object> querys) {
		Page page = this.getPage(querys);
		try {
			ArticleExample example = getExample(querys);
			setPage(page);
			return articleMapper.selectByExample(example);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private ArticleExample getExample(Map<String, Object> querys){
		if (!ObjectUtils.isEmpty(querys)) {
			ArticleExample example = new ArticleExample();
			Criteria criteria = example.createCriteria();
			setCriteria(criteria,querys);
			return example;
		}
		return null;
	}
	@Override
	public Long getCount(Map<String, Object> querys) {
		ArticleExample example = getExample(querys);
		return articleMapper.countByExample(example);
	}
	@Override
	public ArticleEx getEx(Long id) {
		return articleExMapper.selectByPrimaryKey(id);
	}
	@Override
	public void saveEx(ArticleEx record) {
		articleExMapper.save(record);
	}
	@Override
	public void updateEx(ArticleEx record) {
		articleExMapper.updateByPrimaryKeySelective(record);
	}
}
