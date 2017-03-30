package com.nxs.mall.entity;

/**
 * Created by 57014 on 2017/2/21.
 */
public class ShoppingCart {
    private Integer cartId;//购物车id

    private Integer userId;//用户id

    private Integer itemId;//商品id

    private Items items;//商品

    private Integer cartItemNumber;//购物车内商品数量

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    public Integer getCartItemNumber() {
        return cartItemNumber;
    }

    public void setCartItemNumber(Integer cartItemNumber) {
        this.cartItemNumber = cartItemNumber;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }
}
