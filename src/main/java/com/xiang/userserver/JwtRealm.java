package com.xiang.userserver;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.mysql.jdbc.StringUtils;
import com.xiang.bean.dto.User;
import com.xiang.userservice.UserService;

/**
 * @author xiang
 * @createDate 2018年12月20日 上午11:56:45
 */
public class JwtRealm extends AuthorizingRealm {
	@Resource
	private UserService userService;
	/*
	 * 认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken principals) {
		 JWTToken jwtToken = (JWTToken) principals;
		 String token=jwtToken.getToken();
		 SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(token, token, "jwtRealm");
	        return authenticationInfo;
	}

	@Override
	public boolean supports(AuthenticationToken token) {
		return token instanceof JWTToken;
	}

	/*
	 * 权限
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("user权限doGetAuthorizationInfo");
		String token = (String) super.getAvailablePrincipal(principals);
		Map<String, String> claims =JWTAuth.verifyToken(token);
		String userName=claims.get(JWTAuth.USERNAME);
		User user = userService.getUser(userName);
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		if (!StringUtils.isNullOrEmpty(user.getRoles())) {
			Set<String> roles = new HashSet<>(Arrays.asList(user.getRoles().split(",")));
			simpleAuthorizationInfo.setRoles(roles);
		}
		if (!StringUtils.isNullOrEmpty(user.getPermission())) {
			Set<String> permission = new HashSet<>(Arrays.asList(user.getPermission().split(",")));
			simpleAuthorizationInfo.addStringPermissions(permission);
		}
		return simpleAuthorizationInfo;
	
	}
}