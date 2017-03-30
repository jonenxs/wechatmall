package com.nxs.test;

import com.nxs.wechat.util.CommonUtil;

/**
 * Created by dell on 2017/1/31.
 */
public class UrlTest {

    /**
     * 方法名：main</br>
     * 详述：生成URL编码 </br>
     * 开发人员：nxs </br>
     * 创建时间：2017/1/31  </br>
     * @param args 说明返回值含义
     * @throws 说明发生此异常的条件
     */
    public static void main(String[] args) {
        String source="http://nxs.tunnel.qydev.com/oauthServlet";
        System.out.println(CommonUtil.urlEncodeUTF8(source));
    }
}
