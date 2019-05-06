package com.xiang.server.impl;
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
import com.xiang.bean.bo.TranslateFieldBo;
import com.xiang.bean.po.TranslateField;
import com.xiang.bean.vo.BaseListVo;
import com.xiang.bean.vo.TranslateFieldVo;
import com.xiang.restserver.Page;
import com.xiang.server.TranslateFieldServer;
import com.xiang.service.TranslateFieldService;
/**
 * @author xiang
 * @createDate 2019-05-04 23:29:56
 */
@Service("translateFieldServer")
public class TranslateFieldServerImpl extends BaseServerImpl implements TranslateFieldServer {
	@Resource
	private IdService idService;
	@Resource
	private TranslateFieldService translateFieldService;
	@Transactional
	@Override
	public TranslateFieldVo add(TranslateFieldBo bo) {
		TranslateField po = getPo(bo);
		long id = idService.genId();
		po.setId(id);
		po.setAddTime(new Date());
		translateFieldService.save(po);
		return getVo(po);
	}

	@Transactional
	@Override
	public TranslateFieldVo update(TranslateFieldBo bo) {
		TranslateField po = getPo(bo);
		translateFieldService.update(po);
		return getVo(po);
	}

	private TranslateField getPo(TranslateFieldBo bo) {
		TranslateField po = new TranslateField();
		BeanUtils.copyProperties(bo, po);
		return po;
	}

	private TranslateFieldVo getVo(TranslateField po) {
		TranslateFieldVo vo = new TranslateFieldVo();
		BeanUtils.copyProperties(po, vo);
		return vo;
	}

	@Override
	public List<TranslateFieldVo> getList(Map<String, Object> querys) {
		List<TranslateField> poList = translateFieldService.getList(querys);
		List<TranslateFieldVo> list = new ArrayList<>();
		if (!ObjectUtils.isEmpty(poList)) {
			for (TranslateField po : poList) {
				list.add(getVo(po));
			}
		}
		return list;
	}

	@Override
	public BaseListVo<TranslateFieldVo> queryList(Map<String, Object> querys) {
		List<TranslateFieldVo> list = getList(querys);
		Page page = translateFieldService.getPage(querys);
		BaseListVo<TranslateFieldVo> baseListVo = new BaseListVo<TranslateFieldVo>();
		baseListVo.setPage(page);
		baseListVo.setResult(list);
		if (!ObjectUtils.isEmpty(list)) {
			baseListVo.setTotal(translateFieldService.getCount(querys).intValue());
		}
		return baseListVo;
	}

	@Override
	public TranslateFieldVo get(Long id) {
		TranslateField po = translateFieldService.get(id);
		TranslateFieldVo vo = this.getVo(po);
		return vo;
	}
	@Override
	public TranslateFieldBo getBo(TranslateFieldVo vo) {
		TranslateFieldBo bo = new TranslateFieldBo();
		BeanUtils.copyProperties(vo, bo);
		return bo;
	}
	@Override
	public TranslateFieldVo getVo(TranslateFieldBo bo) {
		TranslateFieldVo vo = new TranslateFieldVo();
		BeanUtils.copyProperties(bo, vo);
		return vo;
	}
	@Override
	public List<TranslateFieldVo> getList() {
		Map<String, Object>  querys=new HashMap<String,Object>();
		querys.put(Page.SORT, "-addTime");
		querys.put("andDelEqualTo", false);
		return getList(querys);
	}

}
