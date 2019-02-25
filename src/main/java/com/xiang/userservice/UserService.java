package com.xiang.userservice;

import com.xiang.bean.dto.User;

/**
* @author xiang
* @createDate 2018年12月20日 下午2:18:00
*/
public interface UserService {
	public User getUser(String userName);
}
