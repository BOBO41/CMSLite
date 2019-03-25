package com.xiang.restserver;

import java.util.concurrent.TimeoutException;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author xiang
 * @createDate 2018年10月19日 上午10:41:01
 */
@RestControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice<Object> {

	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		// TODO Auto-generated method stub
		return com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter.class.isAssignableFrom(converterType);
	}

	@ExceptionHandler(APIException.class)
	@ResponseBody
	public Object exceptionHander(APIException exception) {
		return exception.getErr();
	}

	@ExceptionHandler(TimeoutException.class)
	@ResponseBody
	public Object exceptionHander(TimeoutException exception) {
		return ErrorCodes.TIME_OUT;
	}

	@Override
	public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
			Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
			ServerHttpResponse response) {
		if (body == null)
			return null;
		Response res = new Response();
		ErrorCodes errorCodes = ErrorCodes.OK;
		res.setSuccess(true);
		if (body instanceof ErrorCodes) {
			errorCodes = (ErrorCodes) body;
			if (ErrorCodes.OK != errorCodes)
				res.setSuccess(false);
		}
		else {
			res.setData(body);
		}
		res.setErrorCode(errorCodes.getErrorCode());
		res.setMessage(errorCodes.getErrorMessage());
		return res;
	}
}
