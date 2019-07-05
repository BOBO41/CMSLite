package com.xiang.controller.cms;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.io.Files;
import com.xiang.bean.vo.FileDirVo;
import com.xiang.bean.vo.FileInfoVo;
import com.xiang.controller.core.UploadController;
import com.xiang.restserver.ErrorCodes;
import com.xiang.utils.Handle;

/**
 * @author xiang
 *
 */
@RestController
@RequestMapping(value = "/cms/file")
public class FileController {
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Object list(HttpServletRequest request,@RequestParam(name="dir",required=false) String dir) {
		String url=null;
		if(!StringUtils.isEmpty(dir)) {
			 url=UploadController.FILEDIR + dir;
		}else {
			 url=UploadController.FILEDIR;
		}
		List<FileInfoVo> list=new ArrayList<FileInfoVo>();
		String path = request.getServletContext().getRealPath(url);
		File file=new File(path);
		if(!Handle.vaildateFile(path)) {
			return ErrorCodes.ERROR_PARAM;
		}
		if(file.isDirectory()) {
			File[] fs=file.listFiles();
			if(!ObjectUtils.isEmpty(fs)) {
				for(File f :fs) {
					FileInfoVo vo=new FileInfoVo();
					vo.setDirectory(f.isDirectory());
					vo.setLastModified(f.lastModified());
					vo.setName(f.getName());
					vo.setSize(f.length());
					if(f.isFile()) {
						vo.setExt(Files.getFileExtension(f.getName()).toLowerCase());
					}
					list.add(vo);
				}
			}
		}
		FileDirVo vo=new FileDirVo();
		vo.setDir(dir);
		vo.setFiles(list);
		return vo;
	}
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public Object create(HttpServletRequest request,@RequestParam(name="dir",required=false) String dir,@RequestParam(name="createDir") String createDir) {
		String url=null;
		if(!StringUtils.isEmpty(dir)) {
			 url=UploadController.FILEDIR + dir;
		}else {
			 url=UploadController.FILEDIR;
		}
		String createPath = request.getServletContext().getRealPath(url+"/"+createDir);
		if(!Handle.vaildateFile(createPath)) {
			return ErrorCodes.ERROR_PARAM;
		}
		File create=new File(createPath);
		if(!create.exists()) {
			if(!create.mkdirs()) {
				
			}
		}
		String path = request.getServletContext().getRealPath(url);
		List<FileInfoVo> list=new ArrayList<FileInfoVo>();
		File file=new File(path);
		if(file.isDirectory()) {
			File[] fs=file.listFiles();
			if(!ObjectUtils.isEmpty(fs)) {
				for(File f :fs) {
					FileInfoVo vo=new FileInfoVo();
					vo.setDirectory(f.isDirectory());
					vo.setLastModified(f.lastModified());
					vo.setName(f.getName());
					vo.setSize(f.length());
					if(f.isFile()) {
						vo.setExt(Files.getFileExtension(f.getName()).toLowerCase());
					}
					list.add(vo);
				}
			}
		}
		FileDirVo vo=new FileDirVo();
		vo.setDir(dir);
		vo.setFiles(list);
		return vo;
	}
}
