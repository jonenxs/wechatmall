package com.nxs.mall.web;

import com.nxs.mall.dao.OrdersDao;
import com.nxs.mall.entity.Address;
import com.nxs.mall.entity.OrderDetail;
import com.nxs.mall.entity.Orders;
import com.nxs.mall.entity.ShoppingCart;
import com.nxs.mall.service.AddressService;
import com.nxs.mall.service.OrderService;
import com.nxs.mall.service.ShoppingService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 57014 on 2017/2/15.
 */
@Component
@RequestMapping("/order")//url:模块/资源/{}/细分
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private AddressService addressService;
    @RequestMapping(value = "/success",method = RequestMethod.POST)
    @ResponseBody
    public void successPay(@RequestBody JSONObject jsonObj,HttpSession session){
        Integer userId = Integer.parseInt(session.getAttribute("userId").toString());
        Orders orders = new Orders();
        //从json对象中取值,根据值的类型选择get方法
        int send = Integer.parseInt(jsonObj.get("send").toString());
        Integer orderId = Integer.parseInt(jsonObj.get("orderId").toString());
        String note = jsonObj.get("note").toString();
        Double price = Double.parseDouble(jsonObj.get("price").toString());
        //默认进店自取，减去8元运费
        orders.setPrice(price - 8.0);
        orders.setUserId(userId);
        orders.setOrderId(orderId);
        //默认进店自取
        orders.setOrderStatus("1");
        //默认为店家地址
        orders.setAddressId(1);
        orders.setNote(note);
        //送货上门
        if(send == 1){
            Integer addressId = Integer.parseInt(jsonObj.get("addressId").toString());
            //更新地址为买家地址
            orders.setAddressId(addressId);
            //更改订单状态为已付款但未发货
            orders.setOrderStatus("2");
            //更改订单总金额
            orders.setPrice(price);
        }
       Orders order = orderService.updateOrder(orders);
    }

    @RequestMapping(value = "/{id}/success",method = RequestMethod.GET)
    public String OrderSuccessPay(@PathVariable("id")Integer orderId, Model model){
        Orders order = orderService.getOrderById(orderId);
        if (order == null){
            return "redirect:/items/list";
        }
        double price = 0;
        for (OrderDetail orderDetail:order.getOrderDetail()) {
            price = price + orderDetail.getItemNum() * orderDetail.getItems().getPromotionPrice();
        }
        if (order.getOrderStatus() != null && order.getOrderStatus().equals("1")){
            price = price + 8;
        }
        model.addAttribute("order",order );
        model.addAttribute("price",price);
        return "paySuccess";
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public String getOrderById(@PathVariable("id")Integer orderId, Model model){
        Orders order = orderService.getOrderById(orderId);
        if (order == null){
            return "redirect:/items/list";
        }
        double price = 0;
        for (OrderDetail orderDetail:order.getOrderDetail()) {
            price = price + orderDetail.getItemNum() * orderDetail.getItems().getPromotionPrice();
        }
        if(order.getOrderStatus() != null && !order.getOrderStatus().equals("1")){
            price = price + 8;
        }
        order.setPrice(price);
        Address address = order.getAddress();
         model.addAttribute("address", address);
        model.addAttribute("order",chagngeStatus(order));
        model.addAttribute("price",price);
        return "order";
    }

    @RequestMapping(value = "/{id}/delOrder",method = RequestMethod.GET)
    public String delOrder(@PathVariable("id")Integer orderId, Model model){
        Orders order = orderService.getOrderById(orderId);
        order.setOrderStatus("5");
        orderService.updateOrder(order);
        return "redirect:/order/"+orderId;
    }

    @RequestMapping(value = "/{status}/allOrder",method = RequestMethod.GET)
    public String allOrder(@PathVariable("status")int status, HttpSession session, Model model){
        Integer userId = Integer.parseInt(session.getAttribute("userId").toString());
        List<Orders> orders = orderService.getAllOrders(userId, status);
        List<Orders> ordersList = new ArrayList<Orders>();
        if(orders != null ){
            for (Orders order:orders) {
                ordersList.add(chagngeStatus(order));
            }
        }
        model.addAttribute("status", status);
        model.addAttribute("orders",ordersList);
        return "allOrder";
    }

    private Orders chagngeStatus(Orders order){
        if (order.getOrderStatus() != null && order.getOrderStatus().equals("0")){
            order.setOrderStatus("未付款！");
        }else if (order.getOrderStatus() != null && order.getOrderStatus().equals("1")){
            order.setOrderStatus("到店自取！");
        }else if (order.getOrderStatus() != null && order.getOrderStatus().equals("2")){
            order.setOrderStatus("待派送！");
        }else if (order.getOrderStatus() != null && order.getOrderStatus().equals("3")){
            order.setOrderStatus("派送中！");
        }else if (order.getOrderStatus() != null && order.getOrderStatus().equals("4")){
            order.setOrderStatus("已签收！");
        }else if (order.getOrderStatus() != null && order.getOrderStatus().equals("5")){
            order.setOrderStatus("取消订单，请求退款！");
        }else if (order.getOrderStatus() != null && order.getOrderStatus().equals("6")){
            order.setOrderStatus("退款成功！");
        }
        return order;
    }
}
