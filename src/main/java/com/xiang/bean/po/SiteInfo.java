package com.xiang.bean.po;

import java.util.Date;

import com.xiang.translate.Translate;
import com.xiang.translate.TranslatePolicy;

public class SiteInfo {
    private Long id;

    private Boolean del;

    private Date addTime;
    
    @Translate(policy=TranslatePolicy.FIELD)
    private String title;
    
    @Translate(policy=TranslatePolicy.FIELD)
    private String keyword;

    @Translate(policy=TranslatePolicy.FIELD)
    private String description;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}