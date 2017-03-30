package com.nxs.mall.web;

import com.nxs.mall.entity.User;
import com.nxs.mall.service.UserService;
import com.nxs.wechat.pojo.SNSUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by 57014 on 2017/2/27.
 */
@Component
@RequestMapping("/user")//url:模块/资源/{}/细分
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value="/login")
    public String login(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        SNSUserInfo snsUserInfo = (SNSUserInfo) request.getAttribute("snsUserInfo");
        User user = userService.firstLogin(snsUserInfo.getOpenId());
        //不是第一次登陆
        if(user != null){
            session.setAttribute("userId",user.getUserId());
        }
        //用户为第一次登录
        else{
            User user1 = new User();
            user1.setUserName(snsUserInfo.getNickname());
            user1.setOpenId(snsUserInfo.getOpenId());
            session.setAttribute("userId",userService.addUser(user1));
        }
        return "redirect:/items/list";
    }
}
