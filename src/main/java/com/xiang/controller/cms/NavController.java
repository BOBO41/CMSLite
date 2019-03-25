package com.xiang.controller.cms;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xiang.bean.bo.NavBo;
import com.xiang.cmsserver.server.NavServer;
import com.xiang.restserver.ErrorCodes;

/**
 * @author xiang
 *
 */
@RestController
@RequestMapping(value = "/nav")
public class NavController {
	@Resource
	private NavServer navServer;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Object add(@RequestBody NavBo bo) {
		return navServer.add(bo);
	}
	@RequestMapping(value = "/del", method = RequestMethod.POST)
	public Object del(@RequestBody Long[] ids) {
		navServer.setDelById("nav", ids, true);
		return ErrorCodes.OK;
	}
	@RequestMapping(value = "/undel", method = RequestMethod.POST)
	public Object unDel(@RequestBody Long[] ids) {
		navServer.setDelById("nav", ids, false);
		return ErrorCodes.OK;
	}
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Object update(@RequestBody NavBo bo) {
		navServer.update(bo);
		return ErrorCodes.OK;
	}
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Object list(@RequestBody(required=false) Map<String,Object> querys) {
		return navServer.queryList(querys);
	}
	@RequestMapping(value = "/get",method =RequestMethod.GET)
	public Object get(@RequestParam("id") Long id) {
		return navServer.get(id);
	}
	@RequestMapping(value = "/up", method = RequestMethod.POST)
	public Object up(@RequestParam("id") Long id) {
		navServer.up(id);
		return ErrorCodes.OK;
	}
	@RequestMapping(value = "/down", method = RequestMethod.POST)
	public Object down(@RequestParam("id") Long id) {
		navServer.down(id);
		return ErrorCodes.OK;
	}
}
