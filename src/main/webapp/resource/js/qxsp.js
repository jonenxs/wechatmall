/**
 * Created by Administrator on 2016/3/18.
 */
    //删除弹窗
$(function() {
    $(".btn").click(function () {
        var ids = getIds();
        if(ids.length == 0){
            $("#error").slideDown();
            $(".theme-popover-mask").show();
            return;
        }
        $("#alert").slideDown();
        $(".theme-popover-mask").show();
    });
    $(".theme-popover-mask").click(function () {
        $("#alert").slideUp();
        $(".theme-popover-mask").hide();
    });
    $("#for_pay").click(function () {
        var ids = getIds();
        if(ids.length == 0){
            $("#error").slideDown();
            $(".theme-popover-mask").show();
            return;
        }
        location.href = "/wechatmall/shopping/"+ids+"/forPay";//location.href实现客户端页面的跳转
    });
});
$(function(){
	$(".delete").click(function(){
        var ids = getIds();
        if(ids.length == 0){
            return;
        }
        $("#alert").slideUp();
        $(".theme-popover-mask").hide();
        $.ajax({
            type: "POST",
            timeout: 3000,
            async: false,
            cache: false,
            url: "/wechatmall/shopping/"+ids+"/delete",
            success: function (data){
                $("input[name='box']:checkbox").each(function() {
                    if($(this).is(":checked"))
                    {
                        $("#spxz"+$(this).attr("value")).remove();
                    }
                });
                var $box = $("input[name='box']");
                if($box.length == $("input[name='box']:checked").length){
                    $(".li5").hide();
                    $(".li6").hide();
				}
                setTotal();
            },
            error : function() {
                alert("删除失败，请稍后重试！");
            }
        });
	       /* $(".theme-popover-mask").hide();
	        $(".li5").hide();
	        $(".li6").hide();*/
	})
});
$(function(){
	$(".none").click(function(){
		  $(".alert").slideUp();
	        $(".theme-popover-mask").hide();
	})
});
function reduce(id){
    var t = $("#num"+id);
    //var one = $("#one"+id).val();
    if (parseInt(t.val()) > 1) {
        $.ajax({
            type: "POST",
            timeout: 3000,
            async: false,
            cache: false,
            data:{num:-1},//参数
            url: "/wechatmall/shopping/"+id+"/update",
            success: function (data){
                t.val(parseInt(t.val()) - 1);
                setTotal();
            },
            error : function() {
                alert("添加失败，请稍后重试！");
            }
        });
    }
}
function plus(id){
    var t = $("#num"+id);
    //var one = $("#one"+id).val();
    $.ajax({
        type: "POST",
        timeout: 3000,
        async: false,
        cache: false,
        data:{num:1},//参数
        url: "/wechatmall/shopping/"+id+"/update",
        success: function (data){
            t.val(parseInt(t.val()) + 1);
            setTotal();
        },
        error : function() {
            alert("添加失败，请稍后重试！");
        }
    });
    if (parseInt(t.val()) != 1) {
        $('#reduce').attr('disabled', false);
    }
}
function setTotal(){
    var total = 0;
    $("input[name='box']:checkbox").each(function() {
        if($(this).is(":checked"))
        {
            var id = $(this).attr("value");
            total += $("#num"+id).val() * $("#one"+id).val();
        }
    });
    $(".red").html("<a>￥</a>"+(total).toFixed(2));//toFixed()是保留小数点的函数
}
function getIds() {
    var ids = "";
    $("input[name='box']:checkbox").each(function() {
        if($(this).is(":checked"))
        {
            ids = ids + $(this).attr("value") + ",";
        }
    });
    return ids;
}

