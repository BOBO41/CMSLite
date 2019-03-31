package com.xiang.inventoryserver.mapper;

import com.xiang.bean.po.ComProduct;
import com.xiang.bean.po.ComProductExample;
import com.xiang.inventoryserver.exmapper.ExComProductMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ComProductMapper extends ExComProductMapper {
    long countByExample(ComProductExample example);

    List<ComProduct> selectByExample(ComProductExample example);

    @Select({
        "select",
        "id, del, add_time, content, name, sort",
        "from com_product",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.xiang.inventoryserver.mapper.ComProductMapper.BaseResultMap")
    ComProduct selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ComProduct record, @Param("example") ComProductExample example);

    int updateByExample(@Param("record") ComProduct record, @Param("example") ComProductExample example);

    int updateByPrimaryKeySelective(ComProduct record);

    @Update({
        "update com_product",
        "set del = #{del,jdbcType=BIT},",
          "add_time = #{addTime,jdbcType=TIMESTAMP},",
          "content = #{content,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "sort = #{sort,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ComProduct record);
}