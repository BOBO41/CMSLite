package com.xiang.userserver.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import com.robert.vesta.service.intf.IdService;
import com.xiang.bean.bo.UserBo;
import com.xiang.bean.po.User;
import com.xiang.bean.vo.BaseListVo;
import com.xiang.bean.vo.UserVo;
import com.xiang.inventoryserver.server.impl.BaseServerImpl;
import com.xiang.restserver.APIException;
import com.xiang.restserver.ErrorCodes;
import com.xiang.userserver.UserServer;
import com.xiang.userservice.UserService;

/**
 * @author xiang
 * @createDate 2018年12月20日 下午2:18:51
 */
@Service("userServer")
public class UserServerImpl extends BaseServerImpl implements UserServer{
	@Resource
	private UserService userService;
	@Resource
	private IdService idService;
	@Override
	public UserVo getUser(String userName) {
		User user=userService.getUser(userName);
		return getUserVo(user);
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
		BeanUtils.copyProperties(userBo,user);
		if(!ObjectUtils.isEmpty(userBo.getRoles()))
		{
			user.setRoles(StringUtils.join(userBo.getRoles(),","));
		}
		return user;
	}
	@Override
	public List<UserVo> getList(Map<String, Object> querys) {
		List<User> users=userService.getList(querys);
		List<UserVo> list=new ArrayList<>();
		if(!ObjectUtils.isEmpty(users))
		{
			for(User user : users)
			{
				list.add(getUserVo(user));
			}
		}
		return list;
	}
	@Override
	public BaseListVo<UserVo> queryList(Map<String, Object> querys) {
		List<UserVo> list=getList(querys);
		BaseListVo<UserVo> baseListVo=new BaseListVo<UserVo>();
		baseListVo.setResult(list);
		baseListVo.setTotal(userService.getCount(querys));
		return baseListVo;
	}
	@Transactional
	@Override
	public UserVo addUser(UserBo userBo){
		try {
			User user =getUser(userBo);
			if(!Objects.isNull(userService.getUser(user.getUserName())))
			{
				throw new APIException(ErrorCodes.USER_EXIST);
			}
			user.setPassword(DigestUtils.md5Hex(userBo.getPassword()));
			long id=idService.genId();
			user.setId(id);
			user.setAddTime(new Date());
			userService.saveUser(user);
			return getUserVo(user);
		}catch(APIException ex)
		{
			throw ex;
		}catch(Exception ex)
		{
			ex.printStackTrace();
			throw new APIException(ErrorCodes.ERROR);
		}
	}
	@Transactional
	@Override
	public void updateUser(UserBo userBo) {
		try {
			User user =getUser(userBo);
			userService.update(user);
		}catch(APIException ex)
		{
			throw ex;
		}catch(Exception ex)
		{
			ex.printStackTrace();
			throw new APIException(ErrorCodes.ERROR);
		}
	}
	@Transactional
	@Override
	public void changePassword(Long id,String originPassword, String password) {
		User user=userService.getUser(id);
		originPassword=DigestUtils.md5Hex(originPassword);
		if(user.getPassword().equals(originPassword))
		{
			UserBo userBo=new UserBo();
			userBo.setId(user.getId());
			userBo.setPassword(DigestUtils.md5Hex(password));
			updateUser(userBo);
		}else
		{
			throw new APIException(ErrorCodes.PASSWORD);
		}
	}
}
