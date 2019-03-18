package com.xiang.productserver.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import com.robert.vesta.service.intf.IdService;
import com.xiang.bean.bo.CatalogBo;
import com.xiang.bean.po.Catalog;
import com.xiang.bean.vo.CatalogVo;
import com.xiang.inventoryserver.server.impl.BaseServerImpl;
import com.xiang.productserver.CatalogServer;
import com.xiang.productservice.CatalogService;
import com.xiang.restserver.APIException;
import com.xiang.restserver.ErrorCodes;

/**
 * @author xiang
 * @createDate 2018年12月20日 下午2:18:51
 */
@Service("catalogServer")
public class CatalogServerImpl extends BaseServerImpl implements CatalogServer {
	@Resource
	private CatalogService catalogService;
	@Resource
	private IdService idService;

	@Override
	public List<CatalogVo> getCatologTree(Map<String, Object> querys) {
		List<CatalogVo> result = new ArrayList<CatalogVo>();
		CatalogVo top = new CatalogVo();
		top.setDel(false);
		top.setAddTime(new Date());
		top.setId(0l);
		top.setName("顶级分类");
		top.setParentId(0l);
		result.add(top);
		List<Catalog> list = catalogService.getList(querys);
		if (!ObjectUtils.isEmpty(list)) {
			Map<Long, CatalogVo> map = new HashMap<>(list.size());
			List<CatalogVo> leftList = new ArrayList<>();
			for (Catalog catalog : list) {
				CatalogVo vo = getVo(catalog);
				map.put(vo.getId(), vo);
				if (vo.getLeftId().compareTo(0l) == 0) {
					leftList.add(vo);
				}
			}
			for (CatalogVo leftVo : leftList) {
				List<CatalogVo> children = null;
				if (leftVo.getParentId().compareTo(0l) == 0) {
					children = result;
				} else {
					children = map.get(leftVo.getParentId()).getChildren();
				}
				children.add(leftVo);
				while (leftVo.getRightId().compareTo(0l) != 0) {
					leftVo = map.get(leftVo.getRightId());
					children.add(leftVo);
				}
			}
		}
		return result;
	}

	private CatalogVo getVo(Catalog po) {
		CatalogVo vo = new CatalogVo();
		BeanUtils.copyProperties(po, vo);
		return vo;
	}

	private Catalog getPo(CatalogBo bo) {
		Catalog po = new Catalog();
		BeanUtils.copyProperties(bo, po);
		po.setParentId(bo.getParentIds()[bo.getParentIds().length - 1]);
		return po;
	}

	@Transactional
	@Override
	public CatalogVo add(CatalogBo bo) {
		try {
			Catalog po = getPo(bo);
			long id = idService.genId();
			po.setId(id);
			po.setAddTime(new Date());
			Catalog last = catalogService.getLastChildren(po.getParentId());
			if (Objects.isNull(last)) {
				po.setLeftId(0l);
				po.setRightId(0l);
			} else {
				po.setLeftId(last.getId());
				po.setRightId(0l);
				if (catalogService.updateRight(last.getId(), last.getRightId(), po.getId()) == 0) {
					throw new APIException(ErrorCodes.ADD_ERROR);
				}
			}
			catalogService.save(po);
			return getVo(po);
		} catch (APIException ex) {
			throw ex;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new APIException(ErrorCodes.ERROR);
		}
	}

	private List<Catalog> getChilds(Long[] ids, Boolean del) {
		List<Catalog> result = new ArrayList<>();
		while (!ObjectUtils.isEmpty(ids)) {
			List<Catalog> catalogs = catalogService.getChilds(ids, del);
			if (!ObjectUtils.isEmpty(catalogs)) {
				result.addAll(catalogs);
				ids = toArrayById(catalogs);
			} else {
				break;
			}
		}
		return result;
	}

	private Long[] toArrayById(List<Catalog> catalogs) {
		if (!ObjectUtils.isEmpty(catalogs)) {
			Long[] ids = new Long[catalogs.size()];
			for (int i = 0; i < catalogs.size(); i++) {
				ids[i] = catalogs.get(i).getId();
			}
			return ids;
		}
		return null;
	}

