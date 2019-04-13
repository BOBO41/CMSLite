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
import com.xiang.bean.bo.MessageBo;
import com.xiang.bean.po.Message;
import com.xiang.bean.vo.BaseListVo;
import com.xiang.cms.vo.MessageVo;
import com.xiang.cmsserver.server.MessageServer;
import com.xiang.cmsserver.service.MessageService;
import com.xiang.inventoryserver.server.impl.BaseServerImpl;
import com.xiang.restserver.Page;

/**
 * @author xiang
 * @createDate 2018年12月20日 下午2:18:51
 */
@Service("messageServer")
public class MessageServerImpl extends BaseServerImpl implements MessageServer {
	@Resource
	private IdService idService;
	@Resource
	private MessageService messageService;
	@Transactional
	@Override
	public MessageVo add(MessageBo bo) {
		Message po = getPo(bo);
		long id = idService.genId();
		po.setId(id);
		po.setAddTime(new Date());
		messageService.save(po);
		return getVo(po);
	}

	@Transactional
	@Override
	public MessageVo update(MessageBo bo) {
		Message po = getPo(bo);
		messageService.update(po);
		return getVo(po);
	}

	private Message getPo(MessageBo bo) {
		Message po = new Message();
		BeanUtils.copyProperties(bo, po);
		return po;
	}

	private MessageVo getVo(Message po) {
		MessageVo vo = new MessageVo();
		BeanUtils.copyProperties(po, vo);
		return vo;
	}

	@Override
	public List<MessageVo> getList(Map<String, Object> querys) {
		List<Message> poList = messageService.getList(querys);
		List<MessageVo> list = new ArrayList<>();
		if (!ObjectUtils.isEmpty(poList)) {
			for (Message po : poList) {
				list.add(getVo(po));
			}
		}
		return list;
	}

	@Override
	public BaseListVo<MessageVo> queryList(Map<String, Object> querys) {
		List<MessageVo> list = getList(querys);
		Page page = messageService.getPage(querys);
		BaseListVo<MessageVo> baseListVo = new BaseListVo<MessageVo>();
		baseListVo.setPage(page);
		baseListVo.setResult(list);
		if (!ObjectUtils.isEmpty(list)) {
			baseListVo.setTotal(messageService.getCount(querys).intValue());
		}
		return baseListVo;
	}

	@Override
	public MessageVo get(Long id) {
		Message po = messageService.get(id);
		MessageVo vo = this.getVo(po);
		return vo;
	}

	@Override
	public List<MessageVo> getList() {
		Map<String, Object>  querys=new HashMap<String,Object>();
		querys.put(Page.SORT, "+sort");
		querys.put("andDelEqualTo", false);
		return getList(querys);
	}

}
