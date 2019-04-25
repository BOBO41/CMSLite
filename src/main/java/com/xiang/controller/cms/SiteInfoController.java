package com.xiang.controller.cms;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xiang.bean.bo.SiteInfoBo;
import com.xiang.cmsserver.server.CacheServer;
import com.xiang.cmsserver.server.SiteInfoServer;
import com.xiang.restserver.ErrorCodes;

@RestController
@RequestMapping(value = "/cms/siteinfo")
public class SiteInfoController {
	@Resource
	private SiteInfoServer siteInfoServer;
	@Resource
	private CacheServer cacheServer;
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Object add(@RequestBody SiteInfoBo bo) {
		return siteInfoServer.add(bo);
	}
	@RequestMapping(value = "/del", method = RequestMethod.POST)
	public Object del(@RequestBody Long[] ids) {
		siteInfoServer.setDelById("site_info", ids, true);
		return ErrorCodes.OK;
	}
	@RequestMapping(value = "/undel", method = RequestMethod.POST)
	public Object unDel(@RequestBody Long[] ids) {
		siteInfoServer.setDelById("site_info", ids, false);
		return ErrorCodes.OK;
	}
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Object update(@RequestBody SiteInfoBo bo) {
		siteInfoServer.update(bo);
		return ErrorCodes.OK;
	}
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Object list(@RequestBody(required=false) Map<String,Object> querys) {
		return siteInfoServer.queryList(querys);
	}
	@RequestMapping(value = "/get",method =RequestMethod.GET)
	public Object get(@RequestParam("id") Long id) {
		return siteInfoServer.get(id);
	}
	@RequestMapping(value = "/clearcache",method =RequestMethod.GET)
	public Object clearCache() {
		cacheServer.clearAll();
		return ErrorCodes.OK;
	}
}
