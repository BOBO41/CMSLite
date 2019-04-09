package com.xiang.productservice.impl;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.github.pagehelper.PageHelper;
import com.xiang.bean.po.Product;
import com.xiang.bean.po.ProductEx;
import com.xiang.bean.po.ProductExample;
import com.xiang.bean.po.ProductExample.Criteria;
import com.xiang.inventoryserver.mapper.ProductExMapper;
import com.xiang.inventoryserver.mapper.ProductMapper;
import com.xiang.inventoryserver.service.impl.BaseServiceImpl;
import com.xiang.productservice.ProductService;
import com.xiang.restserver.Page;

/**
 * @author xiang
 * @createDate 2018年12月20日 下午2:18:51
 */
@Service("productService")
public class ProductServiceImpl extends BaseServiceImpl<Product> implements ProductService {
	@Autowired
	private ProductMapper productMapper;
	@Autowired
	private ProductExMapper productExMapper;
	@Override
	public Product get(Long id) {
		return productMapper.selectByPrimaryKey(id);
	}


	@Override
	public void save(Product product) {
		productMapper.save(product);
	}
	
	@Override
	public void saveEx(ProductEx product) {
		productExMapper.save(product);
	}
	@Override
	public void update(Product product) {
		productMapper.updateByPrimaryKeySelective(product);
	}
	@Override
	public void updateEx(ProductEx product) {
		productExMapper.updateByPrimaryKeySelective(product);
	}
	@Override
	public List<Product> getList(Map<String, Object> querys) {
		Page page = this.getPage(querys);
		try {
			ProductExample example = getExample(querys);
			if(!Objects.isNull(page)) {
				if(!Objects.isNull(page.getSort())) {
					PageHelper.startPage(page.getPage(), page.getLimit(), page.getSort());
				}else {
					if(!Objects.isNull(page.getPage())) {
					PageHelper.startPage(page.getPage(), page.getLimit());
					}
				}
			}
			return productMapper.selectByExample(example);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private ProductExample getExample(Map<String, Object> querys){
		if (!ObjectUtils.isEmpty(querys)) {
			ProductExample example = new ProductExample();
			Criteria criteria = example.createCriteria();
			setCriteria(criteria,querys);
			return example;
		}
		return null;
	}
	@Override
	public Long getCount(Map<String, Object> querys) {
		ProductExample example = getExample(querys);
		return productMapper.countByExample(example);
	}


	@Override
	public ProductEx getEx(Long id) {
		// TODO Auto-generated method stub
		return productExMapper.selectByPrimaryKey(id);
	}

	
}
