package com.xiang.mapper;

import com.xiang.bean.po.ArticleEx;
import com.xiang.bean.po.ArticleExExample;
import com.xiang.exmapper.ExArticleExMapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ArticleExMapper extends ExArticleExMapper {
    long countByExample(ArticleExExample example);

    List<ArticleEx> selectByExampleWithBLOBs(ArticleExExample example);

    List<ArticleEx> selectByExample(ArticleExExample example);

    @Select({
        "select",
        "id, del, add_time, keyword, description, content",
        "from article_ex",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.xiang.mapper.ArticleExMapper.ResultMapWithBLOBs")
    ArticleEx selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ArticleEx record, @Param("example") ArticleExExample example);

    int updateByExampleWithBLOBs(@Param("record") ArticleEx record, @Param("example") ArticleExExample example);

    int updateByExample(@Param("record") ArticleEx record, @Param("example") ArticleExExample example);

    int updateByPrimaryKeySelective(ArticleEx record);

    @Update({
        "update article_ex",
        "set del = #{del,jdbcType=BIT},",
          "add_time = #{addTime,jdbcType=TIMESTAMP},",
          "keyword = #{keyword,jdbcType=VARCHAR},",
          "description = #{description,jdbcType=VARCHAR},",
          "content = #{content,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(ArticleEx record);

    @Update({
        "update article_ex",
        "set del = #{del,jdbcType=BIT},",
          "add_time = #{addTime,jdbcType=TIMESTAMP},",
          "keyword = #{keyword,jdbcType=VARCHAR},",
          "description = #{description,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ArticleEx record);
}