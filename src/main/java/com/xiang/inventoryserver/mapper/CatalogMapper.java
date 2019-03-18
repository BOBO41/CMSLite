package com.xiang.inventoryserver.mapper;

import com.xiang.bean.po.Catalog;
import com.xiang.bean.po.CatalogExample;
import com.xiang.inventoryserver.exmapper.ExCatalogMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface CatalogMapper extends ExCatalogMapper {
    long countByExample(CatalogExample example);

    List<Catalog> selectByExample(CatalogExample example);

    @Select({
        "select",
        "id, name, parent_id, left_id, right_id, del, add_time",
        "from catalog",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.xiang.inventoryserver.mapper.CatalogMapper.BaseResultMap")
    Catalog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Catalog record, @Param("example") CatalogExample example);

    int updateByExample(@Param("record") Catalog record, @Param("example") CatalogExample example);

    int updateByPrimaryKeySelective(Catalog record);

    @Update({
        "update catalog",
        "set name = #{name,jdbcType=VARCHAR},",
          "parent_id = #{parentId,jdbcType=BIGINT},",
          "left_id = #{leftId,jdbcType=BIGINT},",
          "right_id = #{rightId,jdbcType=BIGINT},",
          "del = #{del,jdbcType=BIT},",
          "add_time = #{addTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Catalog record);
}