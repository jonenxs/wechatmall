package com.nxs.wechat.servlet;

import com.nxs.wechat.pojo.SNSUserInfo;
import com.nxs.wechat.pojo.WechatOauth2Token;
import com.nxs.wechat.util.AdvancedUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 类名: OAuthServlet </br>
 * 描述: 授权后的回调请求处理 </br>
 * 开发人员： nxs </br>
 * 创建时间：  2017/1/31 </br>
 * 发布版本：V1.0  </br>
 */
public class OAuthServlet extends HttpServlet {
    private static final long serialVersionUID = -1847238807216447030L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        // 用户同意授权后，能获取到code
        String code = request.getParameter("code");
        String state = request.getParameter("state");

        // 用户同意授权
        if (!"authdeny".equals(code)) {
            // 获取网页授权access_token
            WechatOauth2Token wechatOauth2Token = AdvancedUtil.getOauth2AccessToken("wxcb7f27aa0fb31b8f", "d7fcf545abc18b2607651175d62c5f56", code);
            // 网页授权接口访问凭证
            String accessToken = wechatOauth2Token.getAccessToken();
            // 用户标识
            String openId = wechatOauth2Token.getOpenId();
            // 获取用户信息
            SNSUserInfo snsUserInfo = AdvancedUtil.getSNSUserInfo(accessToken, openId);

            // 设置要传递的参数
            request.setAttribute("snsUserInfo", snsUserInfo);
            request.setAttribute("state", state);
        }
        // 跳转到index.jsp
        request.getRequestDispatcher("user/login").forward(request, response);
    }
}
