package com.xiang.inventoryserver.exmapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xiang.bean.po.Block;
import com.xiang.bean.po.BlockExample;
import com.xiang.restserver.Page;

public interface ExBlockMapper {
	public int save(Block record);
	public List<Block> getList(@Param("example") BlockExample example,@Param("page")Page page);
}
