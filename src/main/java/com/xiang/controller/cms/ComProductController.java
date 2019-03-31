package com.xiang.controller.cms;

import java.util.Map;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.xiang.bean.bo.ComProductBo;
import com.xiang.cmsserver.server.ComProductServer;
import com.xiang.restserver.ErrorCodes;
/**
 * @author xiang
 *
 */
@RestController
@RequestMapping(value = "/comproduct")
public class ComProductController {
	@Resource
	private ComProductServer comProductServer;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Object add(@RequestBody ComProductBo bo) {
		return comProductServer.add(bo);
	}
	@RequestMapping(value = "/del", method = RequestMethod.POST)
	public Object del(@RequestBody Long[] ids) {
		comProductServer.setDelById("com_product", ids, true);
		return ErrorCodes.OK;
	}
	@RequestMapping(value = "/undel", method = RequestMethod.POST)
	public Object unDel(@RequestBody Long[] ids) {
		comProductServer.setDelById("com_product", ids, false);
		return ErrorCodes.OK;
	}
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Object update(@RequestBody ComProductBo bo) {
		comProductServer.update(bo);
		return ErrorCodes.OK;
	}
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Object list(@RequestBody(required=false) Map<String,Object> querys) {
		return comProductServer.queryList(querys);
	}
	@RequestMapping(value = "/get",method =RequestMethod.GET)
	public Object get(@RequestParam("id") Long id) {
		return comProductServer.get(id);
	}
	@RequestMapping(value = "/up", method = RequestMethod.POST)
	public Object up(@RequestParam("id") Long id) {
		comProductServer.up(id);
		return ErrorCodes.OK;
	}
	@RequestMapping(value = "/down", method = RequestMethod.POST)
	public Object down(@RequestParam("id") Long id) {
		comProductServer.down(id);
		return ErrorCodes.OK;
	}
	@RequestMapping(value = "/products",method =RequestMethod.GET)
	public Object getProducts(@RequestParam("id") Long id) {
		return comProductServer.getProductList(id);
	}
}
