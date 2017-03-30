package com.nxs.mall.service.impl;

import com.nxs.mall.entity.OrderDetail;
import com.nxs.mall.entity.Orders;
import com.nxs.mall.entity.ShoppingCart;
import com.nxs.mall.entity.User;
import com.nxs.mall.service.ShoppingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by 57014 on 2017/2/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"
})
public class ShoppingServiceImplTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ShoppingService shoppingService;
    @Test
    public void addShopping() throws Exception {
        ArrayList<ShoppingCart> shoppingCarts = shoppingService.addShopping(1,1);
        System.out.println(shoppingCarts.get(0).getItems().getItemId());

    }

    @Test
    public void updateShoppingItemsNumber() throws Exception {

    }

    @Test
    public void deleteShoppingItems() throws Exception {
        String ids = "1,2";
        String str = shoppingService.deleteShoppingItems(1,ids);
        System.out.println(str);
    }

    @Test
    public void moveItemsFromShoppingCartsToOrders() throws Exception {
        Integer userId = 1;
        String itemIds = "1,2";
        Orders order =  shoppingService.moveItemsFromShoppingCartsToOrders(userId,itemIds);
            for (OrderDetail orderDetail:order.getOrderDetail()){
                System.out.println(orderDetail.getItemId());
                System.out.println(orderDetail.getItemNum());
            }
    }
}