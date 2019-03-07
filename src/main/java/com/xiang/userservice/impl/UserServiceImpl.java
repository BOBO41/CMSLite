package com.xiang.userservice.impl;

import java.util.Date;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.xiang.bean.po.User;
import com.xiang.userservice.UserService;

/**
 * @author xiang
 * @createDate 2018年12月20日 下午2:18:51
 */
@Service("userService")
public class UserServiceImpl implements UserService{

	@Override
	@Cacheable(value = "userCache", sync = true, key="#userName")
	public User getUser(String userName) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setUserName("admin");
		user.setNick("管理员");
		user.setPassword("e10adc3949ba59abbe56e057f20f883e");
		user.setPermission("user");
		user.setRoles("admin");
		user.setAddTime(new Date());
		return user;
	}
}
