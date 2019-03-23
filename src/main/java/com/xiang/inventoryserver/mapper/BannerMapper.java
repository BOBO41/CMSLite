package com.xiang.inventoryserver.mapper;

import com.xiang.bean.po.Banner;
import com.xiang.bean.po.BannerExample;
import com.xiang.inventoryserver.exmapper.ExBannerMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface BannerMapper extends ExBannerMapper {
    long countByExample(BannerExample example);

    List<Banner> selectByExample(BannerExample example);

    @Select({
        "select",
        "id, del, title, content, img_url, sort, add_time",
        "from banner",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.xiang.inventoryserver.mapper.BannerMapper.BaseResultMap")
    Banner selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Banner record, @Param("example") BannerExample example);

    int updateByExample(@Param("record") Banner record, @Param("example") BannerExample example);

    int updateByPrimaryKeySelective(Banner record);

    @Update({
        "update banner",
        "set del = #{del,jdbcType=BIT},",
          "title = #{title,jdbcType=VARCHAR},",
          "content = #{content,jdbcType=VARCHAR},",
          "img_url = #{imgUrl,jdbcType=VARCHAR},",
          "sort = #{sort,jdbcType=INTEGER},",
          "add_time = #{addTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Banner record);
}