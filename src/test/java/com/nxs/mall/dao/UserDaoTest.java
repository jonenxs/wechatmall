package com.nxs.mall.dao;

import com.nxs.mall.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by 57014 on 2017/2/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class UserDaoTest {
    @Autowired
    private UserDao userDao;
    @Test
    public void addUser() throws Exception {
        User user = new User();
        user.setUserName("小明");
        user.setOpenId("7587jkfchgt7jhg64871gjhr6u5");
        userDao.addUser(user);
        System.out.println(user.getUserId());
    }

    @Test
    public void getUserByOpenId() throws Exception {
        User user = userDao.getUserByOpenId("7587jkfchgt7jhg64871gjhr6u5");
        System.out.println(user.getUserId());
        System.out.println(user.getOpenId());
        System.out.println(user.getOpenId());
    }

}