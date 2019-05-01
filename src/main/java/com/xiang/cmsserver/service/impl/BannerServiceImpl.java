package com.xiang.cmsserver.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.xiang.bean.po.Banner;
import com.xiang.bean.po.BannerExample;
import com.xiang.bean.po.BannerExample.Criteria;
import com.xiang.cmsserver.service.BannerService;
import com.xiang.mapper.BannerMapper;
import com.xiang.restserver.Page;
import com.xiang.service.impl.BaseServiceImpl;

/**
 * @author xiang
 * @createDate 2018年12月20日 下午2:18:51
 */
@Service("bannerService")
public class BannerServiceImpl extends BaseServiceImpl<Banner> implements BannerService {
	@Autowired
	private BannerMapper bannerMapper;
	@Override
	public Banner get(Long id) {
		return bannerMapper.selectByPrimaryKey(id);
	}
	@Override
	public void save(Banner record) {
		bannerMapper.save(record);
	}

	@Override
	public void update(Banner record) {
		bannerMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<Banner> getList(Map<String, Object> querys) {
		Page page = this.getPage(querys);
		try {
			BannerExample example = getExample(querys);
			return bannerMapper.getList(example, page);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private BannerExample getExample(Map<String, Object> querys){
		if (!ObjectUtils.isEmpty(querys)) {
			BannerExample example = new BannerExample();
			Criteria criteria = example.createCriteria();
			setCriteria(criteria,querys);
			return example;
		}
		return null;
	}
	@Override
	public Long getCount(Map<String, Object> querys) {
		BannerExample example = getExample(querys);
		return bannerMapper.countByExample(example);
	}
	@Override
	public Banner getPre(Banner record) {
		Map<String, Object>  querys=new HashMap<String,Object>();
		querys.put(Page.LIMIT, 1);
		querys.put(Page.PAGE, 1);
		querys.put(Page.SORT, "-sort");
		querys.put("andDelEqualTo", false);
		querys.put("andIdNotEqualTo", record.getId());
		querys.put("andSortLessThanOrEqualTo", record.getSort());
		List<Banner> list=getList(querys);
		if(!ObjectUtils.isEmpty(list)) {
			return list.get(0);
		}
		return null;
	}
	@Override
	public Banner getNext(Banner record) {
		Map<String, Object>  querys=new HashMap<String,Object>();
		querys.put(Page.LIMIT, 1);
		querys.put(Page.PAGE, 1);
		querys.put(Page.SORT, "+sort");
		querys.put("andDelEqualTo", false);
		querys.put("andIdNotEqualTo", record.getId());
		querys.put("andSortGreaterThanOrEqualTo", record.getSort());
		List<Banner> list=getList(querys);
		if(!ObjectUtils.isEmpty(list)) {
			return list.get(0);
		}
		return null;
	}
}
