package com.xiang.bean.vo;

import java.util.List;

public class BaseListVo<E> {
	private Long total;
	private int page=1;
	private int limit=20;
	private List<E> result;
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
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
}
