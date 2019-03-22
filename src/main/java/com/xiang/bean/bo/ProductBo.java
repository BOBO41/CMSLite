package com.xiang.bean.bo;

import com.xiang.bean.vo.ProductVo;

public class ProductBo extends ProductVo{
	private Long[] catalogIds;

	public Long[] getCatalogIds() {
		return catalogIds;
	}

	public void setCatalogIds(Long[] catalogIds) {
		this.catalogIds = catalogIds;
	}
	
}
