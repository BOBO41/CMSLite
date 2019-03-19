package com.xiang.controller.user;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.http.HttpHeaders;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xiang.bean.bo.UserBo;
import com.xiang.bean.vo.UserVo;
import com.xiang.bean.vo.XAuthToken;
import com.xiang.restserver.APIException;
import com.xiang.restserver.ErrorCodes;
import com.xiang.restserver.LoginToken;
import com.xiang.userserver.JWTAuth;
import com.xiang.userserver.UserServer;

/**
 * @author xiang
 *
 */
@RestController
@RequestMapping(value = "/product")
public class ProductController {
	@Resource
	private UserServer userServer;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Object add(@RequestBody UserBo user) {
		return userServer.addUser(user);
	}
	@RequestMapping(value = "/del", method = RequestMethod.POST)
	public Object del(@RequestBody Long[] ids) {
		userServer.setDelById("user", ids, true);
		return ErrorCodes.OK;
	}
	@RequestMapping(value = "/undel", method = RequestMethod.POST)
	public Object unDel(@RequestBody Long[] ids) {
		userServer.setDelById("user", ids, false);
		return ErrorCodes.OK;
	}
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Object update(@RequestBody UserBo user) {
		userServer.updateUser(user);
		return ErrorCodes.OK;
	}
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Object list(@RequestBody(required=false) Map<String,Object> querys) {
		return userServer.queryList(querys);
	}
}
