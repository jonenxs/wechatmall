package com.nxs.mall.dao;

import com.nxs.mall.entity.OrderDetail;
import com.nxs.mall.entity.Orders;
import com.nxs.mall.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 57014 on 2017/2/21.
 */
public interface OrdersDao {
    //通过用户id查询相应的订单信息
   public List<User> getOrdersByUserId(@Param("userId") Integer userId, @Param("status") int status);
    //向订单里面插入一条订单记录
    public int insertOrders(Orders orders);
    //向订单明细表里插入数据
    public int insertOrderDetail(ArrayList<OrderDetail> list);
    //根据订单id查询订单
    public Orders getOrdersByOrderId(@Param("orderId") Integer orderId);
    //支付成功后更新订单信息
    public int updateOrders(Orders orders);
}
