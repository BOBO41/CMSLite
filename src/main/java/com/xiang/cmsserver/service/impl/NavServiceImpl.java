package com.xiang.cmsserver.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.xiang.bean.po.Nav;
import com.xiang.bean.po.NavExample;
import com.xiang.bean.po.NavExample.Criteria;
import com.xiang.cmsserver.service.NavService;
import com.xiang.mapper.NavMapper;
import com.xiang.restserver.Page;
import com.xiang.service.impl.BaseServiceImpl;

/**
 * @author xiang
 * @createDate 2018年12月20日 下午2:18:51
 */
@Service("navService")
public class NavServiceImpl extends BaseServiceImpl<Nav> implements NavService {
	@Autowired
	private NavMapper navMapper;
	@Override
	public Nav get(Long id) {
		return navMapper.selectByPrimaryKey(id);
	}
	@Override
	public void save(Nav record) {
		navMapper.save(record);
	}

	@Override
	public void update(Nav record) {
		navMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<Nav> getList(Map<String, Object> querys) {
		Page page = this.getPage(querys);
		try {
			NavExample example = getExample(querys);
			return navMapper.getList(example, page);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private NavExample getExample(Map<String, Object> querys){
		if (!ObjectUtils.isEmpty(querys)) {
			NavExample example = new NavExample();
			Criteria criteria = example.createCriteria();
			setCriteria(criteria,querys);
			return example;
		}
		return null;
	}
	@Override
	public Long getCount(Map<String, Object> querys) {
		NavExample example = getExample(querys);
		return navMapper.countByExample(example);
	}
	@Override
	public Nav getPre(Nav record) {
		Map<String, Object>  querys=new HashMap<String,Object>();
		querys.put(Page.LIMIT, 1);
		querys.put(Page.PAGE, 1);
		querys.put(Page.SORT, "-sort");
		querys.put("andDelEqualTo", false);
		querys.put("andIdNotEqualTo", record.getId());
		querys.put("andSortLessThanOrEqualTo", record.getSort());
		List<Nav> list=getList(querys);
		if(!ObjectUtils.isEmpty(list)) {
			return list.get(0);
		}
		return null;
	}
	@Override
	public Nav getNext(Nav record) {
		Map<String, Object>  querys=new HashMap<String,Object>();
		querys.put(Page.LIMIT, 1);
		querys.put(Page.PAGE, 1);
		querys.put(Page.SORT, "+sort");
		querys.put("andDelEqualTo", false);
		querys.put("andIdNotEqualTo", record.getId());
		querys.put("andSortGreaterThanOrEqualTo", record.getSort());
		List<Nav> list=getList(querys);
		if(!ObjectUtils.isEmpty(list)) {
			return list.get(0);
		}
		return null;
	}
}
