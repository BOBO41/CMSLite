package com.xiang.bean.bo;

import com.xiang.bean.vo.CatalogVo;

public class CatalogBo extends CatalogVo{
	private Long[] parentIds;

	public Long[] getParentIds() {
		return parentIds;
	}

	public void setParentIds(Long[] parentIds) {
		this.parentIds = parentIds;
	}
	
}
