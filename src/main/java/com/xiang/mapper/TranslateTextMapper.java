package com.xiang.mapper;

import com.xiang.bean.po.TranslateText;
import com.xiang.bean.po.TranslateTextExample;
import com.xiang.exmapper.ExTranslateTextMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface TranslateTextMapper extends ExTranslateTextMapper {
    long countByExample(TranslateTextExample example);

    List<TranslateText> selectByExampleWithBLOBs(TranslateTextExample example);

    List<TranslateText> selectByExample(TranslateTextExample example);

    @Select({
        "select",
        "id, del, add_time, referer_id, field, type, language, content",
        "from translate_text",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.xiang.mapper.TranslateTextMapper.ResultMapWithBLOBs")
    TranslateText selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TranslateText record, @Param("example") TranslateTextExample example);

    int updateByExampleWithBLOBs(@Param("record") TranslateText record, @Param("example") TranslateTextExample example);

    int updateByExample(@Param("record") TranslateText record, @Param("example") TranslateTextExample example);

    int updateByPrimaryKeySelective(TranslateText record);

    @Update({
        "update translate_text",
        "set del = #{del,jdbcType=BIT},",
          "add_time = #{addTime,jdbcType=TIMESTAMP},",
          "referer_id = #{refererId,jdbcType=BIGINT},",
          "field = #{field,jdbcType=VARCHAR},",
          "type = #{type,jdbcType=VARCHAR},",
          "language = #{language,jdbcType=VARCHAR},",
          "content = #{content,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(TranslateText record);

    @Update({
        "update translate_text",
        "set del = #{del,jdbcType=BIT},",
          "add_time = #{addTime,jdbcType=TIMESTAMP},",
          "referer_id = #{refererId,jdbcType=BIGINT},",
          "field = #{field,jdbcType=VARCHAR},",
          "type = #{type,jdbcType=VARCHAR},",
          "language = #{language,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(TranslateText record);
}