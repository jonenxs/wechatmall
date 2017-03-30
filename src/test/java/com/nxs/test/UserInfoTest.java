package com.nxs.test;

import com.nxs.wechat.pojo.WechatUserInfo;
import com.nxs.wechat.util.CommonUtil;

/**
 * Created by dell on 2017/1/31.
 */
public class UserInfoTest {
    public static void main(String args[]) {
        // 获取接口访问凭证
        String accessToken = CommonUtil.getToken("wxcb7f27aa0fb31b8f", "d7fcf545abc18b2607651175d62c5f56").getAccessToken();
        /**
         * 获取用户信息
         */
        WechatUserInfo user = CommonUtil.getUserInfo(accessToken, "ooK-yuJvd9gEegH6nRIen-gnLrVw");
        System.out.println("OpenID：" + user.getOpenId());
        System.out.println("关注状态：" + user.getSubscribe());
        System.out.println("关注时间：" + user.getSubscribeTime());
        System.out.println("昵称：" + user.getNickname());
        System.out.println("性别：" + user.getSex());
        System.out.println("国家：" + user.getCountry());
        System.out.println("省份：" + user.getProvince());
        System.out.println("城市：" + user.getCity());
        System.out.println("语言：" + user.getLanguage());
        System.out.println("头像：" + user.getHeadImgUrl());
    }
}
