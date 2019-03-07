package com.xiang.userserver;

import java.util.List;
import java.util.Map;

import com.xiang.bean.vo.BaseListVo;
import com.xiang.bean.vo.UserVo;

public interface UserServer {
	public UserVo getUser(String userName);
	public List<UserVo> getList(Map<String,Object> querys);
	public BaseListVo<UserVo> queryList(Map<String,Object> querys);
}
