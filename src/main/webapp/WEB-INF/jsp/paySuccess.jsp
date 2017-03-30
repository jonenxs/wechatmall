<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,height=device-height, user-scalable=no,initial-scale=1, minimum-scale=1, maximum-scale=1">
    <title>支付成功</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/successful.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery-1.12.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/zfewm.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/touch.js"></script>
</head>
<body>
<div class="body">
    <div class="tour">
        <a href="/wechatmall/order/10/allOrder" class="tour1"><img src="${pageContext.request.contextPath}/resource/img/back.png" alt="" style="height: 26px;width: 20px"></a>
        <p>支付成功</p>
    </div>
    <div class="header3">
        <div class="succeed">
            <li><img src="${pageContext.request.contextPath}/resource/img/zhifu.jpg" alt="支付成功" style="width: 80px;margin: 0 auto;"/><p>支付成功!</p></li>
        </div>
    </div>
    <div style="width: 100%;height: 2rem;border-bottom: 1px solid #000000"></div>
</div>
<input type="hidden" id="orderId" value="${order.orderId}">
<c:forEach items="${order.orderDetail}" var="od">
<div class="spmc">
    <p>商品名称：${od.items.itemName} &nbsp;&nbsp;&nbsp;×${od.itemNum}</p>
</div>
</c:forEach>
<div class="spmc">
    <p>订单金额：${price}</p>
</div>
<div class="ewm">
    <ul>
        <li class="li1">订单号：${order.orderNumber}</li>
        <%--<li class="li2"><a href="javascript:;" class="tcewm"><img class="tcewm" src="${pageContext.request.contextPath}/resource/img/erweima.jpg" alt="二维码" style="width: 40px;height: 40px"/></a></li>--%>
    </ul>
</div>
<div class="ckdd">
    <div style="width:11rem;margin:0 auto"><a href="/wechatmall/order/${order.orderId}"><button type="button">查看订单</button></a></div>
</div>
<div class="wxts">
    <div class="neirong">
        <p style="color: #ff0000">!温馨提示</p>
        <p>1. 商家发货后7天，平台会自动确认收货，若7天后未收到您购买的商品，请及时联系宅生活平台客服。</p>
        <p>2. 由于网络延迟会出现订单已支付成功，但返回查看订单为“待支付”状态，此种情况无需再次支付，请您耐心等待几分钟，平台会自动更新数据到“已支付“状态。</p>
    </div>
</div>
<div class="kefu">
    <p>如有其他问题请拨打客服电话</p>
    <p style="color: green">400-8888-8888</p>
    <%--<div class="zshlogo">
        <a href="#"><img src="${pageContext.request.contextPath}/resource/img/u63.png" alt="宅生活" style="max-width: 60px"/></a>
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
        <img src="${pageContext.request.contextPath}/resource/img/erweima.jpg" alt="消费二维码" style="margin: 0 auto;">
    </div>

</div>
<div class="theme-popover-mask"></div>
</body>
</html>