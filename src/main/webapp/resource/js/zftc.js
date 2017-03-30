/**
 * Created by Administrator on 2016/3/18.
 */
    //支付弹窗
    $(function(){
        $("#btn3").click(function(){
            $(".menu").slideDown();
            $(".theme-popover-mask").show();
        });
        $(".theme-popover-mask").click(function(){
            $(".menu").slideUp();
            $(".theme-popover-mask").hide();
        });
        //送货上门
        $("#btn1").click(function(){
            $("#btn2").removeClass("btn1").addClass("btn2");
            $("#btn1").removeClass("btn2").addClass("btn1");
            $("#yunfei").show();
            $("#zt").hide();
            $("#address2").show();
            var price = parseFloat($("#totalPrice").val());
            $("#send").val(1);
            $("#price").html("<span style='color: #000000'>合计：</span>￥"+(price).toFixed(2));
        });
        //到店自取
        $("#btn2").click(function(){
            $("#btn1").removeClass("btn1").addClass("btn2");
            $("#btn2").removeClass("btn2").addClass("btn1");
            $("#yunfei").hide();
            $("#address2").hide();
            $("#zt").show();
            var price = parseFloat($("#totalPrice").val()) + 8;
            $("#send").val(0);
            $("#price").html("<span style='color: #000000'>合计：</span>￥"+(price).toFixed(2));
        });
        $("#button_submit").click(function(){
            if ($.trim($("#addressName").val()).length==0){
                alert("收件人不能为空！");
                return;
            }
            if ($.trim($("#phoneNumber").val()).length==0){
                alert("联系电话不能为空！");
                return;
            }
            if ($.trim($("#address").val()).length==0){
                alert("地址不能为空！");
                return;
            }
            //序列化表单元素，返回json数据
            var params = $("#addressForm").serializeArray();
            //也可以把表单之外的元素按照name value的格式存进来
            //params.push({name:"hello",value:"man"});
            $.ajax({
                type:"POST",
                url:"/wechatmall/address/add",
                data:params,
                success:function(data){
                    $("#addressId").val(data);
                    $("#span1").html("收货人：" + $("#addressName").val() + "&nbsp;&nbsp;电话："+ $("#phoneNumber").val());
                    $("#span2").html("收货地址：" + $("#address").val());
                    $("#dzlb").append("<div class='dzlb' id='"+data+"' onclick='changeAddress(" +data+ " )'><div class='harvest'><p class='person' id='person"+data+"'>收货人："+$("#addressName").val()+"&nbsp;&nbsp;电话："+ $("#phoneNumber").val()+"</p><br/> <p class='diqiu' id='diqiu"+data+"'>收货地址："+$("#address").val()+"</p> </div> <div style='clear: both'></div> </div>");
                    $(".zjdd").slideUp();
                    $(".changeadd").slideUp();
                    $(".theme-popover-mask").hide();
                },
                error:function(e) {
                    alert("出错："+e);
                }
            });
        });
    });
    //地址弹窗
    $(function(){
        $(".address").click(function(){
            $(".changeadd").slideDown();
            $(".theme-popover-mask").show();
        });
        $(".theme-popover-mask").click(function(){
            $(".changeadd").slideUp();
            $(".theme-popover-mask").hide();
        });
        });


    $(function(){
        $("#btn5").click(function(){
            $(".zjdd").slideDown();
        });
        $(document).bind("click",function(e){
        var target  = $(e.target);
        if(target.closest("#btn5,.zjdd").length == 0){/*.closest()沿 DOM 树向上遍历，直到找到已应用选择器的一个匹配为止，返回包含零个或一个元素的 jQuery 对象。*/
        $(".zjdd").slideUp();
        };
        e.stopPropagation();
        })
        });

    $(function(){
        //取消选择收货地址
        $("#btn4").on("click",function(){
            $(".changeadd").slideUp();
            $(".theme-popover-mask").hide();
        })
    });
  $(function(){
    $("#btn5").on("click",function(){
        $(".zjdd").slideDown();
        //$(".changeadd")
    })
    });

  $(function(){
    $("#btn6").on("click",function(){
        $(".zjdd").slideUp();
        $(".theme-popover-mask").hide();
    })
});
  function changeAddress(id){
      $("#addressId").val(id);
      $("#span1").html($("#person"+id).html());
      $("#span2").html($("#diqiu"+id).html());
  }
function pay(){
    var data = {
        send: $("#send").val(),
        orderId: $("#orderId").val(),
        addressId:$("#addressId").val(),
        note:$("#note").val(),
        price:parseFloat($("#totalPrice").val())
    }
    $.ajax({
        type: "post",
        url: "/wechatmall/order/success",
        async:true,
        data: JSON.stringify(data),
        contentType:'application/json;charset=UTF-8',
        success: function(data){
                window.location.href="/wechatmall/order/"+$("#orderId").val()+"/success";
        }
    });
}