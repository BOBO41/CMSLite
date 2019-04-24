package com.xiang.inventoryserver.mapper;

import com.xiang.bean.po.ProductEx;
import com.xiang.bean.po.ProductExExample;
import com.xiang.inventoryserver.exmapper.ExProductExMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ProductExMapper extends ExProductExMapper {
    long countByExample(ProductExExample example);

    List<ProductEx> selectByExampleWithBLOBs(ProductExExample example);

    List<ProductEx> selectByExample(ProductExExample example);

    @Select({
        "select",
        "id, del, add_time, img_url_a, img_url_b, img_url_c, keyword, description, content",
        "from product_ex",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.xiang.inventoryserver.mapper.ProductExMapper.ResultMapWithBLOBs")
    ProductEx selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ProductEx record, @Param("example") ProductExExample example);

    int updateByExampleWithBLOBs(@Param("record") ProductEx record, @Param("example") ProductExExample example);

    int updateByExample(@Param("record") ProductEx record, @Param("example") ProductExExample example);

    int updateByPrimaryKeySelective(ProductEx record);

    @Update({
        "update product_ex",
        "set del = #{del,jdbcType=BIT},",
          "add_time = #{addTime,jdbcType=TIMESTAMP},",
          "img_url_a = #{imgUrlA,jdbcType=VARCHAR},",
          "img_url_b = #{imgUrlB,jdbcType=VARCHAR},",
          "img_url_c = #{imgUrlC,jdbcType=VARCHAR},",
          "keyword = #{keyword,jdbcType=VARCHAR},",
          "description = #{description,jdbcType=VARCHAR},",
          "content = #{content,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(ProductEx record);

    @Update({
        "update product_ex",
        "set del = #{del,jdbcType=BIT},",
          "add_time = #{addTime,jdbcType=TIMESTAMP},",
          "img_url_a = #{imgUrlA,jdbcType=VARCHAR},",
          "img_url_b = #{imgUrlB,jdbcType=VARCHAR},",
          "img_url_c = #{imgUrlC,jdbcType=VARCHAR},",
          "keyword = #{keyword,jdbcType=VARCHAR},",
          "description = #{description,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ProductEx record);
}