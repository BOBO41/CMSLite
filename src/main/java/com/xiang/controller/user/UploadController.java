package com.xiang.controller.user;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.google.common.io.Files;
import com.robert.vesta.service.intf.IdService;
import com.xiang.bean.vo.UploadVo;
import com.xiang.restserver.ErrorCodes;

import net.coobird.thumbnailator.Thumbnails;

/**
 * @author xiang
 *
 */
@RestController
@RequestMapping(value = "/upload")
public class UploadController {
	private static Set<String> ImageExts;
	private static Set<String> FileExts;
	static {
		ImageExts = new HashSet<String>();
		ImageExts.add("jpg");
		ImageExts.add("jpeg");
		ImageExts.add("png");
		FileExts = new HashSet<String>();
		FileExts.addAll(ImageExts);
		FileExts.add("zip");
		FileExts.add("rar");
	}
	public static String IMAGEDIR="/resources/";
	public static String FILEDIR="/file/";
	@Resource
	private IdService idService;
	@RequestMapping("/image")
	public Object image(HttpServletRequest request) throws IllegalStateException, IOException {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getServletContext());
		if (multipartResolver.isMultipart(request)) {
			List<UploadVo> list = new ArrayList<>();
			MultipartHttpServletRequest multiRequest =null;
			if(request instanceof ShiroHttpServletRequest) {
				ShiroHttpServletRequest shiroRequest = (ShiroHttpServletRequest) request;
				multiRequest=multipartResolver.resolveMultipart((HttpServletRequest) shiroRequest.getRequest());  
			}else {
				 multiRequest = (MultipartHttpServletRequest) request;
			}
			Iterator<String> iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				MultipartFile file = multiRequest.getFile(iter.next().toString());
				if (file != null) {
					String ext = Files.getFileExtension(file.getOriginalFilename()).toLowerCase();
					if (ImageExts.contains(ext)) {
						long id = idService.genId();
						String date=DateFormatUtils.format(new Date(), "yyyyMMdd");
						String url=IMAGEDIR +date+"/"+ id + "." + ext;
						String path = request.getServletContext().getRealPath(url);
						File saveFile=new File(path);
						if(!saveFile.getParentFile().exists()) {
							saveFile.getParentFile().mkdirs();
						}
						file.transferTo(saveFile);
						Thumbnails.of(saveFile).size(300, 300).outputFormat("jpg").toFile(saveFile.getAbsolutePath()+".300x300.jpg");
						Thumbnails.of(saveFile).size(100, 100).outputFormat("jpg").toFile(saveFile.getAbsolutePath()+".100x100.jpg");
						UploadVo vo = new UploadVo();
						vo.setUrl(url);
						vo.setFileName(file.getOriginalFilename());
						list.add(vo);
					}else {
						return ErrorCodes.UPLOAD_EXT_ERROR;
					}
				}
			}
			return list;
		}
		return ErrorCodes.UPLOAD_ERROR;
	}
	@RequestMapping("/file")
	public Object file(HttpServletRequest request,@RequestParam(name="dir",required=false) String dir) throws IllegalStateException, IOException {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getServletContext());
		if (multipartResolver.isMultipart(request)) {
			List<UploadVo> list = new ArrayList<>();
			MultipartHttpServletRequest multiRequest =null;
			if(request instanceof ShiroHttpServletRequest) {
				ShiroHttpServletRequest shiroRequest = (ShiroHttpServletRequest) request;
				multiRequest=multipartResolver.resolveMultipart((HttpServletRequest) shiroRequest.getRequest());  
			}else {
				 multiRequest = (MultipartHttpServletRequest) request;
			}
			Iterator<String> iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				MultipartFile file = multiRequest.getFile(iter.next().toString());
				if (file != null) {
					String ext = Files.getFileExtension(file.getOriginalFilename()).toLowerCase();
					if (FileExts.contains(ext)) {
						String url=null;
						if(!StringUtils.isEmpty(dir)) {
							 url=FILEDIR + dir+"/"+file.getOriginalFilename();
						}else {
							 url=FILEDIR + file.getOriginalFilename();
						}
						String path = request.getServletContext().getRealPath(url);
						File saveFile=new File(path);
						if(!saveFile.getParentFile().exists()) {
							saveFile.getParentFile().mkdirs();
						}
						file.transferTo(saveFile);
						UploadVo vo = new UploadVo();
						vo.setUrl(url);
						vo.setFileName(file.getOriginalFilename());
						list.add(vo);
					}else {
						return ErrorCodes.UPLOAD_EXT_ERROR;
					}
				}
			}
			return list;
		}
		return ErrorCodes.UPLOAD_ERROR;
	}
}
