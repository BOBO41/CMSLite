package com.xiang.bean.vo;

import java.util.ArrayList;
import java.util.List;

/**
* @author xiang
* @createDate 2018年12月20日 下午2:12:19
*/
public class CatalogVo extends BaseVo{
	private String name;
	private Long parentId;
	private Long leftId;
	private Long rightId;
	private List<CatalogVo> children;
	
	public void setChildren(List<CatalogVo> children) {
		this.children = children;
	}
	public List<CatalogVo> getChildren() {
		return children;
	}
	public String getName() {
		return name;
	}
	public Long getLeftId() {
		return leftId;
	}
	public void setLeftId(Long leftId) {
		this.leftId = leftId;
	}
	public Long getRightId() {
		return rightId;
	}
	public void setRightId(Long rightId) {
		this.rightId = rightId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
}
