package com.xiang.userserver.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.robert.vesta.service.intf.IdService;
import com.xiang.bean.bo.UserBo;
import com.xiang.bean.po.User;
import com.xiang.bean.vo.BaseListVo;
import com.xiang.bean.vo.UserVo;
import com.xiang.restserver.APIException;
import com.xiang.restserver.ErrorCodes;
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
	@Resource
	private IdService idService;
	@Override
	public UserVo getUser(String userName) {
		User user=userService.getUser(userName);
		return getUserVo(user);
	}
	@Override
	public List<UserVo> getList(Map<String, Object> querys) {
		List<UserVo> list=new ArrayList<>();
		list.add(getUser("admin"));
		return list;
	}
	private UserVo getUserVo(User user)
	{
		UserVo userVo = new UserVo();
		BeanUtils.copyProperties(user, userVo);
		userVo.setRoles(user.getRoles().split(","));
		return userVo;
	}
	private User getUser(UserBo userBo)
	{
		User user = new User();
		BeanUtils.copyProperties( userBo,user);
		user.setRoles(StringUtils.join(userBo.getRoles(),","));
		return user;
	}
	@Override
	public BaseListVo<UserVo> queryList(Map<String, Object> querys) {
		List<UserVo> list=getList(querys);
		BaseListVo<UserVo> baseListVo=new BaseListVo<UserVo>();
		baseListVo.setResult(list);
		baseListVo.setTotal(10);
		return baseListVo;
	}
	@Transactional
	@Override
	public UserVo addUser(UserBo userBo) {
		try {
			User user =getUser(userBo);
			user.setPassword(DigestUtils.md5Hex(userBo.getPassword()));
			long id=idService.genId();
			user.setId(id);
			user.setAddTime(new Date());
			userService.saveUser(user);
			return getUserVo(user);
		}catch(Exception ex)
		{
			ex.printStackTrace();
			throw new APIException(ErrorCodes.ERROR);
		}
		
	}
}
