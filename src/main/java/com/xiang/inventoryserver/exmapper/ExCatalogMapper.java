package com.xiang.inventoryserver.exmapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xiang.bean.po.Catalog;
import com.xiang.bean.po.CatalogExample;
import com.xiang.restserver.Page;

public interface ExCatalogMapper {
	public int save(Catalog record);
	public List<Catalog> getList(@Param("example") CatalogExample example,@Param("page")Page page);
	public List<Catalog> getChilds(@Param("ids")Long[] ids,@Param("del")Boolean del);
	public int updateRight(@Param("id")Long id,@Param("orignRightId")Long orignRightId,@Param("rightId")Long rightId);
	public int updateLeft(@Param("id")Long id,@Param("orignLeftId")Long orignLeftId,@Param("leftId")Long leftId);
}
