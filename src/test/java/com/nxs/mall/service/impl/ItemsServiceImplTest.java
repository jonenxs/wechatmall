package com.nxs.mall.service.impl;

import com.nxs.mall.entity.Items;
import com.nxs.mall.service.ItemsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by 57014 on 2017/2/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"
})
public class ItemsServiceImplTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ItemsService itemsService;
    @Test
    public void getAllItems() throws Exception {
        ArrayList<Items> itemss = itemsService.getAllItems();
        logger.info("itemss={}" + itemss);
    }

    @Test
    public void getItemsById() throws Exception {
        int id = 1;
        Items items = itemsService.getItemsById(id);
        logger.info("1:" + items);
    }

}