package com.xiang.controller.cms;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xiang.bean.bo.BannerBo;
import com.xiang.cmsserver.server.BannerServer;
import com.xiang.restserver.ErrorCodes;

/**
 * @author xiang
 *
 */
@RestController
@RequestMapping(value = "/cms/banner")
public class BannerController {
	@Resource
	private BannerServer bannerServer;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Object add(@RequestBody BannerBo bo) {
		return bannerServer.add(bo);
	}
	@RequestMapping(value = "/del", method = RequestMethod.POST)
	public Object del(@RequestBody Long[] ids) {
		bannerServer.setDelById("banner", ids, true);
		return ErrorCodes.OK;
	}
	@RequestMapping(value = "/undel", method = RequestMethod.POST)
	public Object unDel(@RequestBody Long[] ids) {
		bannerServer.setDelById("banner", ids, false);
		return ErrorCodes.OK;
	}
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Object update(@RequestBody BannerBo bo) {
		bannerServer.update(bo);
		return ErrorCodes.OK;
	}
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Object list(@RequestBody(required=false) Map<String,Object> querys) {
		return bannerServer.queryList(querys);
	}
	@RequestMapping(value = "/get",method =RequestMethod.GET)
	public Object get(@RequestParam("id") Long id) {
		return bannerServer.get(id);
	}
	@RequestMapping(value = "/up", method = RequestMethod.GET)
	public Object up(@RequestParam("id") Long id) {
		bannerServer.up(id);
		return ErrorCodes.OK;
	}
	@RequestMapping(value = "/down", method = RequestMethod.GET)
	public Object down(@RequestParam("id") Long id) {
		bannerServer.down(id);
		return ErrorCodes.OK;
	}
}
