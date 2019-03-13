package com.xiang.userservice;

import com.xiang.bean.po.User;
import com.xiang.inventoryserver.service.BaseService;

/**
* @author xiang
* @createDate 2018年12月20日 下午2:18:00
*/
public interface UserService extends BaseService<User>{
	public User getUser(Long id);
	public User getUser(String userName);
	public boolean existUser(String userName);
	public void saveUser(User user);
	public void update(User user);
}
