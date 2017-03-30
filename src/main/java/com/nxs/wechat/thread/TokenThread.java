package com.nxs.wechat.thread;

import com.nxs.wechat.util.CommonUtil;
import com.nxs.wechat.pojo.Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 类名: TokenThread </br>
 * 描述: 定时获取微信access_token的线程 </br>
 * 开发人员： nxs </br>
 * 创建时间：  2017/1/31 </br>
 * 发布版本：V1.0  </br>
 */
public class TokenThread implements Runnable {
    private static Logger log = LoggerFactory.getLogger(TokenThread.class);
    // 第三方用户唯一凭证
    public static String appid = "wxcb7f27aa0fb31b8f";
    // 第三方用户唯一凭证密钥
    public static String appsecret = "d7fcf545abc18b2607651175d62c5f56";
    public static Token accessToken = null;

    public static Token getAccessToken() {
        return accessToken;
    }

    public void run() {
        while (true) {
            try {
                accessToken = CommonUtil.getToken(appid, appsecret);
                if (null != accessToken) {
                    log.info("获取access_token成功，有效时长{}秒 token:{}", accessToken.getExpiresIn(), accessToken.getAccessToken());
                    // 休眠7000秒
                    Thread.sleep((accessToken.getExpiresIn() - 200)*1000);
                } else {
                    // 如果access_token为null，60秒后再获取
                    Thread.sleep(60 * 1000);
                }
            } catch (InterruptedException e) {
                try {
                    Thread.sleep(60 * 1000);
                } catch (InterruptedException e1) {
                    log.error("{}", e1);
                }
                log.error("{}", e);
            }
        }
    }
}
