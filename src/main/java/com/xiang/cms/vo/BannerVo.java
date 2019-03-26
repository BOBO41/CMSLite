package com.xiang.cms.vo;

import com.xiang.bean.vo.BaseVo;

/**
 * @author xiang
 * @createDate 2018年12月20日 下午2:12:19
 */
public class BannerVo extends BaseVo {

	private String title;

	private String content;

	private String imgUrl;

	private Integer sort;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

}
