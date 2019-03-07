package com.xiang.userserver.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.xiang.bean.po.User;
import com.xiang.bean.vo.BaseListVo;
import com.xiang.bean.vo.UserVo;
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
	public UserVo getUser(String userName) {
		User user=userService.getUser(userName);
		return getUser(user);
	}
	@Override
	public List<UserVo> getList(Map<String, Object> querys) {
		List<UserVo> list=new ArrayList<>();
		list.add(getUser("admin"));
		return list;
	}
	private UserVo getUser(User user)
	{
		UserVo userVo = new UserVo();
		BeanUtils.copyProperties(user, userVo);
		userVo.setRoles(user.getRoles().split(","));
		return userVo;
	}
	@Override
	public BaseListVo<UserVo> queryList(Map<String, Object> querys) {
		List<UserVo> list=getList(querys);
		BaseListVo<UserVo> baseListVo=new BaseListVo<UserVo>();
		baseListVo.setResult(list);
		baseListVo.setTotal(10);
		return baseListVo;
	}
}
