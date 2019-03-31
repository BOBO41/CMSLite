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
import com.xiang.bean.bo.BannerBo;
import com.xiang.bean.po.Banner;
import com.xiang.bean.po.CriteriaIgnoreKey;
import com.xiang.bean.po.Product;
import com.xiang.bean.po.ProductEx;
import com.xiang.bean.vo.BaseListVo;
import com.xiang.cms.vo.BannerVo;
import com.xiang.cmsserver.server.BannerServer;
import com.xiang.cmsserver.service.BannerService;
import com.xiang.inventoryserver.server.impl.BaseServerImpl;
import com.xiang.restserver.APIException;
import com.xiang.restserver.ErrorCodes;
import com.xiang.restserver.Page;

/**
 * @author xiang
 * @createDate 2018年12月20日 下午2:18:51
 */
@Service("bannerServer")
public class BannerServerImpl extends BaseServerImpl implements BannerServer {
	@Resource
	private IdService idService;
	@Resource
	private BannerService bannerService;
	@Transactional
	@Override
	public BannerVo add(BannerBo bo) {
		Banner po = getPo(bo);
		long id = idService.genId();
		po.setId(id);
		po.setAddTime(new Date());
		Long sort = bannerService.getCount(null);
		if (Objects.isNull(sort)) {
			sort = 0l;
		}
		po.setSort(sort.intValue()+1);
		bannerService.save(po);
		return getVo(po);
	}

	@Transactional
	@Override
	public BannerVo update(BannerBo bo) {
		Banner po = getPo(bo);
		bannerService.update(po);
		return getVo(po);
	}

	private Banner getPo(BannerBo bo) {
		Banner po = new Banner();
		BeanUtils.copyProperties(bo, po);
		return po;
	}

	private BannerVo getVo(Banner po) {
		BannerVo vo = new BannerVo();
		BeanUtils.copyProperties(po, vo);
		return vo;
	}

	@Override
	public List<BannerVo> getList(Map<String, Object> querys) {
		List<Banner> poList = bannerService.getList(querys);
		List<BannerVo> list = new ArrayList<>();
		if (!ObjectUtils.isEmpty(poList)) {
			for (Banner po : poList) {
				list.add(getVo(po));
			}
		}
		return list;
	}

	@Override
	public BaseListVo<BannerVo> queryList(Map<String, Object> querys) {
		List<BannerVo> list = getList(querys);
		Page page = bannerService.getPage(querys);
		BaseListVo<BannerVo> baseListVo = new BaseListVo<BannerVo>();
		baseListVo.setPage(page);
		baseListVo.setResult(list);
		if (!ObjectUtils.isEmpty(list)) {
			baseListVo.setTotal(bannerService.getCount(querys).intValue());
		}
		return baseListVo;
	}

	@Override
	public BannerVo get(Long id) {
		Banner po = bannerService.get(id);
		BannerVo vo = this.getVo(po);
		return vo;
	}

	@Transactional
	@Override
	public void up(Long id) {
		Banner po = bannerService.get(id);
		Banner pre = bannerService.getPre(po);
		if (Objects.isNull(pre)) {
			throw new APIException(ErrorCodes.SORT_TOP);
		}
		Banner update = new Banner();
		update.setId(po.getId());
		update.setSort(pre.getSort());
		bannerService.update(update);
		update = new Banner();
		update.setId(pre.getId());
		update.setSort(po.getSort());
		bannerService.update(update);
	}

	@Transactional
	@Override
	public void down(Long id) {
		// TODO Auto-generated method stub
		Banner po = bannerService.get(id);
		Banner next = bannerService.getNext(po);
		if (Objects.isNull(next)) {
			throw new APIException(ErrorCodes.SORT_BOTTOM);
		}
		Banner update = new Banner();
		update.setId(po.getId());
		update.setSort(next.getSort());
		bannerService.update(update);
		update = new Banner();
		update.setId(next.getId());
		update.setSort(po.getSort());
		bannerService.update(update);
	}

	@Override
	public List<BannerVo> getList() {
		Map<String, Object>  querys=new HashMap<String,Object>();
		querys.put(Page.SORT, "-sort");
		querys.put("andDelEqualTo", false);
		return getList(querys);
	}

}
