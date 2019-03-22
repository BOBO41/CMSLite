package com.xiang.inventoryserver.exmapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xiang.bean.po.Product;
import com.xiang.bean.po.ProductExample;
import com.xiang.restserver.Page;

public interface ExProductMapper {
	public int save(Product record);
	public List<Product> getList(@Param("example") ProductExample example,@Param("page")Page page);
}
