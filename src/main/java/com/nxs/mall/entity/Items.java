package com.nxs.mall.entity;

/**
 * Created by 57014 on 2017/2/14.
 */
public class Items {
    private Integer itemId;//商品id

    private String itemName;//商品名

    private String itemDescribe;//商品描述

    private double originalPrice;//原价

    private double promotionPrice;//促销价

    private int repetory;//库存

    private Integer categoryId;//商品类别id

    private int soldNumber;//已卖数量

    private Integer imageId;//默认显示图片

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescribe() {
        return itemDescribe;
    }

    public void setItemDescribe(String itemDescribe) {
        this.itemDescribe = itemDescribe;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public double getPromotionPrice() {
        return promotionPrice;
    }

    public void setPromotionPrice(double promotionPrice) {
        this.promotionPrice = promotionPrice;
    }

    public int getRepetory() {
        return repetory;
    }

    public void setRepetory(int repetory) {
        this.repetory = repetory;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public int getSoldNumber() {
        return soldNumber;
    }

    public void setSoldNumber(int soldNumber) {
        this.soldNumber = soldNumber;
    }

}
