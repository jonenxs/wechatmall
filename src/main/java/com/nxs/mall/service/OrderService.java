package com.nxs.mall.service;

import com.nxs.mall.entity.Orders;

import java.util.List;

/**
 * Created by 57014 on 2017/2/23.
 */
public interface OrderService {
    //支付成功后，更新订单状态，并返回订单信息
    public Orders updateOrder(Orders orders);
    //通过订单id获取订单信息
    public Orders getOrderById(Integer orderId);
    //查看某状态下所有订单信息
    public List<Orders> getAllOrders(Integer userId,int status);
}
