package com.nxs.mall.service;

import com.nxs.mall.entity.Orders;
import com.nxs.mall.entity.ShoppingCart;
import com.nxs.mall.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 57014 on 2017/2/21.
 */
public interface ShoppingService {
    //添加至购物车并返回购物车内所有商品信息
    public ArrayList<ShoppingCart> addShopping(Integer userId,Integer itemId);
    //根据用户id返回用户购物车内商品
    public ArrayList<ShoppingCart> getShopping(Integer userId);
    //改变购物车内商品的数量
    public String updateShoppingItemsNumber(Integer userId,Integer itemId,int num);
    //删除购物车内商品
    public String deleteShoppingItems(Integer userId,String itemIds);
    //商品从购物车移进订单，并返回相应的商品信息，确认订单操作
    public Orders moveItemsFromShoppingCartsToOrders(Integer userId, String itemIds);
}
