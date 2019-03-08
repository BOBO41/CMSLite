package com.xiang.inventoryserver.mapper;

import org.apache.ibatis.annotations.Insert;

import com.xiang.bean.po.User;

public interface UserMapper {
	@Insert("insert into user(id,user_name,password,nick,roles,add_time,del) values(#{id},#{userName},#{password},#{nick},#{roles},#{addTime},#{del})")
	 public int saveUser(User user);
}
