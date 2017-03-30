package com.nxs.mall.service;

import com.nxs.mall.entity.User;

/**
 * Created by 57014 on 2017/2/27.
 */
public interface UserService {
    //判断用户是否是第一次登录
    public User firstLogin(String openId);
    //添加新用户,返回用户id
    public int addUser(User user);

}
