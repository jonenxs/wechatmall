package com.nxs.mall.dao;

import com.nxs.mall.entity.ShoppingCart;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by 57014 on 2017/2/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class ShoppingDaoTest {



    @Resource
    private ShoppingDao shoppingDao;
    @Test
    public void getAllShoppingItemsByUserId() throws Exception {
        ArrayList<ShoppingCart> list = shoppingDao.getAllShoppingItemsByUserId(1,0,10);
        for (ShoppingCart shoppingCart: list) {
            System.out.println(shoppingCart.getCartItemNumber());
            System.out.println(shoppingCart.getItems().getItemName());
        }
    }

    @Test
    public void getShoppingItemsByUserIdAndItemId() throws Exception {
        int i = shoppingDao.getShoppingItemsByUserIdAndItemId(1,1);
        System.out.println(i);
    }

    @Test
    public void updateShoppingItemsNumber() throws Exception {
        int i = shoppingDao.updateShoppingItemsNumber(1,1,2);
        System.out.println(i);
    }

    @Test
    public void insertShoppingItems() throws Exception {
        int i = shoppingDao.insertShoppingItems(1, 1);
        System.out.println(i);
    }

    @Test
    public void deleteShoppingItems() throws Exception {
        int i = shoppingDao.deleteShoppingItems(1, 1);
        System.out.println(i);
    }

    @Test
    public void getShoppingCartsByItemIds() throws Exception {
        String itemIds = "1,2,";
        String[] str = itemIds.split(",");
        int[] ids = new int[str.length];
        for (int i=0;i<str.length;i++) {
            ids[i] = Integer.valueOf(str[i]);
        }
        Map map = new HashMap();
        map.put("ids", ids);
        Integer userId = 1;
        map.put("userId",userId);
        ArrayList<ShoppingCart> shoppingCarts =  shoppingDao.getShoppingCartsByItemIds(map);
        for(ShoppingCart shoppingCart : shoppingCarts){
            System.out.println(shoppingCart.getCartItemNumber());
        }

    }
}