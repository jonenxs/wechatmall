<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,height=device-height, user-scalable=no,initial-scale=1, minimum-scale=1, maximum-scale=1">
    <title>商品订单</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/spdd.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery-1.12.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/tcewm.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/touch.js"></script>
</head>
<body>
<div class="body">
    <div class="tour">
        <a href="javascript:history.go(-1);" class="tour1"><img src="${pageContext.request.contextPath}/resource/img/back.png" alt="" style="height: 26px;width: 20px"></a>
        <p>商品订单</p>
    </div>
    <div class="ewm">
        <ul>
            <li class="lif">
                <ul>
                    <li>订单状态：${order.orderStatus}</li>
                    <li>订&nbsp;单&nbsp;号：${order.orderNumber}</li>
                </ul>
            </li>
            <%--<li class="lim"><a href="javascript:" class="erweima"><img class="erweima" src="${pageContext.request.contextPath}/resource/img/erweima.jpg" alt="二维码" style="width: 40px;height: 40px"/></a></li>--%>
        </ul>
    </div>
    <div class="address" id="address2">
        <a href="http://map.baidu.com/" class="daohang"><img src="${pageContext.request.contextPath}/resource/img/timg.jpg" alt="" style="width: 40px;display: inline-block" /></a>
        <div class="caizhu">
            <span class="person" id="span1">收货人：${address.addressName}&nbsp;&nbsp;电话：${address.phoneNumber}</span><br/>
            <span class="diqiu" id="span2">收货地址：${address.address}</span>
        </div>
        <%--<a href="Oldindex.html" class="xdz">&gt;</a>--%>
    </div>
    <div class="hbt" style="width: 100%;height: 1rem;background-color: #eaeaea"></div>
   <c:forEach items="${order.orderDetail}" var="od">
    <div class="zfdd">
        <ul>
            <li class="li1"><a href="/wechatmall/items/${od.items.itemId}/detail"><img src="${pageContext.request.contextPath}/resource/img/u67.png" alt="" style="width: 60px;height: 60px"/></a></li>
            <li class="li2"><span>${od.items.itemName}</span></li>
            <li class="li3"><span>×${od.itemNum}</span><br/><span style="color: red">￥${od.items.promotionPrice}</span></li>
        </ul>
        <div style="clear: both"></div>
    </div>
   </c:forEach>
    <div class="yunfei">
        <ul>
            <li class="yunli">运费:</li>
            <li class="qianli">￥8.00</li>
        </ul>
    </div>
    <div class="yunfei">
        <ul>
            <li class="yunli">留言:</li>
            <li class="qianli">${order.note}</li>
        </ul>
    </div>
    <div class="zjfy">
        <div class="fy">
            <p><span style="color: #000000">合计：</span>￥${price}</p>
        </div>
    </div>
    <div class="qxdd">
        <div style="width:11rem;margin:0 auto"><a href="/wechatmall/order/${order.orderId}/delOrder"><button type="button">取消订单</button></a></div>
    </div>
    <%--<div class="zshlogo">
        <a href="javascript:;"><img src="${pageContext.request.contextPath}/resource/img/u63.png" alt="宅生活" style="max-width: 60px"/></a>
        <p style="color: #b2b2b2">宅生活提供技术支持</p>
    </div>--%>
    <div class="wx_nav" id="wx_nav">
        <a href="/wechatmall/items/list" class="nav_index" id="nav_index">首页</a>
        <a href="/wechatmall/shopping/list" class="nav_shopcart" id="nav_shopcart">购物车</a>
        <a href="/wechatmall/order/10/allOrder" class="nav_me on" id="nav_me on">订单</a>
    </div>
</div>
<div class="dewm">
    <div>
        <div style="margin: 0 auto;text-align: center;padding: 0.5rem 0 0.5rem 0;font-weight: bolder;font-size:1.3rem;width: 200px;background-color:#ffffff">消费码:1234 4567 8901</div>
        <%--<img src="${pageContext.request.contextPath}/resource/img/erimg/erweima.jpg" alt="消费二维码" style="width: 200px;height: 200px;margin: 0 auto;background-color:red"/>--%>
       <%-- <div style="margin: 0 auto;text-align: center;padding: 0.5rem 0 0.5rem 0;white-space: nowrap;font-size:1.3rem;width: 200px;background-color:#ffffff">请出示订单二维码，给商家扫描</div>--%>
    </div>

</div>
<div class="theme-popover-mask"></div>
</body>
</html>
