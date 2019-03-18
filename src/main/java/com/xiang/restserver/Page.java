package com.xiang.restserver;

public class Page {
	public final static String DESC="desc";
	public final static String ASC="asc";
	public final static String PAGE="page";
	public final static String LIMIT="limit";
	public final static String SORT="sort";
	private Integer page;
	private Integer cursor;
	private Integer limit;
	private String sort;
	public Integer getCursor() {
		return cursor;
	}
	public void setCursor(Integer cursor) {
		this.cursor = cursor;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	public String getSort() {
		return sort;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
}
