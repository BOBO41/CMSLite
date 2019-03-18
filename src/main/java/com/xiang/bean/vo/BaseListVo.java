package com.xiang.bean.vo;

import java.util.List;
import java.util.Objects;

import com.xiang.restserver.Page;

public class BaseListVo<E> {
	private int total=0;
	private int page=1;
	private int limit=20;
	private List<E> result;
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public List<E> getResult() {
		return result;
	}
	public void setResult(List<E> result) {
		this.result = result;
	}
	public void setPage(Page pageBo) {
		if(!Objects.isNull(pageBo)) {
			if(!Objects.isNull(pageBo.getLimit())) {
				this.limit=pageBo.getLimit();
			}
			if(!Objects.isNull(pageBo.getPage())) {
				this.page=pageBo.getPage();
			}
		}
	}
}
