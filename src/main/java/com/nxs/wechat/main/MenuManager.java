package com.nxs.wechat.main;

import com.nxs.wechat.menu.*;
import com.nxs.wechat.pojo.AccessToken;
import com.nxs.wechat.util.WechatUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 类名: MenuManager </br>
 * 包名： com.nxs.main
 * 描述:菜单管理器类 </br>
 * 开发人员： nxs </br>
 * 创建时间：  2017/1/31 </br>
 * 发布版本：V1.0  </br>
 */
public class MenuManager {
    private static Logger log = LoggerFactory.getLogger(MenuManager.class);

    public static void main(String[] args) {
        // 第三方用户唯一凭证
        String appId = "wxcb7f27aa0fb31b8f";
        // 第三方用户唯一凭证密钥
        String appSecret = "d7fcf545abc18b2607651175d62c5f56";

        // 调用接口获取access_token
        AccessToken at = WechatUtil.getAccessToken(appId, appSecret);

        if (null != at) {
            // 调用接口创建菜单
            int result = WechatUtil.createMenu(getMenu(), at.getToken());

            // 判断菜单创建结果
            if (0 == result)
                log.info("菜单创建成功！");
            else
                log.info("菜单创建失败，错误码：" + result);
        }
    }

    /**
     * 组装菜单数据
     *
     * @return
     */
    private static Menu getMenu() {
        /*CommonButton btn11 = new CommonButton();
        btn11.setName("天气预报");
        btn11.setType("click");
        btn11.setKey("11");

        CommonButton btn12 = new CommonButton();
        btn12.setName("公交查询");
        btn12.setType("click");
        btn12.setKey("12");

        CommonButton btn13 = new CommonButton();
        btn13.setName("周边搜索");
        btn13.setType("click");
        btn13.setKey("13");

        CommonButton btn14 = new CommonButton();
        btn14.setName("历史上的今天");
        btn14.setType("click");
        btn14.setKey("14");

        CommonButton btn21 = new CommonButton();
        btn21.setName("歌曲点播");
        btn21.setType("click");
        btn21.setKey("21");

        CommonButton btn22 = new CommonButton();
        btn22.setName("经典游戏");
        btn22.setType("click");
        btn22.setKey("22");

        CommonButton btn23 = new CommonButton();
        btn23.setName("美女电台");
        btn23.setType("click");
        btn23.setKey("23");

        CommonButton btn24 = new CommonButton();
        btn24.setName("人脸识别");
        btn24.setType("click");
        btn24.setKey("24");

        CommonButton btn25 = new CommonButton();
        btn25.setName("聊天唠嗑");
        btn25.setType("click");
        btn25.setKey("25");

        CommonButton btn31 = new CommonButton();
        btn31.setName("Q友圈");
        btn31.setType("click");
        btn31.setKey("31");

        CommonButton btn32 = new CommonButton();
        btn32.setName("电影排行榜");
        btn32.setType("click");
        btn32.setKey("32");

        CommonButton btn33 = new CommonButton();
        btn33.setName("幽默笑话");
        btn33.setType("click");
        btn33.setKey("33");


        *//**
         * 微信：  mainBtn1,mainBtn2,mainBtn3底部的三个一级菜单。
         *//*

        ComplexButton mainBtn1 = new ComplexButton();
        mainBtn1.setName("生活助手");
        //一级下有4个子菜单
       // mainBtn1.setSub_button(new CommonButton[] { btn11, btn12, btn13, btn14 });


        ComplexButton mainBtn2 = new ComplexButton();
        mainBtn2.setName("休闲驿站");
        mainBtn2.setSub_button(new CommonButton[] { btn21, btn22, btn23, btn24, btn25 });


        ComplexButton mainBtn3 = new ComplexButton();
        mainBtn3.setName("更多体验");
        mainBtn3.setSub_button(new CommonButton[] { btn31, btn32, btn33 });


        *//**
         * 封装整个菜单
         *//*

        menu.setButton(new Button[] { mainBtn1, mainBtn2, mainBtn3 });*/
        ViewButton viewButton11 = new ViewButton();
        viewButton11.setName("店铺首页");
        viewButton11.setType("view");
        viewButton11.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxcb7f27aa0fb31b8f&redirect_uri=http%3a%2f%2fnxs.tunnel.qydev.com%2fwechatmall%2foauthServlet&response_type=code&scope=snsapi_base&state=123#wechat_redirect");
        CommonButton commonButton21 = new CommonButton();
        commonButton21.setName("click菜单");
        commonButton21.setType("click");
        commonButton21.setKey("21");
        CommonButton commonButton31 = new CommonButton();
        commonButton31.setName("扫码事件");
        commonButton31.setType("scancode_push");
        commonButton31.setKey("31");
        CommonButton commonButton32 = new CommonButton();
        commonButton32.setName("地理位置");
        commonButton32.setType("location_select");
        commonButton32.setKey("32");
        ComplexButton complexButton3 = new ComplexButton();
        complexButton3.setName("更多");
        complexButton3.setSub_button(new CommonButton[] { commonButton31, commonButton32});
        Menu menu = new Menu();
        menu.setButton(new Button[] {viewButton11,commonButton21,complexButton3});
        return menu;
    }
}
