package com.xiang.cmsserver.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.xiang.bean.po.Banner;
import com.xiang.bean.po.ComProduct;
import com.xiang.bean.po.ComProductExample;
import com.xiang.bean.po.ComProductExample.Criteria;
import com.xiang.cmsserver.service.ComProductService;
import com.xiang.inventoryserver.mapper.ComProductMapper;
import com.xiang.inventoryserver.service.impl.BaseServiceImpl;
import com.xiang.restserver.Page;

/**
 * @author xiang
 * @createDate 2018年12月20日 下午2:18:51
 */
@Service("comProductService")
public class ComProductServiceImpl extends BaseServiceImpl<ComProduct> implements ComProductService {
	@Autowired
	private ComProductMapper comProductMapper;
	@Override
	public ComProduct get(Long id) {
		return comProductMapper.selectByPrimaryKey(id);
	}
	@Override
	public void save(ComProduct record) {
		comProductMapper.save(record);
	}

	@Override
	public void update(ComProduct record) {
		comProductMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<ComProduct> getList(Map<String, Object> querys) {
		Page page = this.getPage(querys);
		try {
			ComProductExample example = getExample(querys);
			return comProductMapper.getList(example, page);
		} catch (Exception e) {
			// TODO Auto-generated catch comProduct
			e.printStackTrace();
		}
		return null;
	}

	private ComProductExample getExample(Map<String, Object> querys){
		if (!ObjectUtils.isEmpty(querys)) {
			ComProductExample example = new ComProductExample();
			Criteria criteria = example.createCriteria();
			setCriteria(criteria,querys);
			return example;
		}
		return null;
	}
	@Override
	public Long getCount(Map<String, Object> querys) {
		ComProductExample example = getExample(querys);
		return comProductMapper.countByExample(example);
	}
	@Override
	public ComProduct getPre(ComProduct record) {
		Map<String, Object>  querys=new HashMap<String,Object>();
		querys.put(Page.LIMIT, 1);
		querys.put(Page.PAGE, 1);
		querys.put(Page.SORT, "-sort");
		querys.put("andDelEqualTo", false);
		querys.put("andIdNotEqualTo", record.getId());
		querys.put("andSortLessThanOrEqualTo", record.getSort());
		List<ComProduct> list=getList(querys);
		if(!ObjectUtils.isEmpty(list)) {
			return list.get(0);
		}
		return null;
	}
	@Override
	public ComProduct getNext(ComProduct record) {
		Map<String, Object>  querys=new HashMap<String,Object>();
		querys.put(Page.LIMIT, 1);
		querys.put(Page.PAGE, 1);
		querys.put(Page.SORT, "+sort");
		querys.put("andDelEqualTo", false);
		querys.put("andIdNotEqualTo", record.getId());
		querys.put("andSortGreaterThanOrEqualTo", record.getSort());
		List<ComProduct> list=getList(querys);
		if(!ObjectUtils.isEmpty(list)) {
			return list.get(0);
		}
		return null;
	}
}
