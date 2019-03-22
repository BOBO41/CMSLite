package com.xiang.bean.po;

import java.util.Date;

public class ProductEx {
    private Long id;

    private String imgUrlA;

    private String imgUrlB;

    private String imgUrlC;

    private Boolean del;

    private Date addTime;

    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImgUrlA() {
        return imgUrlA;
    }

    public void setImgUrlA(String imgUrlA) {
        this.imgUrlA = imgUrlA;
    }

    public String getImgUrlB() {
        return imgUrlB;
    }

    public void setImgUrlB(String imgUrlB) {
        this.imgUrlB = imgUrlB;
    }

    public String getImgUrlC() {
        return imgUrlC;
    }

    public void setImgUrlC(String imgUrlC) {
        this.imgUrlC = imgUrlC;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}