	@Transactional
	@Override
	public void setDelById(Long[] ids, Boolean del) {
		// 不支持恢复操作
		if (!del) {
			throw new APIException(ErrorCodes.NONSUPPORT);
		}
		for (Long id : ids) {
			Catalog catalog = catalogService.get(id);
			if (catalog.getDel().compareTo(del) == 0) {
				throw new APIException(ErrorCodes.CATALOG_SORT_ERROR);
			}
			if (del) {
				// 删除操作
				if (catalog.getLeftId().compareTo(0l) != 0) {
					// 将左节点的右指针指到当前节点右指针
					if (catalogService.updateRight(catalog.getLeftId(), catalog.getId(), catalog.getRightId()) == 0) {
						Catalog leftNode = catalogService.get(catalog.getLeftId());
						if (leftNode.getRightId().compareTo(catalog.getRightId()) != 0) {
							throw new APIException(ErrorCodes.CATALOG_SORT_ERROR);
						}
					}
				}
				if (catalog.getRightId().compareTo(0l) != 0) {
					// 将右节点的左指针指到当前节点左指针
					if (catalogService.updateLeft(catalog.getRightId(), catalog.getId(), catalog.getLeftId()) == 0) {
						Catalog rightNode = catalogService.get(catalog.getRightId());
						if (rightNode.getLeftId().compareTo(catalog.getLeftId()) != 0) {
							throw new APIException(ErrorCodes.CATALOG_SORT_ERROR);
						}
					}
				}
			}
		}
		catalogService.setDelById("catalog", ids, del);
		List<Catalog> childs = getChilds(ids, !del);
		if (!ObjectUtils.isEmpty(childs)) {
			Long[] temp = toArrayById(childs);
			catalogService.setDelById("catalog", temp, del);
		}
	}

	@Transactional
	@Override
	public void up(Long id) {
		if (!Objects.isNull(id)) {
			Catalog catalog = catalogService.get(id);
			if (catalog.getDel()) {
				throw new APIException(ErrorCodes.CATALOG_SORT_ERROR);
			}
			// 顶部节点
			if (catalog.getLeftId().compareTo(0l) == 0) {
				if (catalog.getParentId().compareTo(0l) == 0) {
					throw new APIException(ErrorCodes.CATALOG_SORT_TOP);
				}
				// 往上一层节点排序
				else {
					Catalog parent = catalogService.get(catalog.getParentId());
					Catalog leftNode = null;
					if (parent.getLeftId().compareTo(0l) != 0) {
						leftNode = catalogService.get(parent.getLeftId());
					}
					// 将当前节点的右节点的左指针更新为0
					if (catalog.getRightId().compareTo(0l) != 0) {
						if (catalogService.updateLeft(catalog.getRightId(), catalog.getId(), 0l) == 0) {
							Catalog node = catalogService.get(catalog.getRightId());
							if (node.getLeftId().compareTo(0l) != 0) {
								throw new APIException(ErrorCodes.CATALOG_SORT_ERROR);
							}
						}
					}
					
					insertMiddle(leftNode,catalog,parent);
					Catalog updateCatalog=new Catalog();
					updateCatalog.setId(catalog.getId());
					updateCatalog.setParentId(parent.getParentId());
					catalogService.update(updateCatalog);
				}
			}
			// 兄弟节点
			else {
				Catalog leftNode = null;
				if (catalog.getLeftId().compareTo(0l) != 0) {
					leftNode = catalogService.get(catalog.getLeftId());
				}
				Catalog rightNode = null;
				if (catalog.getRightId().compareTo(0l) != 0) {
					rightNode = catalogService.get(catalog.getRightId());
				}
				moveLeft(leftNode, catalog, rightNode);
			}
		}
	}

