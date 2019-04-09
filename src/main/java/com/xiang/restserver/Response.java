package com.xiang.restserver;

/**
 * @author xiang
 * @createDate 2018年10月19日 上午10:51:15
 */
public class Response {
	public Response() {
	}

	public Response(Object data, ErrorCodes errorCode) {
		this.data = data;
		this.errorCode = errorCode.getErrorCode();
		this.message = errorCode.getErrorMessage();
		if (this.errorCode == ErrorCodes.OK.getErrorCode()) {
			success = true;
		} else {
			success = false;
		}
	}

	private Object data;
	private int errorCode;
	private String message;
	private boolean success;

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
}
