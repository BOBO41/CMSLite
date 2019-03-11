package com.xiang.userserver;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.util.ObjectUtils;

import com.mysql.jdbc.StringUtils;
import com.xiang.bean.po.User;
import com.xiang.restserver.APIException;
import com.xiang.restserver.ErrorCodes;
import com.xiang.userservice.UserService;

/**
 * @author xiang
 * @createDate 2018年12月20日 上午11:56:45
 */
public class UserRealm extends AuthorizingRealm {

	@Resource
	private UserService userService;

	/*
	 * 认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken principals) {
		System.out.println("user认证doGetAuthenticationInfo");
		UsernamePasswordToken token = (UsernamePasswordToken) principals;
		String userName = token.getUsername();
		User user = userService.getUser(userName);
		if (ObjectUtils.isEmpty(user)) {
			throw new APIException(ErrorCodes.AUTH);
		}
		return new SimpleAuthenticationInfo(userName, user.getPassword(), "userRealm");
	}

	@Override
	public boolean supports(AuthenticationToken token) {
		return token instanceof UsernamePasswordToken;
	}

	/*
	 * 权限
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("user权限doGetAuthorizationInfo");
		String userName = (String) super.getAvailablePrincipal(principals);
		User user = userService.getUser(userName);
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		if (!StringUtils.isNullOrEmpty(user.getRoles())) {
			Set<String> roles = new HashSet<>(Arrays.asList(user.getRoles().split(",")));
			simpleAuthorizationInfo.setRoles(roles);
		}
//		if (!StringUtils.isNullOrEmpty(user.getPermission())) {
//			Set<String> permission = new HashSet<>(Arrays.asList(user.getPermission().split(",")));
//			simpleAuthorizationInfo.addStringPermissions(permission);
//		}
		return simpleAuthorizationInfo;
	}
}