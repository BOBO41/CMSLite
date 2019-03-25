package com.xiang.bean.vo;

/**
 * @author xiang
 * @createDate 2018年12月20日 下午2:12:19
 */
public class NavVo extends BaseVo {
	private String title;

	private String imgUrl;

	private Integer sort;

	private String content;

	private Integer type;
	
	private Long[] catalogIds;
	
	private String link;
	
	private String payload;

	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Long[] getCatalogIds() {
		return catalogIds;
	}

	public void setCatalogIds(Long[] catalogIds) {
		this.catalogIds = catalogIds;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

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

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
