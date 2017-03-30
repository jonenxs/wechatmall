package com.nxs.mall.web;

import com.nxs.mall.dao.OrdersDao;
import com.nxs.mall.entity.*;
import com.nxs.mall.service.AddressService;
import com.nxs.mall.service.ImageService;
import com.nxs.mall.service.ItemsService;
import com.nxs.mall.service.ShoppingService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 57014 on 2017/2/15.
 */
@Component
@RequestMapping("/shopping")//url:模块/资源/{}/细分
public class ShoppingController {

    @Autowired
    private ShoppingService shoppingService;

    @Autowired
    private AddressService addressService;

    @ResponseBody
    @RequestMapping("/{id}/update")
    public String  updateShoppingItemsNumber(@PathVariable("id") Integer id,int num,HttpSession session) throws Exception{
        Integer userId = Integer.parseInt(session.getAttribute("userId").toString());
        if (userId == 0){
            return "forward:/items/list";
        }
        String result = shoppingService.updateShoppingItemsNumber(userId,id,num);
        return result;
    }

    @ResponseBody
    @RequestMapping("/{ids}/delete")
    public String  deleteShoppingItems(@PathVariable("ids") String ids,HttpSession session) throws Exception{
        Integer userId = Integer.parseInt(session.getAttribute("userId").toString());
        if (userId == 0){
            return "forward:/items/list";
        }
        String result = shoppingService.deleteShoppingItems(userId, ids);
        return result;
    }

    @RequestMapping("/{ids}/forPay")
    public String  payShoppingItems(@PathVariable("ids") String ids, HttpSession session, Model model) throws Exception{
        if(ids == null){
            return "redirect:/items/list";
        }
        Integer userId = Integer.parseInt(session.getAttribute("userId").toString());
        if (userId == 0){
            return "forward:/items/list";
        }
        Orders order =  shoppingService.moveItemsFromShoppingCartsToOrders(userId,ids);
        if(order == null){
            return "redirect:/items/list";
        }
        List<OrderDetail> orderDetails = order.getOrderDetail();
        double totalPrice = 8;//8元运费
        for (OrderDetail orderDetail:orderDetails) {
            totalPrice = totalPrice + orderDetail.getItemNum() * orderDetail.getItems().getPromotionPrice();
        }
        Address address = addressService.getDefAddress(userId);
        List<Address> addresses = addressService.getAllAddress(userId);
        model.addAttribute("totalPrice",totalPrice );
        model.addAttribute("orderDetails",orderDetails);
        model.addAttribute("address",address);
        model.addAttribute("addresses", addresses);
        return "pay";
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String shopping(HttpSession session,Model model){
        Integer userId = Integer.parseInt(session.getAttribute("userId").toString());
        if (userId == 0){
            return "forward:/items/list";
        }
        ArrayList<ShoppingCart> shoppingCarts = shoppingService.getShopping(userId);
        if (shoppingCarts==null){
            return "forward:/items/list";
        }

        model.addAttribute("shoppingCarts",shoppingCarts);
        return "shopping";
    }


}
