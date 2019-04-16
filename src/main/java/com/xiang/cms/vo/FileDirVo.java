package com.xiang.cms.vo;

import java.util.List;

public class FileDirVo {
	private String dir;
	List<FileInfoVo> files;
	public String getDir() {
		return dir;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
	public List<FileInfoVo> getFiles() {
		return files;
	}
	public void setFiles(List<FileInfoVo> files) {
		this.files = files;
	}
}
