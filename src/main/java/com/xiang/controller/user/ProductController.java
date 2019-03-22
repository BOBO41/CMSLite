package com.xiang.controller.user;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xiang.bean.bo.ProductBo;
import com.xiang.bean.bo.UserBo;
import com.xiang.bean.vo.ProductPropsVo;
import com.xiang.productserver.CatalogServer;
import com.xiang.productserver.ProductServer;
import com.xiang.restserver.ErrorCodes;

/**
 * @author xiang
 *
 */
@RestController
@RequestMapping(value = "/product")
public class ProductController {
	@Resource
	private ProductServer productServer;
	@Resource
	private CatalogServer catalogServer;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Object add(@RequestBody ProductBo bo) {
		return productServer.add(bo);
	}
	@RequestMapping(value = "/del", method = RequestMethod.POST)
	public Object del(@RequestBody Long[] ids) {
		productServer.setDelById("product", ids, true);
		return ErrorCodes.OK;
	}
	@RequestMapping(value = "/undel", method = RequestMethod.POST)
	public Object unDel(@RequestBody Long[] ids) {
		productServer.setDelById("product", ids, false);
		return ErrorCodes.OK;
	}
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Object update(@RequestBody ProductBo bo) {
		productServer.update(bo);
		return ErrorCodes.OK;
	}
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Object list(@RequestBody(required=false) Map<String,Object> querys) {
		return productServer.queryList(querys);
	}
	@RequestMapping(value = "/props", method = RequestMethod.GET)
	public Object getProps() {
		ProductPropsVo productPropsVo=new ProductPropsVo();
		productPropsVo.setCatalogs(catalogServer.getCatologTree());
		return productPropsVo;
	}
	@RequestMapping(value = "/get",method =RequestMethod.GET)
	public Object get(@RequestParam("id") Long id) {
		return productServer.get(id);
	}
}
