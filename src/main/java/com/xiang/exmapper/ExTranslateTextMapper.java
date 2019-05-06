package com.xiang.exmapper;

import org.apache.ibatis.annotations.Param;

import com.xiang.bean.po.TranslateText;

public interface ExTranslateTextMapper {
	public int save(TranslateText record);
	public long count(@Param("refererId") Long refererId,@Param("field") String field,@Param("type") String type,@Param("language") String language);
}
