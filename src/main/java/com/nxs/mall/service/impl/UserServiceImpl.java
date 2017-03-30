package com.nxs.mall.service.impl;

import com.nxs.mall.dao.UserDao;
import com.nxs.mall.entity.User;
import com.nxs.mall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 57014 on 2017/2/27.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User firstLogin(String openId) {
        User user = userDao.getUserByOpenId(openId);
        if (user == null) {
            return null;
        }
        return user;
    }

    @Override
    public int addUser(User user) {
        userDao.addUser(user);
        return user.getUserId();
    }
}
