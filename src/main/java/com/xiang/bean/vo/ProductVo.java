package com.xiang.bean.vo;

/**
* @author xiang
* @createDate 2018年12月20日 下午2:12:19
*/
public class ProductVo extends BaseVo{

    private String code;

    private String name;

    private String spec;

    private String barcode;

    private String imgUrl;
    
    private String imgUrlA;
    
    private String imgUrlB;
    
    private String imgUrlC;

    private Long catalogId;
    
    private Long[] catalogIds;
    
    private String content;

	public Long[] getCatalogIds() {
		return catalogIds;
	}

	public void setCatalogIds(Long[] catalogIds) {
		this.catalogIds = catalogIds;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Long getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(Long catalogId) {
		this.catalogId = catalogId;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
