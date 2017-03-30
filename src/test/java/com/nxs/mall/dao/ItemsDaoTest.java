package com.nxs.mall.dao;

import com.nxs.mall.entity.Items;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * 配置spring和junit整合junit启动时加载springIOC容器
 * spring-test,junit
 * Created by 57014 on 2017/2/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class ItemsDaoTest {
    //注入Dao实现类依赖
    @Resource
    private ItemsDao itemsDao;
    @Test
    public void getAllItems() throws Exception {
        ArrayList<Items> itemss = itemsDao.getAllItems(0,20);
        for (Items items : itemss){
            System.out.println(items.getItemName());
        }
    }

    @Test
    public void getItemsById() throws Exception {
        int id = 1;
        Items items = itemsDao.getItemsById(id);
        System.out.println(items);
    }

}