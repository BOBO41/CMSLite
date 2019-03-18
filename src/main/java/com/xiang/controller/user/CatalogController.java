package com.xiang.controller.user;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xiang.bean.bo.CatalogBo;
import com.xiang.productserver.CatalogServer;
import com.xiang.restserver.ErrorCodes;

/**
 * @author xiang
 *
 */
@RestController
@RequestMapping(value = "/catalog")
public class CatalogController {
	@Resource
	private CatalogServer catalogServer;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Object add(@RequestBody CatalogBo bo) {
		return catalogServer.add(bo);
	}

	@RequestMapping(value = "/tree", method = RequestMethod.POST)
	public Object tree(@RequestBody(required=false) Map<String,Object> querys) {
		return catalogServer.getCatologTree(querys);
	}
	@RequestMapping(value = "/del", method = RequestMethod.POST)
	public Object del(@RequestBody Long[] ids) {
		catalogServer.setDelById(ids, true);
		return ErrorCodes.OK;
	}
	@RequestMapping(value = "/undel", method = RequestMethod.POST)
	public Object unDel(@RequestBody Long[] ids) {
		catalogServer.setDelById(ids, false);
		return ErrorCodes.OK;
	}
	@RequestMapping(value = "/up", method = RequestMethod.POST)
	public Object up(@RequestParam("id") Long id) {
		catalogServer.up(id);
		return ErrorCodes.OK;
	}
	@RequestMapping(value = "/down", method = RequestMethod.POST)
	public Object down(@RequestParam("id") Long id) {
		catalogServer.down(id);
		return ErrorCodes.OK;
	}
}
