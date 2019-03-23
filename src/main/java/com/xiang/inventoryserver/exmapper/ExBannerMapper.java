package com.xiang.inventoryserver.exmapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xiang.bean.po.Banner;
import com.xiang.bean.po.BannerExample;
import com.xiang.restserver.Page;

public interface ExBannerMapper {
	public int save(Banner record);
	public List<Banner> getList(@Param("example") BannerExample example,@Param("page")Page page);
}
