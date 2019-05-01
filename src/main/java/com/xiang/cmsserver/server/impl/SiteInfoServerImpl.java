package com.xiang.cmsserver.server.impl;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import com.robert.vesta.service.intf.IdService;
import com.xiang.bean.bo.SiteInfoBo;
import com.xiang.bean.po.SiteInfo;
import com.xiang.bean.vo.BaseListVo;
import com.xiang.bean.vo.SiteInfoVo;
import com.xiang.cmsserver.server.SiteInfoServer;
import com.xiang.cmsserver.service.SiteInfoService;
import com.xiang.restserver.Page;
import com.xiang.server.impl.BaseServerImpl;
/**
 * @author xiang
 * @createDate 2019-04-22 18:02:08
 */
@Service("siteInfoServer")
public class SiteInfoServerImpl extends BaseServerImpl implements SiteInfoServer {
	@Resource
	private IdService idService;
	@Resource
	private SiteInfoService siteInfoService;
	@Transactional
	@Override
	public SiteInfoVo add(SiteInfoBo bo) {
		SiteInfo po = getPo(bo);
		long id = idService.genId();
		po.setId(id);
		po.setAddTime(new Date());
		siteInfoService.save(po);
		return getVo(po);
	}

	@Transactional
	@Override
	public SiteInfoVo update(SiteInfoBo bo) {
		SiteInfo po = getPo(bo);
		siteInfoService.update(po);
		return getVo(po);
	}

	private SiteInfo getPo(SiteInfoBo bo) {
		SiteInfo po = new SiteInfo();
		BeanUtils.copyProperties(bo, po);
		return po;
	}

	private SiteInfoVo getVo(SiteInfo po) {
		SiteInfoVo vo = new SiteInfoVo();
		BeanUtils.copyProperties(po, vo);
		return vo;
	}

	@Override
	public List<SiteInfoVo> getList(Map<String, Object> querys) {
		List<SiteInfo> poList = siteInfoService.getList(querys);
		List<SiteInfoVo> list = new ArrayList<>();
		if (!ObjectUtils.isEmpty(poList)) {
			for (SiteInfo po : poList) {
				list.add(getVo(po));
			}
		}
		return list;
	}

	@Override
	public BaseListVo<SiteInfoVo> queryList(Map<String, Object> querys) {
		List<SiteInfoVo> list = getList(querys);
		Page page = siteInfoService.getPage(querys);
		BaseListVo<SiteInfoVo> baseListVo = new BaseListVo<SiteInfoVo>();
		baseListVo.setPage(page);
		baseListVo.setResult(list);
		if (!ObjectUtils.isEmpty(list)) {
			baseListVo.setTotal(siteInfoService.getCount(querys).intValue());
		}
		return baseListVo;
	}

	@Override
	public SiteInfoVo get(Long id) {
		SiteInfo po = siteInfoService.get(id);
		SiteInfoVo vo = this.getVo(po);
		return vo;
	}
	@Override
	public List<SiteInfoVo> getList() {
		Map<String, Object>  querys=new HashMap<String,Object>();
		querys.put(Page.SORT, "-addTime");
		querys.put("andDelEqualTo", false);
		return getList(querys);
	}

}
