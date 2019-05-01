package com.xiang.mapper;

import com.xiang.bean.po.Article;
import com.xiang.bean.po.ArticleExample;
import com.xiang.exmapper.ExArticleMapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ArticleMapper extends ExArticleMapper {
    long countByExample(ArticleExample example);

    List<Article> selectByExample(ArticleExample example);

    @Select({
        "select",
        "id, del, add_time, title, spec, img_url",
        "from article",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.xiang.mapper.ArticleMapper.BaseResultMap")
    Article selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Article record, @Param("example") ArticleExample example);

    int updateByExample(@Param("record") Article record, @Param("example") ArticleExample example);

    int updateByPrimaryKeySelective(Article record);

    @Update({
        "update article",
        "set del = #{del,jdbcType=BIT},",
          "add_time = #{addTime,jdbcType=TIMESTAMP},",
          "title = #{title,jdbcType=VARCHAR},",
          "spec = #{spec,jdbcType=VARCHAR},",
          "img_url = #{imgUrl,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Article record);
}