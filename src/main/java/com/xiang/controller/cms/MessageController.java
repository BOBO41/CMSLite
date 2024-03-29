package com.xiang.controller.cms;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xiang.bean.bo.MessageBo;
import com.xiang.cmsserver.server.MessageServer;
import com.xiang.restserver.ErrorCodes;

/**
 * @author xiang
 *
 */
@RestController
@RequestMapping(value = "/cms/message")
public class MessageController {
	@Resource
	private MessageServer messageServer;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Object add(@RequestBody MessageBo bo) {
		return messageServer.add(bo);
	}
	@RequestMapping(value = "/del", method = RequestMethod.POST)
	public Object del(@RequestBody Long[] ids) {
		messageServer.setDelById("message", ids, true);
		return ErrorCodes.OK;
	}
	@RequestMapping(value = "/undel", method = RequestMethod.POST)
	public Object unDel(@RequestBody Long[] ids) {
		messageServer.setDelById("message", ids, false);
		return ErrorCodes.OK;
	}
	@RequestMapping(value = "/status", method = RequestMethod.POST)
	public Object status(@RequestBody Long[] ids) {
		messageServer.setFlag("message", "status", ids, 1);
		return ErrorCodes.OK;
	}
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Object update(@RequestBody MessageBo bo) {
		messageServer.update(bo);
		return ErrorCodes.OK;
	}
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Object list(@RequestBody(required=false) Map<String,Object> querys) {
		return messageServer.queryList(querys);
	}
	@RequestMapping(value = "/get",method =RequestMethod.GET)
	public Object get(@RequestParam("id") Long id) {
		return messageServer.get(id);
	}
}
