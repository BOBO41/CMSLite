package com.xiang.cmsserver.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.xiang.bean.po.Message;
import com.xiang.bean.po.MessageExample;
import com.xiang.bean.po.MessageExample.Criteria;
import com.xiang.cmsserver.service.MessageService;
import com.xiang.inventoryserver.mapper.MessageMapper;
import com.xiang.inventoryserver.service.impl.BaseServiceImpl;
import com.xiang.restserver.Page;

/**
 * @author xiang
 * @createDate 2018年12月20日 下午2:18:51
 */
@Service("messageService")
public class MessageServiceImpl extends BaseServiceImpl<Message> implements MessageService {
	@Autowired
	private MessageMapper messageMapper;
	@Override
	public Message get(Long id) {
		return messageMapper.selectByPrimaryKey(id);
	}
	@Override
	public void save(Message record) {
		messageMapper.save(record);
	}

	@Override
	public void update(Message record) {
		messageMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<Message> getList(Map<String, Object> querys) {
		Page page = this.getPage(querys);
		try {
			MessageExample example = getExample(querys);
			setPage(page);
			return messageMapper.selectByExample(example);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private MessageExample getExample(Map<String, Object> querys){
		if (!ObjectUtils.isEmpty(querys)) {
			MessageExample example = new MessageExample();
			Criteria criteria = example.createCriteria();
			setCriteria(criteria,querys);
			return example;
		}
		return null;
	}
	@Override
	public Long getCount(Map<String, Object> querys) {
		MessageExample example = getExample(querys);
		return messageMapper.countByExample(example);
	}
}
