package com.nxs.mall.entity;

/**
 * Created by 57014 on 2017/2/21.
 */
public class OrderDetail {
    private Integer orderDetailId;//主键，订单明细id

    private Integer orderId;//订单id

    private Integer itemId;//商品id

    private Integer itemNum;//商品购买数量

    private Items items;//商品信息

    public Integer getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Integer orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getItemNum() {
        return itemNum;
    }

    public void setItemNum(Integer itemNum) {
        this.itemNum = itemNum;
    }

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }
}
