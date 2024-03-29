package com.xiang.restserver;

/**
 * @author xiang
 * @createDate 2018年10月19日 上午11:00:47
 */
public enum ErrorCodes {
	OK(10000, ""), ERROR_PARAM(10001, "参数错误"), TIME_OUT(10002, "请求交易所API超时"), LOGIN(10003, "请先登录,再进行操作!"),
	ERROR(10004, "系统错误"), FORBIDDEN(10006, "无权限操作!"),ADD_ERROR(10007, "添加失败，请重试"),NONSUPPORT(10008, "不支持此操作"),
	USER_NO_EXIST(20001, "账号不存在"),USER_EXIST(20002, "账号已存在，不可重复"),PASSWORD(20003, "原密码不正确"), AUTH(20004, "账号或者密码错误!"),
	SORT_TOP(30001, "已经是顶部"),SORT_ERROR(30002, "排序失败"),SORT_BOTTOM(30003, "已经是底部"),CATALOG_UPDATE_PARENT(30004, "父级不可选择当前分类及所属下级"),
	UPLOAD_ERROR(40001,"文件上传失败"),UPLOAD_EXT_ERROR(40002,"文件上传失败，不支持的文件类型"),
	TRANSALE_ERROR(50001,"国际化翻译失败")
	;
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
