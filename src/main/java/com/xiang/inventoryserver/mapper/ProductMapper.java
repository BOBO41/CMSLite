package com.xiang.inventoryserver.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.xiang.bean.po.Product;
import com.xiang.bean.po.ProductExample;
import com.xiang.inventoryserver.exmapper.ExProductMapper;

public interface ProductMapper extends ExProductMapper {
    long countByExample(ProductExample example);

    List<Product> selectByExample(ProductExample example);

    @Select({
        "select",
        "id, code, name, spec, barcode, img_url, catalog_id, del, add_time",
        "from product",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.xiang.inventoryserver.mapper.ProductMapper.BaseResultMap")
    Product selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByExample(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByPrimaryKeySelective(Product record);

    @Update({
        "update product",
        "set code = #{code,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "spec = #{spec,jdbcType=VARCHAR},",
          "barcode = #{barcode,jdbcType=VARCHAR},",
          "img_url = #{imgUrl,jdbcType=VARCHAR},",
          "catalog_id = #{catalogId,jdbcType=BIGINT},",
          "del = #{del,jdbcType=BIT},",
          "add_time = #{addTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Product record);
}