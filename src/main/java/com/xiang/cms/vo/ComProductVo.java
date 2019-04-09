package com.xiang.cms.vo;

import java.util.List;

import com.xiang.bean.vo.BaseVo;
import com.xiang.bean.vo.ProductVo;

/**
 * @author xiang
 * @createDate 2018年12月20日 下午2:12:19
 */
public class ComProductVo extends BaseVo {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	private Long[] productIds;

	public Long[] getProductIds() {
		return productIds;
	}

	public void setProductIds(Long[] productIds) {
		this.productIds = productIds;
	}
	
	private List<ProductVo> products;

	public List<ProductVo> getProducts() {
		return products;
	}

	public void setProducts(List<ProductVo> products) {
		this.products = products;
	}

}
