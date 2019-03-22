package com.xiang.productservice;

import com.xiang.bean.po.Product;
import com.xiang.bean.po.ProductEx;
import com.xiang.inventoryserver.service.BaseService;

/**
* @author xiang
* @createDate 2018年12月20日 下午2:18:00
*/
public interface ProductService extends BaseService<Product>{
	public Product get(Long id);
	public ProductEx getEx(Long id);
	public void save(Product product);
	public void update(Product product);
	public void saveEx(ProductEx product);
	public void updateEx(ProductEx product);
}
