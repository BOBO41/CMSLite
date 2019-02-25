package com.xiang.userserver;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import com.alibaba.fastjson.JSONObject;
import com.xiang.restserver.ErrorCodes;
import com.xiang.restserver.Response;

public class UserFormAuthenticationFilter extends FormAuthenticationFilter {

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		System.out.println("onAccessDenied");
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json");
		Response res = new Response();
		ErrorCodes errorCodes = ErrorCodes.LOGIN;
		res.setSuccess(false);
		res.setErrorCode(errorCodes.getErrorCode());
		res.setMessage(errorCodes.getErrorMessage());
        httpServletResponse.getWriter().write(JSONObject.toJSON(res).toString());
		return false;
	}

	@Override
	protected boolean isLoginSubmission(ServletRequest request, ServletResponse response) {
		System.out.println("isLoginSubmission");
		return super.isLoginSubmission(request, response);
	}

	@Override
	protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request,
			ServletResponse response) throws Exception {
		System.out.println("onLoginSuccess");
		return super.onLoginSuccess(token, subject, request, response);
	}

	@Override
	protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request,
			ServletResponse response) {
		System.out.println("onLoginFailure");
		return super.onLoginFailure(token, e, request, response);
	}

	@Override
	protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
		System.out.println("executeLogin");
		return super.executeLogin(request, response);
	}

}
