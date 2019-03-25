package com.xiang.inventoryserver.mapper;

import com.xiang.bean.po.Nav;
import com.xiang.bean.po.NavExample;
import com.xiang.inventoryserver.exmapper.ExNavMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface NavMapper extends ExNavMapper {
    long countByExample(NavExample example);

    List<Nav> selectByExample(NavExample example);

    @Select({
        "select",
        "id, del, add_time, title, payload, img_url, sort, content, type",
        "from nav",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.xiang.inventoryserver.mapper.NavMapper.BaseResultMap")
    Nav selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Nav record, @Param("example") NavExample example);

    int updateByExample(@Param("record") Nav record, @Param("example") NavExample example);

    int updateByPrimaryKeySelective(Nav record);

    @Update({
        "update nav",
        "set del = #{del,jdbcType=BIT},",
          "add_time = #{addTime,jdbcType=TIMESTAMP},",
          "title = #{title,jdbcType=VARCHAR},",
          "payload = #{payload,jdbcType=VARCHAR},",
          "img_url = #{imgUrl,jdbcType=VARCHAR},",
          "sort = #{sort,jdbcType=INTEGER},",
          "content = #{content,jdbcType=VARCHAR},",
          "type = #{type,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Nav record);
}