	/**
	 * middleNode插入再leftNode和rightNode之间
	 * 
	 * @param leftNode
	 * @param middleNode
	 * @param rightNode
	 */
	private void insertMiddle(Catalog leftNode, Catalog middleNode, Catalog rightNode) {
		if (!Objects.isNull(leftNode)) {
			// 将左节点的右指针指到当前节点
			if (catalogService.updateRight(leftNode.getId(), leftNode.getRightId(), middleNode.getId()) == 0) {
				if (leftNode.getRightId().compareTo(middleNode.getId()) != 0) {
					throw new APIException(ErrorCodes.CATALOG_SORT_ERROR);
				}
			}
			// 将节点的左指针指到左节点
			if (catalogService.updateLeft(middleNode.getId(), middleNode.getLeftId(), leftNode.getId()) == 0) {
				if (middleNode.getLeftId().compareTo(leftNode.getId()) != 0) {
					throw new APIException(ErrorCodes.CATALOG_SORT_ERROR);
				}
			}
		} else {
			// 将节点的左指针指到0
			if (catalogService.updateLeft(middleNode.getId(), middleNode.getLeftId(), 0l) == 0) {
				if (middleNode.getLeftId().compareTo(0l) != 0) {
					throw new APIException(ErrorCodes.CATALOG_SORT_ERROR);
				}
			}
		}
		if (!Objects.isNull(rightNode)) {
			// 将右节点的左指针指到当前节点
			if (catalogService.updateLeft(rightNode.getId(), rightNode.getLeftId(), middleNode.getId()) == 0) {
				if (rightNode.getLeftId().compareTo(middleNode.getId()) != 0) {
					throw new APIException(ErrorCodes.CATALOG_SORT_ERROR);
				}
			}
			// 将节点的右指针指到右节点
			if (catalogService.updateRight(middleNode.getId(), middleNode.getRightId(), rightNode.getId()) == 0) {
				if (middleNode.getRightId().compareTo(rightNode.getId()) != 0) {
					throw new APIException(ErrorCodes.CATALOG_SORT_ERROR);
				}
			}
		} else {
			// 将节点的右指针指到0
			if (catalogService.updateRight(middleNode.getId(), middleNode.getRightId(), 0l) == 0) {
				if (middleNode.getRightId().compareTo(0l) != 0) {
					throw new APIException(ErrorCodes.CATALOG_SORT_ERROR);
				}
			}
		}
	}

	/**
	 * middleNode和leftNode交换位置，middleNode往上排
	 * 
	 * @param leftNode
	 * @param middleNode
	 * @param rightNode
	 */
	private void moveLeft(Catalog leftNode, Catalog middleNode, Catalog rightNode) {

		if (middleNode.getLeftId().compareTo(0l) != 0) {
			// 将左节点的右指针指到当前节点右指针
			if (catalogService.updateRight(middleNode.getLeftId(), middleNode.getId(), middleNode.getRightId()) == 0) {
				if (leftNode.getRightId().compareTo(middleNode.getRightId()) != 0) {
					throw new APIException(ErrorCodes.CATALOG_SORT_ERROR);
				}
			}
			// 将左节点的左指针指到当前节点
			if (catalogService.updateLeft(middleNode.getLeftId(), leftNode.getLeftId(), middleNode.getId()) == 0) {
				if (leftNode.getLeftId().compareTo(middleNode.getId()) != 0) {
					throw new APIException(ErrorCodes.CATALOG_SORT_ERROR);
				}
			}
			// 将左节点的左指针节点的右指针指到当前节点
			if (leftNode.getLeftId().compareTo(0l) != 0) {
				if (catalogService.updateRight(leftNode.getLeftId(), leftNode.getId(), middleNode.getId()) == 0) {
					Catalog node = catalogService.get(leftNode.getLeftId());
					if (node.getRightId().compareTo(middleNode.getId()) != 0) {
						throw new APIException(ErrorCodes.CATALOG_SORT_ERROR);
					}
				}
			}
			if (middleNode.getRightId().compareTo(0l) != 0) {
				// 将右节点的左指针指到当前节点左指针
				if (catalogService.updateLeft(middleNode.getRightId(), middleNode.getId(),
						middleNode.getLeftId()) == 0) {
					if (rightNode.getLeftId().compareTo(middleNode.getLeftId()) != 0) {
						throw new APIException(ErrorCodes.CATALOG_SORT_ERROR);
					}
				}
			}
			// 将当前节点的左指针指到左节点的左指针
			if (catalogService.updateLeft(middleNode.getId(), middleNode.getLeftId(), leftNode.getLeftId()) == 0) {
				if (middleNode.getLeftId().compareTo(leftNode.getLeftId()) != 0) {
					throw new APIException(ErrorCodes.CATALOG_SORT_ERROR);
				}
			}
			// 将当前节点的右指针指到左节点
			if (catalogService.updateRight(middleNode.getId(), middleNode.getRightId(), middleNode.getLeftId()) == 0) {
				if (middleNode.getRightId().compareTo(middleNode.getLeftId()) != 0) {
					throw new APIException(ErrorCodes.CATALOG_SORT_ERROR);
				}
			}
		}
	}

	@Transactional
	@Override
	public void down(Long id) {
		// TODO Auto-generated method stub

	}
}
