package com.xiang.inventoryserver.exmapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xiang.bean.po.User;
import com.xiang.bean.po.UserExample;
import com.xiang.restserver.Page;

public interface ExUserMapper {
	int save(User record);
	List<User> getList(@Param("example") UserExample example,@Param("page")Page page);
}
