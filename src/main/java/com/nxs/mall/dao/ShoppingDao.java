package com.nxs.mall.dao;

import com.nxs.mall.entity.ShoppingCart;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by 57014 on 2017/2/14.
 */
public interface ShoppingDao {
    //根据用户id查询购物车内所有商品
    public ArrayList<ShoppingCart> getAllShoppingItemsByUserId(@Param("userId") Integer userId, @Param("offset") int offset, @Param("limit") int limit);
    //根据用户id和商品id查询购物车内某件商品是否存在
    public int getShoppingItemsByUserIdAndItemId(@Param("userId") Integer userId,@Param("itemId") Integer itemId);
    //根据用户id和商品id更新购物车内某件商品的数量
    public int updateShoppingItemsNumber(@Param("userId") Integer userId,@Param("itemId") Integer itemId,@Param("num") int num);
    //根据用户id和商品id向购物车内插入一条商品记录
    public int insertShoppingItems(@Param("userId") Integer userId,@Param("itemId") Integer itemId);
    //根据用户id和商品id从购物车内删除一条商品记录
    public int deleteShoppingItems(@Param("userId") Integer userId, @Param("itemId") Integer itemId);
    //根据商品id数组返回相应的购物车内数量
    public ArrayList<ShoppingCart> getShoppingCartsByItemIds(Map map);
}
