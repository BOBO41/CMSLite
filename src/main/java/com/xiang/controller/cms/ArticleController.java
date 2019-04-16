package com.xiang.controller.cms;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xiang.bean.bo.ArticleBo;
import com.xiang.cmsserver.server.ArticleServer;
import com.xiang.restserver.ErrorCodes;

/**
 * @author xiang
 *
 */
@RestController
@RequestMapping(value = "/cms/article")
public class ArticleController {
	@Resource
	private ArticleServer articleServer;
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Object add(@RequestBody ArticleBo bo) {
		return articleServer.add(bo);
	}
	@RequestMapping(value = "/del", method = RequestMethod.POST)
	public Object del(@RequestBody Long[] ids) {
		articleServer.setDelById("article", ids, true);
		return ErrorCodes.OK;
	}
	@RequestMapping(value = "/undel", method = RequestMethod.POST)
	public Object unDel(@RequestBody Long[] ids) {
		articleServer.setDelById("article", ids, false);
		return ErrorCodes.OK;
	}
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Object update(@RequestBody ArticleBo bo) {
		articleServer.update(bo);
		return ErrorCodes.OK;
	}
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Object list(@RequestBody(required=false) Map<String,Object> querys) {
		return articleServer.queryList(querys);
	}
	@RequestMapping(value = "/get",method =RequestMethod.GET)
	public Object get(@RequestParam("id") Long id) {
		return articleServer.get(id);
	}
}
