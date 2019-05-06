package com.xiang.mapper;

import com.xiang.bean.po.TranslateField;
import com.xiang.bean.po.TranslateFieldExample;
import com.xiang.exmapper.ExTranslateFieldMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface TranslateFieldMapper extends ExTranslateFieldMapper {
    long countByExample(TranslateFieldExample example);

    List<TranslateField> selectByExample(TranslateFieldExample example);

    @Select({
        "select",
        "id, del, add_time, referer_id, content, type, language",
        "from translate_field",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.xiang.mapper.TranslateFieldMapper.BaseResultMap")
    TranslateField selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TranslateField record, @Param("example") TranslateFieldExample example);

    int updateByExample(@Param("record") TranslateField record, @Param("example") TranslateFieldExample example);

    int updateByPrimaryKeySelective(TranslateField record);

    @Update({
        "update translate_field",
        "set del = #{del,jdbcType=BIT},",
          "add_time = #{addTime,jdbcType=TIMESTAMP},",
          "referer_id = #{refererId,jdbcType=BIGINT},",
          "content = #{content,jdbcType=VARCHAR},",
          "type = #{type,jdbcType=VARCHAR},",
          "language = #{language,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(TranslateField record);
}