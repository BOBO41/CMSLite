package com.xiang.bean.vo;

import java.util.Date;

public class BaseVo {
	private Long id;
	private Date addTime;
	private Boolean del;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	public Boolean getDel() {
		return del;
	}
	public void setDel(Boolean del) {
		this.del = del;
	}
}
