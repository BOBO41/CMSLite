package com.xiang.cmsserver.server.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import com.robert.vesta.service.intf.IdService;
import com.xiang.bean.bo.BlockBo;
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
	@Transactional
	@Override
	public BlockVo add(BlockBo bo) {
		Block po = getPo(bo);
		long id = idService.genId();
		po.setId(id);
		po.setAddTime(new Date());
		blockService.save(po);
		return getVo(po);
	}

	@Transactional
	@Override
	public BlockVo update(BlockBo bo) {
		Block po = getPo(bo);
		blockService.update(po);
		return getVo(po);
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
