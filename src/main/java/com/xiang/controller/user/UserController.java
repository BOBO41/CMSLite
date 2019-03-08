package com.xiang.controller.user;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
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
import com.xiang.restserver.APIException;
import com.xiang.restserver.ErrorCodes;
import com.xiang.userserver.JWTAuth;
import com.xiang.userserver.UserServer;

/**
 * @author xiang
 *
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
	@Resource
	private UserServer userServer;

	@RequestMapping(value = "/login",method =RequestMethod.GET)
	public Object login(@RequestParam("userName") String userName,
			@RequestParam("password") String password) {
		UserBo user = new UserBo();
		user.setUserName(userName);
		user.setPassword(password);
		return login(user);
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Object login(@RequestBody UserBo user) {
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getPassword());
		try {
			subject.login(token);
			if (subject.isAuthenticated()) {
				Map<String, String> claims = new HashMap<String, String>();
				claims.put(JWTAuth.USERNAME, user.getUserName());
				return JWTAuth.createToken(claims);
			}
		} catch (Exception ex) {
			throw new APIException(ErrorCodes.AUTH);
		}
		throw new APIException(ErrorCodes.AUTH);
	}
	@RequestMapping(value = "/userinfo", method = RequestMethod.GET)
	public Object getUserInfo(@RequestHeader HttpHeaders headers) {
		String token=headers.getFirst(JWTAuth.TOKENHEADER);
		Map<String, String> claims =JWTAuth.verifyToken(token);
		String userName=claims.get(JWTAuth.USERNAME);
		if(ObjectUtils.isEmpty(userName)) {
			throw new APIException(ErrorCodes.LOGIN);
		}else {
			return userServer.getUser(userName);
		}
	}
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Object add(@RequestBody UserBo user) {
		return userServer.addUser(user);
	}
	@RequestMapping(value = "/del", method = RequestMethod.POST)
	public Object del(@RequestBody long[] ids) {
		return ErrorCodes.OK;
	}
	@RequestMapping(value = "/undel", method = RequestMethod.POST)
	public Object unDel(@RequestBody long[] ids) {
		return ErrorCodes.OK;
	}
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Object update(@RequestBody UserBo user) {
		return ErrorCodes.OK;
	}
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Object list(@RequestBody(required=false) Map<String,Object> querys) {
		return userServer.queryList(querys);
	}
	
}
