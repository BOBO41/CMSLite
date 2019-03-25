package com.xiang.inventoryserver.exmapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xiang.bean.po.Nav;
import com.xiang.bean.po.NavExample;
import com.xiang.restserver.Page;

public interface ExNavMapper {
	public int save(Nav record);
	public List<Nav> getList(@Param("example") NavExample example,@Param("page")Page page);
}
