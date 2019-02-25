package com.xiang.bean.dto;

import org.exolab.castor.types.DateTime;

public class BaseDto {
	private long id;
	private DateTime addTime;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public DateTime getAddTime() {
		return addTime;
	}
	public void setAddTime(DateTime addTime) {
		this.addTime = addTime;
	}
}
