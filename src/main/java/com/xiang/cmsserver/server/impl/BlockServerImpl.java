package com.xiang.cmsserver.server.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import com.robert.vesta.service.intf.IdService;
import com.xiang.bean.bo.BlockBo;
import com.xiang.bean.po.Article;
import com.xiang.bean.po.Block;
import com.xiang.bean.po.CriteriaIgnoreKey;
import com.xiang.bean.po.Product;
import com.xiang.bean.po.ProductEx;
import com.xiang.bean.vo.BaseListVo;
import com.xiang.bean.vo.BlockVo;
import com.xiang.cmsserver.server.BlockServer;
import com.xiang.cmsserver.service.BlockService;
import com.xiang.restserver.APIException;
import com.xiang.restserver.ErrorCodes;
import com.xiang.restserver.Page;
import com.xiang.server.impl.BaseServerImpl;
import com.xiang.service.TranslateService;

/**
 * @author xiang
 * @createDate 2018年12月20日 下午2:18:51
 */
@Service("blockServer")
public class BlockServerImpl extends BaseServerImpl implements BlockServer {
	@Resource
	private IdService idService;
	@Resource
	private BlockService blockService;
	@Resource
	private TranslateService translateService;
	@Transactional
	@Override
	public BlockVo add(BlockBo bo) {
		Block po = getPo(bo);
		long id = idService.genId();
		po.setId(id);
		po.setAddTime(new Date());
		blockService.save(po);
		// 添加国际化
				Locale locale = LocaleContextHolder.getLocale();
				translateService.save(po, locale.toString());
		return getVo(po);
	}

	@Transactional
	@Override
	public BlockVo update(BlockBo bo) {
		Block po = getPo(bo);
		blockService.update(po);
		// 必须先调用国际化，再调用原表更新
		// 更新国际化,会擦拭掉已国际化的字段为null。为null的字段代表不需要再更新，如果不擦拭掉后续的更新将导致其他语言覆盖掉原表的默认语言
		Locale locale = LocaleContextHolder.getLocale();
		translateService.update(po, locale.toString());
		return bo;
	}

	private Block getPo(BlockBo bo) {
		Block po = new Block();
		BeanUtils.copyProperties(bo, po);
		return po;
	}

	private BlockVo getVo(Block po) {
		BlockVo vo = new BlockVo();
		BeanUtils.copyProperties(po, vo);
		return vo;
	}

	@Override
	public List<BlockVo> getList(Map<String, Object> querys) {
		List<Block> poList = blockService.getList(querys);
		poList = translateService.translateList(poList, LocaleContextHolder.getLocale().toString());
		List<BlockVo> list = new ArrayList<>();
		if (!ObjectUtils.isEmpty(poList)) {
			for (Block po : poList) {
				list.add(getVo(po));
			}
		}
		return list;
	}

	@Override
	public BaseListVo<BlockVo> queryList(Map<String, Object> querys) {
		List<BlockVo> list = getList(querys);
		Page page = blockService.getPage(querys);
		BaseListVo<BlockVo> baseListVo = new BaseListVo<BlockVo>();
		baseListVo.setPage(page);
		baseListVo.setResult(list);
		if (!ObjectUtils.isEmpty(list)) {
			baseListVo.setTotal(blockService.getCount(querys).intValue());
		}
		return baseListVo;
	}

	@Override
	public BlockVo get(Long id) {
		Block po = blockService.get(id);
		po = (Block) translateService.translate(po, LocaleContextHolder.getLocale().toString());
		BlockVo vo = this.getVo(po);
		return vo;
	}

	@Override
	public List<BlockVo> getList() {
		Map<String, Object>  querys=new HashMap<String,Object>();
		querys.put(Page.SORT, "+sort");
		querys.put("andDelEqualTo", false);
		return getList(querys);
	}

}
