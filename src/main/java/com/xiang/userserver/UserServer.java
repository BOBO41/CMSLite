package com.xiang.userserver;

import java.util.List;
import java.util.Map;

import com.xiang.bean.bo.UserBo;
import com.xiang.bean.vo.BaseListVo;
import com.xiang.bean.vo.UserVo;
import com.xiang.server.BaseServer;

public interface UserServer extends BaseServer{
	public UserVo addUser(UserBo userBo);
	public UserVo getUser(String userName);
	public List<UserVo> getList(Map<String,Object> querys);
	public BaseListVo<UserVo> queryList(Map<String,Object> querys);
	public void updateUser(UserBo userBo);
	public void changePassword(Long id,String originPassword,String password);
}
