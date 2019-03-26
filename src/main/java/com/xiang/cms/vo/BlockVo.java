package com.xiang.cms.vo;

import com.xiang.bean.vo.BaseVo;

/**
 * @author xiang
 * @createDate 2018年12月20日 下午2:12:19
 */
public class BlockVo extends BaseVo {

	private String name;

	private String description;

	private String content;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
