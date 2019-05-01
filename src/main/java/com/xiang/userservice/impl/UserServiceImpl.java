package com.xiang.userservice.impl;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.xiang.bean.po.User;
import com.xiang.bean.po.UserExample;
import com.xiang.bean.po.UserExample.Criteria;
import com.xiang.mapper.UserMapper;
import com.xiang.restserver.APIException;
import com.xiang.restserver.ErrorCodes;
import com.xiang.restserver.Page;
import com.xiang.service.impl.BaseServiceImpl;
import com.xiang.userservice.UserService;

/**
 * @author xiang
 * @createDate 2018年12月20日 下午2:18:51
 */
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
	@Autowired
	private UserMapper userMapper;

	@Override
	@Cacheable(value = "userCache", sync = true, key = "#userName")
	public User getUser(String userName) {
		UserExample userExample = new UserExample();
		userExample.createCriteria().andUserNameEqualTo(userName);
		List<User> list = userMapper.selectByExample(userExample);
		if (!ObjectUtils.isEmpty(list)) {
			return list.get(0);
		}
		throw new APIException(ErrorCodes.USER_NO_EXIST);
	}

	@Override
	public void saveUser(User user) {
		userMapper.save(user);
	}

	@Override
	public List<User> getList(Map<String, Object> querys) {
		Page page = this.getPage(querys);
		UserExample example = getExample(querys);
		return userMapper.getList(example, page);
	}

	@Override
	public Long getCount(Map<String, Object> querys) {
		UserExample example = getExample(querys);
		return userMapper.countByExample(example);
	}
	
	private UserExample getExample(Map<String, Object> querys){
		if (!ObjectUtils.isEmpty(querys)) {
			UserExample example = new UserExample();
			Criteria criteria = example.createCriteria();
			setCriteria(criteria,querys);
			return example;
		}
		return null;
	}

	@Override
	public void update(User user) {
		userMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public User getUser(Long id) {
		User user = userMapper.selectByPrimaryKey(id);
		if (Objects.isNull(user))
			throw new APIException(ErrorCodes.USER_NO_EXIST);
		return user;
	}

	@Override
	public boolean existUser(String userName) {
		try {
			getUser(userName);
		} catch (APIException ex) {
			if (ex.getErr() == ErrorCodes.USER_NO_EXIST) {
				return false;
			} else {
				throw ex;
			}
		}
		return true;
	}
}
