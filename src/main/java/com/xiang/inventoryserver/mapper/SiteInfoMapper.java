package com.xiang.inventoryserver.mapper;

import com.xiang.bean.po.SiteInfo;
import com.xiang.bean.po.SiteInfoExample;
import com.xiang.inventoryserver.exmapper.ExSiteInfoMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface SiteInfoMapper extends ExSiteInfoMapper {
    long countByExample(SiteInfoExample example);

    List<SiteInfo> selectByExample(SiteInfoExample example);

    @Select({
        "select",
        "id, del, add_time, title, keyword, description",
        "from site_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.xiang.inventoryserver.mapper.SiteInfoMapper.BaseResultMap")
    SiteInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SiteInfo record, @Param("example") SiteInfoExample example);

    int updateByExample(@Param("record") SiteInfo record, @Param("example") SiteInfoExample example);

    int updateByPrimaryKeySelective(SiteInfo record);

    @Update({
        "update site_info",
        "set del = #{del,jdbcType=BIT},",
          "add_time = #{addTime,jdbcType=TIMESTAMP},",
          "title = #{title,jdbcType=VARCHAR},",
          "keyword = #{keyword,jdbcType=VARCHAR},",
          "description = #{description,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(SiteInfo record);
}