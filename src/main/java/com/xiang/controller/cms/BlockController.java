package com.xiang.controller.cms;

import java.util.Map;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.xiang.bean.bo.BlockBo;
import com.xiang.cmsserver.server.BlockServer;
import com.xiang.restserver.ErrorCodes;
/**
 * @author xiang
 *
 */
@RestController
@RequestMapping(value = "/cms/block")
public class BlockController {
	@Resource
	private BlockServer blockServer;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Object add(@RequestBody BlockBo bo) {
		return blockServer.add(bo);
	}
	@RequestMapping(value = "/del", method = RequestMethod.POST)
	public Object del(@RequestBody Long[] ids) {
		blockServer.setDelById("block", ids, true);
		return ErrorCodes.OK;
	}
	@RequestMapping(value = "/undel", method = RequestMethod.POST)
	public Object unDel(@RequestBody Long[] ids) {
		blockServer.setDelById("block", ids, false);
		return ErrorCodes.OK;
	}
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Object update(@RequestBody BlockBo bo) {
		blockServer.update(bo);
		return ErrorCodes.OK;
	}
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Object list(@RequestBody(required=false) Map<String,Object> querys) {
		return blockServer.queryList(querys);
	}
	@RequestMapping(value = "/get",method =RequestMethod.GET)
	public Object get(@RequestParam("id") Long id) {
		return blockServer.get(id);
	}
}
