<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,height=device-height, user-scalable=no,initial-scale=1, minimum-scale=1, maximum-scale=1">
    <title>购物车</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/shopping.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery-1.12.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/qxsp.js"></script>
    <!-- 复选框 -->
    <script type="text/javascript">
        $(function(){
            $("#chk_all").click(function() {
                $('input[name="box"]').prop("checked",this.checked);
                setTotal();
            });
            var $box = $("input[name='box']");
            $box.click(function(){
                $("#chk_all").prop("checked",$box.length == $("input[name='box']:checked").length ? true : false);
                setTotal();
            });
        });


    </script>
</head>
<body>
<div class="body">
    <div class="tour">
        <a href="javascript:history.go(-1);" class="tour1"><img src="${pageContext.request.contextPath}/resource/img/back.png" alt="" style="height: 26px;width: 20px"></a>
        <p>购物车</p>
        <a href="javascript:;" class="tour2"><i class="btn"></i></a>
    </div>

    <c:forEach items="${shoppingCarts}" var="sc">
    <div class="spxz" id="spxz${sc.items.itemId}">
        <ul>
            <li class="li1"><input type="checkbox" value="${sc.items.itemId}" id="box${sc.items.itemId}" name="box"/></li>
            <li class="li2"><a href="/wechatmall/items/${sc.items.itemId}/detail"><img src="${pageContext.request.contextPath}/images/${sc.items.imageId}/image" alt="" style="width: 60px;height: 60px"/></a></li>
            <li class="li3"><span style="color: red" >￥</span><input type="text" value="${sc.items.promotionPrice}" class="one" id="one${sc.items.itemId}" disabled="disabled"></li>
            <li class="li4"><div><a class="reduce" onclick="reduce(${sc.items.itemId})">-</a><input type="text" value="${sc.cartItemNumber}" class="num" id="num${sc.items.itemId}"/><a class="plus" onclick="plus(${sc.items.itemId})">+</a></div></li>
        </ul>
    </div>
    </c:forEach>
    <c:if test="${empty shoppingCarts}">
        <div class="spxz">
            <ul>
                <li style="font-size: 1.6rem">您购物车内还没添加任何商品呢！</li>
            </ul>
            <div style="clear: both"></div>
        </div>
    </c:if>
</div>
<div style="clear: both"></div>
<div class="footing">
    <ul>
        <li class="li5"><input type="checkbox" name="chk_all" id="chk_all"  />全选</li>
        <li class="li6">合计：<span class="red">￥0.00</span></li>
        <li class="li7"><button type="button" id="for_pay">结算</button></li>
    </ul>
</div>
<div class="alert" id="alert">
    <table border="1" cellSpacing=0  style="width: 100%;text-align: center;border-spacing:0;BORDER-COLLAPSE: collapse">
        <tr>
            <td colspan="2">
                <div style="padding: 0.5rem 0 0.5rem 0;font-size: 1.6rem">提示</div>
                <div style="padding: 0.5rem 0 0.5rem 0;font-size: 1.6rem">确定删除当前商品?</div>
            </td>
        </tr>
        <tr>
            <td><button type="button" class="delete" style="border: none;outline: none;background-color: white;font-size: 1.6rem;padding: 0.5rem 0 0.5rem 0;width:100%">确定</button></td>
            <td><button type="button" class="none" style="border: none;outline: none;background-color: white;font-size: 1.6rem;padding: 0.5rem 0 0.5rem 0;width:100%">取消</button></td>
        </tr>
    </table>
</div>
<div class="alert" id="error">
    <table border="1" cellSpacing=0  style="width: 100%;text-align: center;border-spacing:0;BORDER-COLLAPSE: collapse">
        <tr>
            <td colspan="2">
                <div style="padding: 0.5rem 0 0.5rem 0;font-size: 1.6rem">提示</div>
                <div style="padding: 0.5rem 0 0.5rem 0;font-size: 1.6rem">您还未选择任何商品！</div>
            </td>
        </tr>
        <tr>
            <td><button type="button" class="none" style="border: none;outline: none;background-color: white;font-size: 1.6rem;padding: 0.5rem 0 0.5rem 0;width:100%">确定</button></td>
            <td><button type="button" class="none" style="border: none;outline: none;background-color: white;font-size: 1.6rem;padding: 0.5rem 0 0.5rem 0;width:100%">取消</button></td>
        </tr>
    </table>
</div>
<div class="theme-popover-mask"></div>
</body>
</html>
