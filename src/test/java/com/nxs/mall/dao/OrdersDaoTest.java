package com.nxs.mall.dao;

import com.nxs.mall.entity.OrderDetail;
import com.nxs.mall.entity.Orders;
import com.nxs.mall.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 57014 on 2017/2/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class OrdersDaoTest {



    @Resource
    private OrdersDao ordersDao;
    @Test
    public void getOrdersByUserId() throws Exception {
        List<User> users = ordersDao.getOrdersByUserId(1, 0);
        for (User user:users) {
            System.out.println(user.getUserId());
            System.out.println(user.getUserName());
            for (Orders orders:user.getOrders()) {
                System.out.println(orders.getOrderId());
                System.out.println(orders.getCreateTime());
                System.out.println(orders.getAddressId());
                for (OrderDetail orderDetail: orders.getOrderDetail()) {
                    System.out.println(orderDetail.getItemNum());
                    System.out.println(orderDetail.getItems().getItemName());
                }
            }
        }
    }

    @Test
    public void insertOrders() throws Exception {
        Orders orders = new Orders();
        orders.setAddressId(2);
        orders.setCreateTime(new Date());
        orders.setNote("快快快！");
        orders.setUserId(1);
        orders.setOrderNumber("20170223134301");
        orders.setOrderStatus("0");
        ordersDao.insertOrders(orders);
        System.out.println(orders.getOrderId());
    }

    @Test
    public void insertOrderDetail() throws Exception {
        ArrayList<OrderDetail> list = new ArrayList<OrderDetail>();
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderId(1);
        orderDetail.setItemId(1);
        orderDetail.setItemNum(2);
        list.add(orderDetail);
        OrderDetail orderDetail1 = new OrderDetail();
        orderDetail1.setOrderId(1);
        orderDetail1.setItemId(2);
        orderDetail1.setItemNum(1);
        list.add(orderDetail1);
        ordersDao.insertOrderDetail(list);
    }

    @Test
    public void testGetOrdersByOrderId() throws Exception {
        Orders orders  = ordersDao.getOrdersByOrderId(72);
        for (OrderDetail orderDetail:orders.getOrderDetail()) {
            System.out.println(orderDetail.getItems().getItemName());
            System.out.println(orderDetail.getItems().getImageId());
        }
    }

    @Test
    public void testUpdateOrders() throws Exception {
        Orders orders = new Orders();
        orders.setOrderId(72);
        orders.setAddressId(2);
        orders.setNote("坎坎坷坷");
        orders.setOrderStatus("2");
        System.out.println(ordersDao.updateOrders(orders));
    }
}