<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,height=device-height, user-scalable=no,initial-scale=1, minimum-scale=1, maximum-scale=1">
    <title>支付</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/Pay.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery-1.12.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/zfxx.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/zftc.js"></script>
</head>
<body>
<div class="body">
    <div class="tour">
        <a href="/wechatmall/shopping/list" class="tour1"><img src="${pageContext.request.contextPath}/resource/img/back.png" alt="" style="height: 26px;width: 20px"></a>
        <p>订单确认</p>
    </div>
    <div class="header3">
        <a href="javascript:;" class="shsm"><button type="button" id="btn1"  class="btn1">送货上门</button></a>
        <a href="javascript:;" class="ddzq"><button type="button" id="btn2" class="btn2">到店自取</button></a>
        <input type="hidden" id="send" value="1">
    </div>
    <div class="address" id="address2">
        <a href="http://map.baidu.com/" class="daohang"><img src="${pageContext.request.contextPath}/resource/img/timg.jpg" alt="" style="width: 40px;display: inline-block" /></a>
        <div class="caizhu">
            <input type="hidden" id="addressId" value="${address.addressId}">
            <p class="person" id="span1">收货人：${address.addressName}&nbsp;&nbsp;电话：${address.phoneNumber}</p><br/>
            <p class="diqiu" id="span2">收货地址：${address.address}</p>
        </div>
        <a href="javascript:;" class="xdz">&gt;</a>
    </div>
    <div class="address2" id="zt">
        <a href="http://map.baidu.com/" class="daohang"><img src="${pageContext.request.contextPath}/resource/img/timg.jpg" alt="" style="width: 40px;display: inline-block" /></a>
        <div class="caizhu">
            <p class="store" id="span3">店铺电话：15687103439</p><br/>
            <p class="saddress" id="span4">店铺地址：西南林业大学</p>
        </div>
        <a href="javascript:;" class="xdz">&gt;</a>
    </div>
    <div class="hbt" style="width: 100%;height: 1rem;background-color:lightgrey"></div>
    <c:forEach items="${orderDetails}" var="ods">
        <input type="hidden" id="orderId" value="${ods.orderId}">
    <div class="zfdd">
        <ul>
            <li class="li1"><a href="/wechatmall/items/${ods.items.itemId}/detail"><img src="${pageContext.request.contextPath}/images/${ods.items.imageId}/image" alt="" style="width: 60px;height: 60px"/></a></li>
            <li class="li2"><span>${ods.items.itemName}</span></li>
            <li class="li3"><span>×${ods.itemNum}</span><br/><span style="color: red">￥${ods.items.promotionPrice}</span></li>
        </ul>
    </div>
    </c:forEach>
    <div class="yunfei" id="yunfei">
        <ul>
            <li class="yunli">运费</li>
            <li class="qianli">￥8.00</li>
        </ul>
    </div>
    <div class="sjly">
        <input type="text" id="note" name="note" placeholder="给商家留言"/>
    </div>
    <div class="zjfy">
        <div class="fy">
            <input type="hidden" id="totalPrice" value="${totalPrice}">
            <p id="price"><span style="color: #000000">合计：</span>￥${totalPrice}</p>
        </div>
    </div>
    <div class="menu" id="zfym">
        <ul>
            <li><a href="javascript:pay();" class="aclass" >微信支付</a></li>
            <li><a href="javascript:pay();">支付宝支付</a></li>
            <li><a href="javascript:pay();">银联卡支付</a></li>
            <li><a href="javascript:pay();">招行卡支付</a></li>
        </ul>
    </div>
    <div class="changeadd">
        <div class="shdz">
            <p>选择收货地址</p><div class="gbdd"><span id="btn4">×</span></div>
        </div>
        <div id="dzlb">
        <c:forEach items="${addresses}" var="as">
        <div class="dzlb" id="${as.addressId}" onclick="changeAddress(${as.addressId})">
            <div class="harvest">
                <p class="person" id="person${as.addressId}">收货人：${as.addressName}&nbsp;&nbsp;电话：${as.phoneNumber}</p><br/>
                <p class="diqiu" id="diqiu${as.addressId}">收货地址：${as.address}</p>
            </div>
            <div style="clear: both"></div>
        </div>
        <hr/>
        </c:forEach>
        </div>
        <div class="gldz">
            <ul>
                <li class="li10"><a href="javascript:">+</a></li>
                <li class="li11">新增地址</li>
                <li class="li12"><button type="button" id="btn5" >&gt;</button></li>
            </ul>
            <div style="clear: both"></div>
        </div>
    </div>
    <form id="addressForm">
    <div class="zjdd">
        <div class="shdz">
            <p>收货地址</p><div class="gbdd"><span id="btn6">×</span></div>
        </div>

        <div class="sfxx">

            <table style="BORDER-COLLAPSE: collapse" borderColor=#000000 cellSpacing=0 width=280 align=center bgColor=#ffffff border=1>
                <tr>
                    <td class="td1">收货人</td>
                    <td class="td2"><input type="text" id="addressName" name="addressName" placeholder="姓名"/></td>
                </tr>
                <tr>
                    <td class="td1">联系电话</td>
                    <td class="td2"><input type="text" id="phoneNumber" name="phoneNumber" placeholder="手机或固话"/></td>
                </tr>
                <tr>
                    <td class="td1">详细住址</td>
                    <td class="td2"><input type="text" id="address" name="address" placeholder="仔细填写"/></td>
                </tr>
                <tr>
                    <td class="td1">是否默认</td>
                    <td class="td2"><input type="radio" name="def" value="1" style="width:13px;height:13px" checked/>&nbsp;是&nbsp;&nbsp;&nbsp;&nbsp;</label><label><input type="radio" name="def" value="0" style="width:13px;height:13px">&nbsp;否</label></td>
                </tr>
            </table>

        </div>
        <div class="bc">
            <button type="button" id="button_submit">保存并使用</button>
        </div>
    </div>
    </form>
</div>
<div class="footing">
    <ul>
        <li class="li6">点击此处<a href="javascript:;" style="color: green;">下载客户端，<br/>可享受更多优惠</a></li>
        <li class="li7"><a href="javascript:;"><button type="button" id="btn3">去支付</button></a></li>
    </ul>
</div>
<div class="theme-popover-mask"></div>
</body>
</html>
