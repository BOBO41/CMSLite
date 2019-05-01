package com.xiang.mapper;

import com.xiang.bean.po.Block;
import com.xiang.bean.po.BlockExample;
import com.xiang.exmapper.ExBlockMapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface BlockMapper extends ExBlockMapper {
    long countByExample(BlockExample example);

    List<Block> selectByExampleWithBLOBs(BlockExample example);

    List<Block> selectByExample(BlockExample example);

    @Select({
        "select",
        "id, del, add_time, name, description, content",
        "from block",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.xiang.mapper.BlockMapper.ResultMapWithBLOBs")
    Block selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Block record, @Param("example") BlockExample example);

    int updateByExampleWithBLOBs(@Param("record") Block record, @Param("example") BlockExample example);

    int updateByExample(@Param("record") Block record, @Param("example") BlockExample example);

    int updateByPrimaryKeySelective(Block record);

    @Update({
        "update block",
        "set del = #{del,jdbcType=BIT},",
          "add_time = #{addTime,jdbcType=TIMESTAMP},",
          "name = #{name,jdbcType=VARCHAR},",
          "description = #{description,jdbcType=VARCHAR},",
          "content = #{content,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(Block record);

    @Update({
        "update block",
        "set del = #{del,jdbcType=BIT},",
          "add_time = #{addTime,jdbcType=TIMESTAMP},",
          "name = #{name,jdbcType=VARCHAR},",
          "description = #{description,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Block record);
}