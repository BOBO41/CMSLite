package com.xiang.exmapper;

import org.apache.ibatis.annotations.Param;

import com.xiang.bean.po.TranslateField;

public interface ExTranslateFieldMapper {
	public int save(TranslateField record);
	public long count(@Param("refererId") Long refererId,@Param("type") String type,@Param("language") String language);

}
