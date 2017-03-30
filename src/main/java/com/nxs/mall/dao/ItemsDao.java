package com.nxs.mall.dao;

import com.nxs.mall.entity.Items;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

/**
 * Created by 57014 on 2017/2/14.
 */
public interface ItemsDao {
    public ArrayList<Items> getAllItems(@Param("offset") int offset, @Param("limit") int limit);
    public Items getItemsById(Integer id);
}
