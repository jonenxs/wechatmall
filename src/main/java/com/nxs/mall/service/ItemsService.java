package com.nxs.mall.service;

import com.nxs.mall.entity.Items;

import java.util.ArrayList;

/**
 * 业务接口：站在“使用者”角度设计接口
 * 三个方面：方法定义粒度，参数，返回类型（return 类型、异常）
 *
 * Created by 57014 on 2017/2/15.
 */
public interface ItemsService {

    public ArrayList<Items> getAllItems();

    public Items getItemsById(Integer id);
}
