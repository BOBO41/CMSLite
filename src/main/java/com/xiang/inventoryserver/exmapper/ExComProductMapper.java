package com.xiang.inventoryserver.exmapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xiang.bean.po.Block;
import com.xiang.bean.po.ComProduct;
import com.xiang.bean.po.ComProductExample;
import com.xiang.restserver.Page;

public interface ExComProductMapper {
	public int save(ComProduct record);
	public List<ComProduct> getList(@Param("example") ComProductExample example,@Param("page")Page page);
}
