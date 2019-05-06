package com.xiang.exmapper;

import org.apache.ibatis.annotations.Param;

import com.xiang.bean.po.TranslateSearch;

public interface ExTranslateSearchMapper {
	public int save(TranslateSearch record);
	public long count(@Param("refererId") Long refererId,@Param("field") String field,@Param("type") String type,@Param("language") String language);

}
