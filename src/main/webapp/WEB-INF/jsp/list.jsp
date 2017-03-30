<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,height=device-height, user-scalable=no,initial-scale=1, minimum-scale=1, maximum-scale=1">
    <title>商铺首页</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/style.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/Up.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery-1.12.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/touch.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/srcolltop.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/timer.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/xlmenu.js"></script>
    <script>
        $(function () {
            $("figure:eq(0)").css({
                border:'none'
            });
            $("figure:eq(1)").css({
                border:'none'
            });
            var titleName=$(".ycmenu a");
            for(var i =0;i<titleName.length;i++){
                titleName[i].id=i;
                titleName[i].onmouseover=function(){
                    for(var j =0;j<titleName.length;j++){
                        titleName[j].className="";
                    }
                    this.className = "a";
                }}
        })
    </script>
</head>
<body>
<header>
    <div>
        <a href="#">发现身边美好的生活！<button>一生一刻</button></a>
    </div>
</header>
<div class="container">
    <div class="allLogo">
        <div class="logo"><img src="${pageContext.request.contextPath}/resource/img/u16.png" alt="logo"/></div>
        <div class="head"><a href="javascript:;"><img src="${pageContext.request.contextPath}/resource/img/u61.png" alt="头像"/></a></div>
        <div class="headInfo"><a href="#">一生一刻</a></div>
    </div>

    <%--<div class="SeckillOne">
        <div>
            <img src="${pageContext.request.contextPath}/resource/img/1.jpg" alt="">
        </div>
        <div id="CountMsg" class="HotDate">
            <br><a>倒计时</a><br>
            <span class="t_d">00天</span><br>
            <span class="t_h">00:</span>
            <span class="t_m">00:</span>
            <span class="t_s">00</span>
        </div>
        <div class="hurry">
            <a href="Mgroup.html"><button>立即参团 <img src="${pageContext.request.contextPath}/resource/img/jian.png"></button></a>
        </div>
        <div class="number">
            <p>已抢 25 份 剩余 25 份</p>
        </div>
    </div>--%>
    </div>
    <div class="store">
        <ul>
            <li class="li1"><a href="#">商品</a></li>
            <li class="li2"><a href="javascript:;" class="xlmenu">全部&nbsp;<img src="${pageContext.request.contextPath}/resource/img/donw.png" style="width: 12px;display: inline"></a>&nbsp;共<span style="color: #e4393c;font-size: 1.8rem">40</span>件</li>
        </ul>
        <div class="ycmenu">
            <ul>
                <li><a href="allGoods.html" class="a">全部商品</a></li>
                <li><a href="nydg.html">奶油蛋糕</a></li>
                <li><a href="nydg.html">奶油蛋糕</a></li>
                <li><a href="nydg.html">奶油蛋糕</a></li>
                <li><a href="nydg.html">奶油蛋糕</a></li>
                <li><a href="nydg.html">奶油蛋糕</a></li>
                <li><a href="nydg.html">奶油蛋糕</a></li>
            </ul>
        </div>
    </div>
    <div class="clear"></div>
    <div class="border">

    </div>
    <div class="allsp">
        <c:forEach items="${list}" var="is">
            <figure>
                <a href="/wechatmall/items/${is.itemId}/detail"><img src="${pageContext.request.contextPath}/images/${is.imageId}/image" alt="商品" class="xqtp"/></a>
                <p>${sk.name}</p>
                <div class="info">
                    <em class="sat">${is.promotionPrice}&nbsp;<small>￥${is.originalPrice}</small></em>
                    <a href="#"><img src="${pageContext.request.contextPath}/resource/img/u20.png" alt="购物车" style="width: 30px;height: 30px" align="right"/></a>
                </div>
            </figure>
        </c:forEach>
        <div class="clear"></div>
    </div>
    <div class="wx_nav" id="wx_nav">
        <a href="/wechatmall/items/list" class="nav_index" id="nav_index">首页</a>
        <a href="/wechatmall/shopping/list" class="nav_shopcart" id="nav_shopcart">购物车</a>
        <a href="/wechatmall/order/10/allOrder" class="nav_me on" id="nav_me on">订单</a>
    </div>
</div>
<footer>
    <div class="footer">
        <p>没有更多了</p>
    </div>
</footer>
<div class="actGotop"><a href="javascript:;" title="返回顶部"></a> <img src="${pageContext.request.contextPath}/resource/img/fanhui.png" alt=""></div>
<div class="theme-popover-mask"></div>
</body>
</html>