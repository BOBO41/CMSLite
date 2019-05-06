package com.xiang.mapper;

import com.xiang.bean.po.TranslateSearch;
import com.xiang.bean.po.TranslateSearchExample;
import com.xiang.exmapper.ExTranslateSearchMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface TranslateSearchMapper extends ExTranslateSearchMapper {
    long countByExample(TranslateSearchExample example);

    List<TranslateSearch> selectByExample(TranslateSearchExample example);

    @Select({
        "select",
        "id, del, add_time, referer_id, field, content, type, language",
        "from translate_search",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.xiang.mapper.TranslateSearchMapper.BaseResultMap")
    TranslateSearch selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TranslateSearch record, @Param("example") TranslateSearchExample example);

    int updateByExample(@Param("record") TranslateSearch record, @Param("example") TranslateSearchExample example);

    int updateByPrimaryKeySelective(TranslateSearch record);

    @Update({
        "update translate_search",
        "set del = #{del,jdbcType=BIT},",
          "add_time = #{addTime,jdbcType=TIMESTAMP},",
          "referer_id = #{refererId,jdbcType=BIGINT},",
          "field = #{field,jdbcType=VARCHAR},",
          "content = #{content,jdbcType=VARCHAR},",
          "type = #{type,jdbcType=VARCHAR},",
          "language = #{language,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(TranslateSearch record);
}