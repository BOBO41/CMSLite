package com.xiang.restserver;

/**
 * @author xiang
 * @createDate 2018年10月19日 上午11:00:47
 */
public enum ErrorCodes {
	OK(10000, ""), ERROR_PARAM(10001, "参数错误"), TIME_OUT(10002, "请求交易所API超时"), LOGIN(10003, "请先登录,再进行操作!"),
	ERROR(10004, "系统错误"), AUTH(10005, "账号或者密码错误!"), FORBIDDEN(10006, "无权限操作!"),
	USER_NO_EXIST(20001, "账号不存在");
	private int errorCode;
	private String errorMessage;

	public static ErrorCodes createErrorCode(String errorMessage) {
		ERROR.setErrorMessage(errorMessage);
		return ERROR;
	}

	private ErrorCodes(int errorCode, String errorMessage) {

		this.errorCode = errorCode;

		this.errorMessage = errorMessage;

	}

	public int getErrorCode() {

		return errorCode;

	}

	public void setErrorCode(int errorCode) {

		this.errorCode = errorCode;

	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {

		this.errorMessage = errorMessage;

	}
}
