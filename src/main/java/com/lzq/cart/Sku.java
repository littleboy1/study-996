package com.lzq.cart;

public class Sku {
    //编号
    private Integer skuId;
    //商品名称
    private String skuName;
    //单价
    private Double skuPrice;
    //购买个数
    private Integer skuTotal;
    //总价
    private Double totalPrice;
    //商品类型
    private SkuCategoryEnum skuCategory;

    public Sku(Integer skuId, String skuName, Double skuPrice, Integer skuTotal, Double totalPrice, SkuCategoryEnum skuCategory) {
        this.skuId = skuId;
        this.skuName = skuName;
        this.skuPrice = skuPrice;
        this.skuTotal = skuTotal;
        this.totalPrice = totalPrice;
        this.skuCategory = skuCategory;
    }

    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public Double getSkuPrice() {
        return skuPrice;
    }

    public void setSkuPrice(Double skuPrice) {
        this.skuPrice = skuPrice;
    }

    public Integer getSkuTotal() {
        return skuTotal;
    }

    public void setSkuTotal(Integer skuTotal) {
        this.skuTotal = skuTotal;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public SkuCategoryEnum getSkuCategory() {
        return skuCategory;
    }

    public void setSkuCategory(SkuCategoryEnum skuCategory) {
        this.skuCategory = skuCategory;
    }
}
