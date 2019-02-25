package com.xiang.userserver.impl;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.xiang.bean.vo.User;
import com.xiang.userserver.UserServer;
import com.xiang.userservice.UserService;

/**
 * @author xiang
 * @createDate 2018年12月20日 下午2:18:51
 */
@Service("userServer")
public class UserServerImpl implements UserServer{
	@Resource
	private UserService userService;
	@Override
	public User getUser(String userName) {
		com.xiang.bean.dto.User	user=userService.getUser(userName);
		User userVo = new User();
		BeanUtils.copyProperties(user, userVo);
		return userVo;
	}
}
