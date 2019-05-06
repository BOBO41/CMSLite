package com.xiang.server;
import java.util.List;
import java.util.Map;

import com.xiang.bean.bo.TranslateFieldBo;
import com.xiang.bean.vo.BaseListVo;
import com.xiang.bean.vo.TranslateFieldVo;
public interface TranslateFieldServer extends BaseServer{
	public TranslateFieldVo add(TranslateFieldBo bo);
	public TranslateFieldVo update(TranslateFieldBo bo);
	public List<TranslateFieldVo> getList();
	public List<TranslateFieldVo> getList(Map<String,Object> querys);
	public BaseListVo<TranslateFieldVo> queryList(Map<String,Object> querys);
	public TranslateFieldVo get(Long id);
	public TranslateFieldVo getVo(TranslateFieldBo bo);
	public TranslateFieldBo getBo(TranslateFieldVo vo);
}
