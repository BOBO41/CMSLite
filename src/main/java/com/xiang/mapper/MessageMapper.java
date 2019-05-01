package com.xiang.mapper;

import com.xiang.bean.po.Message;
import com.xiang.bean.po.MessageExample;
import com.xiang.exmapper.ExMessageMapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface MessageMapper extends ExMessageMapper {
    long countByExample(MessageExample example);

    List<Message> selectByExample(MessageExample example);

    @Select({
        "select",
        "id, del, add_time, name, email, mobile, content, status",
        "from message",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.xiang.mapper.MessageMapper.BaseResultMap")
    Message selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Message record, @Param("example") MessageExample example);

    int updateByExample(@Param("record") Message record, @Param("example") MessageExample example);

    int updateByPrimaryKeySelective(Message record);

    @Update({
        "update message",
        "set del = #{del,jdbcType=BIT},",
          "add_time = #{addTime,jdbcType=TIMESTAMP},",
          "name = #{name,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR},",
          "mobile = #{mobile,jdbcType=VARCHAR},",
          "content = #{content,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Message record);
}