package com.nxs.mall.service.impl;

import com.nxs.mall.dao.OrdersDao;
import com.nxs.mall.dao.ShoppingDao;
import com.nxs.mall.entity.OrderDetail;
import com.nxs.mall.entity.Orders;
import com.nxs.mall.entity.ShoppingCart;
import com.nxs.mall.entity.User;
import com.nxs.mall.service.ShoppingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by 57014 on 2017/2/21.
 */
@Service
public class ShoppingServiceImpl implements ShoppingService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ShoppingDao shoppingDao;

    @Autowired
    private OrdersDao ordersDao;

    @Override
    public ArrayList<ShoppingCart> addShopping(Integer userId, Integer itemId) {
        int i = shoppingDao.getShoppingItemsByUserIdAndItemId(userId,itemId);
        if(i == 0){
            //购物车内没有该商品
            int j = shoppingDao.insertShoppingItems(userId,itemId);
            if(j > 0){
                return shoppingDao.getAllShoppingItemsByUserId(userId,0,10);
            }else{
                return null;
            }
        }else {
            //购物车内已存在该商品
            int x = shoppingDao.updateShoppingItemsNumber(userId,itemId,1);
            if(x > 0){
                return shoppingDao.getAllShoppingItemsByUserId(userId,0,10);
            }else{
                return null;
            }
        }
    }

    @Override
    public ArrayList<ShoppingCart> getShopping(Integer userId) {
        return shoppingDao.getAllShoppingItemsByUserId(userId,0,10);
    }

    @Override
    public String updateShoppingItemsNumber(Integer userId, Integer itemId, int num) {
        int i = shoppingDao.updateShoppingItemsNumber(userId,itemId,num);
        if (i != 0){
            return "success";
        }
        return "error";
    }

    @Override
    public String deleteShoppingItems(Integer userId, String itemIds) {
        String[] ids = itemIds.split(",");
        int i = 0;
        for (String id:ids) {
            i += shoppingDao.deleteShoppingItems(userId, Integer.valueOf(id));
        }
        if(i<ids.length){
            return "false";
        }
        return "success";
    }

    @Override
    public Orders moveItemsFromShoppingCartsToOrders(Integer userId, String itemIds) {
        //获取需要加入订单的商品及其数量
        String[] str = itemIds.split(",");
        int[] ids = new int[str.length];
        for (int i=0;i<str.length;i++) {
            ids[i] = Integer.valueOf(str[i]);
        }
        Map map = new HashMap();
        map.put("ids", ids);
        map.put("userId",userId);
        ArrayList<ShoppingCart> shoppingCarts =  shoppingDao.getShoppingCartsByItemIds(map);
        //新建订单
        Orders orders = new Orders();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String orderNumber = sdf.format(date)+userId;
        orders.setCreateTime(date);
        orders.setUserId(userId);
        orders.setOrderNumber(orderNumber);
        orders.setOrderStatus("0");
        ordersDao.insertOrders(orders);
        //向订单明细表中插入相应的商品
        ArrayList<OrderDetail> list = new ArrayList<OrderDetail>();
        for (ShoppingCart shoppingCart:shoppingCarts) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrderId(orders.getOrderId());
            orderDetail.setItemId(shoppingCart.getItemId());
            orderDetail.setItemNum(shoppingCart.getCartItemNumber());
            list.add(orderDetail);
        }
        ordersDao.insertOrderDetail(list);
        //添加订单成功后删除购物车内相应的商品
        this.deleteShoppingItems(userId,itemIds);
        //最终返回还未支付的订单
        return ordersDao.getOrdersByOrderId(orders.getOrderId());
    }

}
