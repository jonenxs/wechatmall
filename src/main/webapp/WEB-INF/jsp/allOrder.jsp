<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,height=device-height, user-scalable=no,initial-scale=1, minimum-scale=1, maximum-scale=1">
    <title>我的订单</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/myList.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery-1.12.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/touch.js"></script>
</head>
<!-- A标签切换 -->
<script>
    $(function(){
        var title=$(".qbdd a");
        var s = $("#status").val();
        if( s == 10){
            title[0].className = "aclass";
        }else if(s == 0){
            title[0].className = "";
            title[1].className = "aclass";
        }else if(s == 2){
            title[0].className = "";
            title[2].className = "aclass";
        }else if(s == 3){
            title[0].className = "";
            title[3].className = "aclass";
        }else if(s == 5){
            title[0].className = "";
            title[4].className = "aclass";
        }
    });
</script>
<body>
<div class="body">
    <div class="tour">
        <a href="javascript:history.go(-1);" class="tour1"><img src="${pageContext.request.contextPath}/resource/img/back.png" alt="" style="height: 26px;width: 20px"></a>
        <p>我的订单</p>
    </div>
    <div class="qbdd">
        <ul>
            <li><a href="/wechatmall/order/10/allOrder" class="aclass">全部订单</a></li>
            <li><a href="/wechatmall/order/0/allOrder">待付款</a></li>
            <li><a href="/wechatmall/order/2/allOrder">待发货</a></li>
            <li><a href="/wechatmall/order/3/allOrder">待收货</a></li>
            <li><a href="/wechatmall/order/5/allOrder">退款</a></li>
        </ul>
    </div>
    <input type="hidden" id="status" value="${status}">
    <c:forEach items="${orders}" var="o">
    <div class="ddbh">
        <ul>
            <li class="li1">订单编号：${o.orderNumber}</li>
            <li class="li2"><a href="#"><button type="button">${o.orderStatus}</button></a></li>
        </ul>
        <div style="clear: both"></div>
    </div>
    <c:forEach items="${o.orderDetail}" var="od">
    <div class="zfdd">
        <ul>
            <li class="li3"><a href="/wechatmall/items/${od.items.itemId}/detail"><img src="${pageContext.request.contextPath}/images/${od.items.imageId}/image" alt="" style="width: 60px;height: 60px"/></a></li>
            <li class="li4"><span>×${od.itemNum}</span><br/><span>${od.items.itemName}</span><br/><span style="color: red">￥${od.items.promotionPrice}</span></li>
        </ul>
        <div style="clear: both"></div>
    </div>
    </c:forEach>
    <div class="ddfk">
        <ul>
            <li class="li5">订单付款：￥${o.price}</li>
            <%--<li class="li6"><a href="javascript:;"><button type="button">待付款</button></a></li>--%>
            <li class="li6"><a href=/wechatmall/order/${o.orderId}><button type="button">查看</button></a></li>
        </ul>
        <div style="clear: both"></div>
    </div>
    </c:forEach>
    <c:if test="${empty orders}">
        <div class="ddfk">
            <ul>
                <li class="li5">您还没有相关的订单！</li>
            </ul>
            <div style="clear: both"></div>
        </div>
    </c:if>
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
</body>
</html>