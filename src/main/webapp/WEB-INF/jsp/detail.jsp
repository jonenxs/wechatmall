<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,height=device-height, user-scalable=no,initial-scale=1, minimum-scale=1, maximum-scale=1">
    <title>商品详情</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/spxq.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/css/swipe.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/touch.js"></script>
</head>
<body>
<div class="body">
    <div class="tour">
        <a href="/wechatmall/items/list" class="tour1"><img src="${pageContext.request.contextPath}/resource/img/back.png" alt="" style="height: 26px;width: 20px"></a>
        <p>商品详情</p>
        <a href="myList.html" class="tour2"><img src="${pageContext.request.contextPath}/resource/img/u65.png" alt="" style="width: 35px;height: 35px"></a>
    </div>
    <figure>
        <div class="addWrap">
            <div class="swipe" id="mySwipe">
                <div class="swipe-wrap">
                <c:forEach items="${ids}" var="id">
                    <div><a href="javascript:;"><img class="img-responsive" src="${pageContext.request.contextPath}/images/${id}/image"/></a></div>
                </c:forEach>
                </div>
            </div>
            <ul id="position">
                <li class="cur"></li>
                <li class=""></li>
                <li class=""></li>
            </ul>
        </div>
        <!-- 轮播 -->
        <script src="${pageContext.request.contextPath}/resource/js/swipe.js"></script>
        <script type="text/javascript">
            var bullets = document.getElementById('position').getElementsByTagName('li');
            var banner = Swipe(document.getElementById('mySwipe'), {
                auto: 3000,
                continuous: true,
                disableScroll:false,
                callback: function(pos) {
                    var i = bullets.length;
                    while (i--) {
                        bullets[i].className = ' ';
                    }
                    bullets[pos].className = 'cur';
                }
            });
        </script>
        <p>${items.itemName}</p>
        <div class="info">
            <em class="sat">￥${items.promotionPrice}</em>
            <a href="/wechatmall/items/${items.itemId}/shopping"><button type="button" class="btn">加入购物车</button></a>
        </div>
    </figure>
    <hr/>
    ${items.itemDescribe}
    <hr/>
    <div class="sjxx">
        <p class="pclass1">一生一客面包店</p>
    </div>
    <hr/>
    <div class="sjxx">
        <p class="pclass2">地址：西南林业大学</p>
        <p class="pclass2">电话：400-8888-8888</p>
    </div>
    <div class="zshlogo">
        <a href="#"><img src="${pageContext.request.contextPath}/resource/img/u63.png" alt="宅生活" style="max-width: 60px"/></a>
        <p style="color: #b2b2b2">一生一刻</p>
    </div>
    <div class="wx_nav" id="wx_nav">
        <a href="/wechatmall/items/list" class="nav_index" id="nav_index">首页</a>
        <a href="/wechatmall/shopping/list" class="nav_shopcart" id="nav_shopcart">购物车</a>
        <a href="/wechatmall/order/10/allOrder" class="nav_me on" id="nav_me on">订单</a>
    </div>
</div>
</body>
</html>
