package com.xiang.cmsserver.server.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import com.robert.vesta.service.intf.IdService;
import com.xiang.bean.bo.ArticleBo;
import com.xiang.bean.po.Article;
import com.xiang.bean.po.ArticleEx;
import com.xiang.bean.vo.ArticleVo;
import com.xiang.bean.vo.BaseListVo;
import com.xiang.cmsserver.server.ArticleServer;
import com.xiang.cmsserver.service.ArticleService;
import com.xiang.restserver.Page;
import com.xiang.server.impl.BaseServerImpl;
import com.xiang.service.TranslateService;

/**
 * @author xiang
 * @createDate 2018年12月20日 下午2:18:51
 */
@Service("articleServer")
public class ArticleServerImpl extends BaseServerImpl implements ArticleServer {
	@Resource
	private IdService idService;
	@Resource
	private ArticleService articleService;
	@Resource
	private TranslateService translateService;

	@Transactional
	@Override
	public ArticleVo add(ArticleBo bo) {
		Article po = getPo(bo);
		ArticleEx poEx = getPoEx(bo);
		long id = idService.genId();
		po.setId(id);
		po.setAddTime(new Date());
		poEx.setId(po.getId());
		poEx.setAddTime(po.getAddTime());
		articleService.save(po);
		articleService.saveEx(poEx);
		// 添加国际化
		Locale locale = LocaleContextHolder.getLocale();
		translateService.save(po, locale.toString());
		translateService.save(poEx, locale.toString());
		return getVo(po);
	}

	@Transactional
	@Override
	public ArticleVo update(ArticleBo bo) {
		Article po = getPo(bo);
		ArticleEx poEx = getPoEx(bo);
		// 必须先调用国际化，再调用原表更新
		// 更新国际化,会擦拭掉已国际化的字段为null。为null的字段代表不需要再更新，如果不擦拭掉后续的更新将导致其他语言覆盖掉原表的默认语言
		Locale locale = LocaleContextHolder.getLocale();
		translateService.update(po, locale.toString());
		translateService.update(poEx, locale.toString());
		articleService.update(po);
		articleService.updateEx(poEx);
		return bo;
	}

	private Article getPo(ArticleBo bo) {
		Article po = new Article();
		BeanUtils.copyProperties(bo, po);
		return po;
	}

	private ArticleEx getPoEx(ArticleBo bo) {
		ArticleEx po = new ArticleEx();
		BeanUtils.copyProperties(bo, po, "del", "addTime");
		return po;
	}

	private ArticleVo getVo(Article po) {
		ArticleVo vo = new ArticleVo();
		BeanUtils.copyProperties(po, vo);
		return vo;
	}

	private void setVoEx(ArticleEx po, ArticleVo vo) {
		BeanUtils.copyProperties(po, vo, "del", "addTime");
	}

	@Override
	public List<ArticleVo> getList(Map<String, Object> querys) {
		List<Article> poList = articleService.getList(querys);
		poList = translateService.translateList(poList, LocaleContextHolder.getLocale().toString());
		List<ArticleVo> list = new ArrayList<>();
		if (!ObjectUtils.isEmpty(poList)) {
			for (Article po : poList) {
				list.add(getVo(po));
			}
		}
		return list;
	}

	@Override
	public BaseListVo<ArticleVo> queryList(Map<String, Object> querys) {
		List<ArticleVo> list = getList(querys);
		Page page = articleService.getPage(querys);
		BaseListVo<ArticleVo> baseListVo = new BaseListVo<ArticleVo>();
		baseListVo.setPage(page);
		baseListVo.setResult(list);
		if (!ObjectUtils.isEmpty(list)) {
			baseListVo.setTotal(articleService.getCount(querys).intValue());
		}
		return baseListVo;
	}

	@Override
	public ArticleVo get(Long id) {
		Article po = articleService.get(id);
		po = (Article) translateService.translate(po, LocaleContextHolder.getLocale().toString());
		ArticleVo vo = this.getVo(po);
		ArticleEx poEx = articleService.getEx(id);
		poEx = (ArticleEx) translateService.translate(poEx, LocaleContextHolder.getLocale().toString());
		setVoEx(poEx, vo);
		return vo;
	}

}
