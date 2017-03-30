package com.nxs.mall.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 57014 on 2017/2/21.
 */
public class User {

    private Integer userId;//主键用户id

    private String userName;//用户名

    private String openId;//微信公众号openId

    private List<Orders> orders;//用户创建的订单

    private List<Address> addresses;//收件地址

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }
}
