package com.xiang.inventoryserver.exmapper;

import org.apache.ibatis.annotations.Param;

public interface ExBaseMapper {
	public void setDel(@Param("table") String table,@Param("ids") Long[] ids,@Param("del")Boolean del);
}
