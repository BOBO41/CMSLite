package com.xiang.cms.vo;

public class FileInfoVo {
	private String name;
	private Boolean directory;
	private Long size;
	private Long lastModified;
	private String ext;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getDirectory() {
		return directory;
	}
	public void setDirectory(Boolean directory) {
		this.directory = directory;
	}
	public Long getSize() {
		return size;
	}
	public void setSize(Long size) {
		this.size = size;
	}
	public Long getLastModified() {
		return lastModified;
	}
	public void setLastModified(Long lastModified) {
		this.lastModified = lastModified;
	}
	public String getExt() {
		return ext;
	}
	public void setExt(String ext) {
		this.ext = ext;
	}
}
