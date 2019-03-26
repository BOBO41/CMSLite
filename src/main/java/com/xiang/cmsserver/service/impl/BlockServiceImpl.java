package com.xiang.cmsserver.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.xiang.bean.po.Block;
import com.xiang.bean.po.BlockExample;
import com.xiang.bean.po.BlockExample.Criteria;
import com.xiang.cmsserver.service.BlockService;
import com.xiang.inventoryserver.mapper.BlockMapper;
import com.xiang.inventoryserver.service.impl.BaseServiceImpl;
import com.xiang.restserver.Page;

/**
 * @author xiang
 * @createDate 2018年12月20日 下午2:18:51
 */
@Service("blockService")
public class BlockServiceImpl extends BaseServiceImpl<Block> implements BlockService {
	@Autowired
	private BlockMapper blockMapper;
	@Override
	public Block get(Long id) {
		return blockMapper.selectByPrimaryKey(id);
	}
	@Override
	public void save(Block record) {
		blockMapper.save(record);
	}

	@Override
	public void update(Block record) {
		blockMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<Block> getList(Map<String, Object> querys) {
		Page page = this.getPage(querys);
		try {
			BlockExample example = getExample(querys);
			return blockMapper.getList(example, page);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private BlockExample getExample(Map<String, Object> querys){
		if (!ObjectUtils.isEmpty(querys)) {
			BlockExample example = new BlockExample();
			Criteria criteria = example.createCriteria();
			setCriteria(criteria,querys);
			return example;
		}
		return null;
	}
	@Override
	public Long getCount(Map<String, Object> querys) {
		BlockExample example = getExample(querys);
		return blockMapper.countByExample(example);
	}
}
