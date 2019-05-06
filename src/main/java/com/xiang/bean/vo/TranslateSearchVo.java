package com.xiang.bean.vo;
import java.util.Date;
public class TranslateSearchVo {

    /**
	* 翻译ID
	*/
    private Long id;
    /**
	* 已删除
	*/
    private Boolean del;
    /**
	* 添加时间
	*/
    private Date addTime;
    /**
	* 关联ID
	*/
    private Long refererId;
    /**
	* 字段名
	*/
    private String field;
    /**
	* 字段翻译
	*/
    private String content;
    /**
	* 表名
	*/
    private String type;
    /**
	* 国际locale
	*/
    private String language;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Boolean getDel() {
        return del;
    }

    public void setDel(Boolean del) {
        this.del = del;
    }
    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
    public Long getRefererId() {
        return refererId;
    }

    public void setRefererId(Long refererId) {
        this.refererId = refererId;
    }
    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
