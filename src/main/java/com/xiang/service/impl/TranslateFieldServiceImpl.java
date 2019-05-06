package com.xiang.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.xiang.bean.po.TranslateField;
import com.xiang.bean.po.TranslateFieldExample;
import com.xiang.bean.po.TranslateFieldExample.Criteria;
import com.xiang.mapper.TranslateFieldMapper;
import com.xiang.restserver.Page;
import com.xiang.service.TranslateFieldService;

@Service("translateFieldService")
public class TranslateFieldServiceImpl extends BaseServiceImpl<TranslateField> implements TranslateFieldService {
	@Autowired
	private TranslateFieldMapper translateFieldMapper;
	@Override
	public TranslateField get(Long id) {
		return translateFieldMapper.selectByPrimaryKey(id);
	}
	@Override
	public void save(TranslateField record) {
		translateFieldMapper.save(record);
	}

	@Override
	public void update(TranslateField record) {
		translateFieldMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<TranslateField> getList(Map<String, Object> querys) {
		Page page = this.getPage(querys);
		try {
			TranslateFieldExample example = getExample(querys);
			setPage(page);
			return translateFieldMapper.selectByExample(example);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private TranslateFieldExample getExample(Map<String, Object> querys){
		if (!ObjectUtils.isEmpty(querys)) {
			TranslateFieldExample example = new TranslateFieldExample();
			Criteria criteria = example.createCriteria();
			setCriteria(criteria,querys);
			return example;
		}
		return null;
	}
	@Override
	public Long getCount(Map<String, Object> querys) {
		TranslateFieldExample example = getExample(querys);
		return translateFieldMapper.countByExample(example);
	}
}
