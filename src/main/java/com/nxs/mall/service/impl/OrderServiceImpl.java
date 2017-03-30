package com.nxs.mall.service.impl;

import com.nxs.mall.dao.OrdersDao;
import com.nxs.mall.entity.Orders;
import com.nxs.mall.entity.User;
import com.nxs.mall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 57014 on 2017/2/23.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrdersDao ordersDao;
    @Override
    public Orders updateOrder(Orders orders) {
        if(ordersDao.updateOrders(orders) == 0){
            return null;
        }
        return ordersDao.getOrdersByOrderId(orders.getOrderId());
    }

    @Override
    public Orders getOrderById(Integer orderId) {
        return ordersDao.getOrdersByOrderId(orderId);
    }

    @Override
    public List<Orders> getAllOrders(Integer userId, int status) {
        List<User> users = ordersDao.getOrdersByUserId(userId,status);
        if(users.size() == 0){
            return null;
        }
        User user = users.get(0);
        return user.getOrders();
    }
}
