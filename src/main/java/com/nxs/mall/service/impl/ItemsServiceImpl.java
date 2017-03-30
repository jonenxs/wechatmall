package com.nxs.mall.service.impl;


import com.nxs.mall.dao.ItemsDao;
import com.nxs.mall.entity.Items;
import com.nxs.mall.service.ItemsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

/**
 * Created by 57014 on 2017/2/15.
 */
//@Component @Service @Dao @Controler
@Service
public class ItemsServiceImpl implements ItemsService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ItemsDao itemsDao;
    @Override
    //@Transactional
    /*
    * 使用注解控制事务的优点
    * 1：开发团队达成一致约定，明确标注事务方法的编程风格
    * 2：保证事务方法的执行时间尽可能短，不要穿插其他网络操作RPC/HTTP请求/或者剥离到事务方法外部。
    * 3：不是所有的方法都需要事务，如只有一条修改操作，只读操作不需要事务控制
    * */
    public ArrayList<Items> getAllItems() {
        return itemsDao.getAllItems(0,20);
    }

    @Override
    public Items getItemsById(Integer id) {
        return itemsDao.getItemsById(id);
    }
}
