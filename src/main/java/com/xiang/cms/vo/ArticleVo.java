package com.xiang.cms.vo;

import com.xiang.bean.vo.BaseVo;

/**
 * @author xiang
 * @createDate 2018年12月20日 下午2:12:19
 */
public class ArticleVo extends BaseVo {

	private String title;

	private String spec;

	private String imgUrl;
	
	private String content;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
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
}
