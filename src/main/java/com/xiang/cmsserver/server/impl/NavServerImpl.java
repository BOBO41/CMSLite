package com.xiang.cmsserver.server.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import com.robert.vesta.service.intf.IdService;
import com.xiang.bean.bo.NavBo;
import com.xiang.bean.po.Nav;
import com.xiang.bean.vo.BaseListVo;
import com.xiang.bean.vo.NavVo;
import com.xiang.bean.vo.ProductVo;
import com.xiang.cmsserver.server.NavServer;
import com.xiang.cmsserver.service.NavService;
import com.xiang.inventoryserver.server.impl.BaseServerImpl;
import com.xiang.productservice.CatalogService;
import com.xiang.restserver.APIException;
import com.xiang.restserver.ErrorCodes;
import com.xiang.restserver.Page;

/**
 * @author xiang
 * @createDate 2018年12月20日 下午2:18:51
 */
@Service("navServer")
public class NavServerImpl extends BaseServerImpl implements NavServer {
	@Resource
	private IdService idService;
	@Resource
	private NavService navService;
	@Resource
	private CatalogService catalogService;
	@Transactional
	@Override
	public NavVo add(NavBo bo) {
		Nav po = getPo(bo);
		long id = idService.genId();
		po.setId(id);
		po.setAddTime(new Date());
		Long sort = navService.getCount(null);
		if (Objects.isNull(sort)) {
			sort = 0l;
		}
		po.setSort(sort.intValue()+1);
		navService.save(po);
		NavVo vo=getVo(po);
		vo.setLink(bo.getLink());
		vo.setCatalogIds(bo.getCatalogIds());
		return vo;
	}

	@Transactional
	@Override
	public NavVo update(NavBo bo) {
		Nav po = getPo(bo);
		navService.update(po);
		NavVo vo=getVo(po);
		getVo( po, vo);
		return vo;
	}

	private Nav getPo(NavBo bo) {
		Nav po = new Nav();
		BeanUtils.copyProperties(bo, po);
		if(bo.getType()==0) {
			po.setPayload(bo.getLink());
		}else {
			po.setPayload(bo.getCatalogIds()[bo.getCatalogIds().length-1].toString());
		}
		return po;
	}
	private NavVo getVo(Nav po,NavVo vo) {
		if(po.getType()==0) {
			vo.setLink(po.getPayload());
		}else {
			List<Long> ids=catalogService.getTreeIds(Long.valueOf(po.getPayload()));
			Long[] catalogIds=new Long[ids.size()];
			ids.toArray(catalogIds);
			vo.setCatalogIds(catalogIds);
		}
		return vo;
	}
	private NavVo setLinkVo(Nav po,NavVo vo) {
		if(po.getType()==0) {
			vo.setLink(po.getPayload());
		}else {
			vo.setLink("/cms/catalog/"+po.getPayload());
		}
		return vo;
	}
	private NavVo getVo(Nav po) {
		NavVo vo = new NavVo();
		BeanUtils.copyProperties(po, vo);
		return vo;
	}

	@Override
	public List<NavVo> getList(Map<String, Object> querys) {
		List<Nav> poList = navService.getList(querys);
		List<NavVo> list = new ArrayList<>();
		if (!ObjectUtils.isEmpty(poList)) {
			for (Nav po : poList) {
				NavVo vo = this.getVo(po);
				setLinkVo( po, vo);
				list.add(vo);
			}
		}
		return list;
	}

	@Override
	public BaseListVo<NavVo> queryList(Map<String, Object> querys) {
		List<NavVo> list = getList(querys);
		Page page = navService.getPage(querys);
		BaseListVo<NavVo> baseListVo = new BaseListVo<NavVo>();
		baseListVo.setPage(page);
		baseListVo.setResult(list);
		if (!ObjectUtils.isEmpty(list)) {
			baseListVo.setTotal(navService.getCount(querys).intValue());
		}
		return baseListVo;
	}

	@Override
	public NavVo get(Long id) {
		Nav po = navService.get(id);
		NavVo vo = this.getVo(po);
		getVo( po, vo);
		return vo;
	}

	@Transactional
	@Override
	public void up(Long id) {
		Nav po = navService.get(id);
		Nav pre = navService.getPre(po);
		if (Objects.isNull(pre)) {
			throw new APIException(ErrorCodes.SORT_TOP);
		}
		Nav update = new Nav();
		update.setId(po.getId());
		update.setSort(pre.getSort());
		navService.update(update);
		update = new Nav();
		update.setId(pre.getId());
		update.setSort(po.getSort());
		navService.update(update);
	}

	@Transactional
	@Override
	public void down(Long id) {
		// TODO Auto-generated method stub
		Nav po = navService.get(id);
		Nav next = navService.getNext(po);
		if (Objects.isNull(next)) {
			throw new APIException(ErrorCodes.SORT_BOTTOM);
		}
		Nav update = new Nav();
		update.setId(po.getId());
		update.setSort(next.getSort());
		navService.update(update);
		update = new Nav();
		update.setId(next.getId());
		update.setSort(po.getSort());
		navService.update(update);
	}

}
