package com.xiang.mapper;

import com.xiang.bean.po.User;
import com.xiang.bean.po.UserExample;
import com.xiang.exmapper.ExUserMapper;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserMapper extends ExUserMapper {
    long countByExample(UserExample example);

    @Insert({
        "insert into user (id, user_name, ",
        "password, nick, ",
        "roles, del, add_time)",
        "values (#{id,jdbcType=BIGINT}, #{userName,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=VARCHAR}, #{nick,jdbcType=VARCHAR}, ",
        "#{roles,jdbcType=VARCHAR}, #{del,jdbcType=BIT}, #{addTime,jdbcType=TIMESTAMP})"
    })
    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    @Select({
        "select",
        "id, user_name, password, nick, roles, del, add_time",
        "from user",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.xiang.mapper.UserMapper.BaseResultMap")
    User selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    @Update({
        "update user",
        "set user_name = #{userName,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "nick = #{nick,jdbcType=VARCHAR},",
          "roles = #{roles,jdbcType=VARCHAR},",
          "del = #{del,jdbcType=BIT},",
          "add_time = #{addTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(User record);
}