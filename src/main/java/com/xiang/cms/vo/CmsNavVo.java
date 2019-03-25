package com.xiang.cms.vo;

import java.util.List;

public class CmsNavVo {
	private String title;

	private String imgUrl;

	private String content;
	
	private String link;
	
	private List<CmsNavVo> children;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public List<CmsNavVo> getChildren() {
		return children;
	}

	public void setChildren(List<CmsNavVo> children) {
		this.children = children;
	}
	
}
