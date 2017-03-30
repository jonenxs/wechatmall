package com.nxs.mall.dao;

import com.nxs.mall.entity.User;

/**
 * Created by 57014 on 2017/2/27.
 */
public interface UserDao {
    //添加新用户
    public int addUser(User user);
    public User getUserByOpenId(String openId);
}
