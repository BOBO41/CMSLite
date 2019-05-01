package com.xiang.cmsserver.service.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.xiang.mapper.SiteInfoMapper;
import com.xiang.restserver.Page;
import com.xiang.service.impl.BaseServiceImpl;
import com.xiang.bean.po.SiteInfo;
import com.xiang.bean.po.SiteInfoExample;
import com.xiang.bean.po.SiteInfoExample.Criteria;
import com.xiang.cmsserver.service.SiteInfoService;

@Service("siteInfoService")
public class SiteInfoServiceImpl extends BaseServiceImpl<SiteInfo> implements SiteInfoService {
	@Autowired
	private SiteInfoMapper siteInfoMapper;
	@Override
	public SiteInfo get(Long id) {
		return siteInfoMapper.selectByPrimaryKey(id);
	}
	@Override
	public void save(SiteInfo record) {
		siteInfoMapper.save(record);
	}

	@Override
	public void update(SiteInfo record) {
		siteInfoMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<SiteInfo> getList(Map<String, Object> querys) {
		Page page = this.getPage(querys);
		try {
			SiteInfoExample example = getExample(querys);
			setPage(page);
			return siteInfoMapper.selectByExample(example);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private SiteInfoExample getExample(Map<String, Object> querys){
		if (!ObjectUtils.isEmpty(querys)) {
			SiteInfoExample example = new SiteInfoExample();
			Criteria criteria = example.createCriteria();
			setCriteria(criteria,querys);
			return example;
		}
		return null;
	}
	@Override
	public Long getCount(Map<String, Object> querys) {
		SiteInfoExample example = getExample(querys);
		return siteInfoMapper.countByExample(example);
	}
}
