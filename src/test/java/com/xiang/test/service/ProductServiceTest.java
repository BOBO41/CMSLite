package com.xiang.test.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.robert.vesta.service.intf.IdService;
import com.xiang.bean.po.Product;
import com.xiang.productservice.ProductService;
import com.xiang.test.BaseJunit4Test;

public class ProductServiceTest extends BaseJunit4Test{
	@Resource
	private ProductService productService;
	@Resource
	private IdService idService;
	@Test
	@Transactional
	@Rollback(true)
	public void add(){
		Product product=new Product();
		product.setId(idService.genId());
		productService.save(product);
	}
}
