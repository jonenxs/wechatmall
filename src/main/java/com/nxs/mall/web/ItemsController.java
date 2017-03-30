package com.nxs.mall.web;

import com.nxs.mall.entity.Items;
import com.nxs.mall.entity.ShoppingCart;
import com.nxs.mall.service.ImageService;
import com.nxs.mall.service.ItemsService;
import com.nxs.mall.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * Created by 57014 on 2017/2/15.
 */
@Component
@RequestMapping("/items")//url:模块/资源/{}/细分
public class ItemsController {

    @Autowired
    private ItemsService itemsService;

    @Autowired
    private ImageService imageService;

    @Autowired
    private ShoppingService shoppingService;


    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(Model model)
    {
        //list.jsp+mode=ModelAndView
        //获取列表页
        ArrayList<Items> list = itemsService.getAllItems();
        model.addAttribute("list",list);
        return "list";
    }

   @RequestMapping(value = "/{id}/detail",method = RequestMethod.GET)
   public String detail(@PathVariable("id") Integer id, Model model){
        if( id == null){
            return "redirect:/items/list";
        }
        Items items = itemsService.getItemsById(id);
        if(items == null){
            return "forward:/items/list";
        }
        model.addAttribute("items",items);
       ArrayList<Integer> ids = imageService.getImageidsByItemId(id);
       model.addAttribute("ids",ids);
        return "detail";
    }

    @RequestMapping(value = "/{id}/shopping",method = RequestMethod.GET)
    public String shopping(@PathVariable("id") Integer id, HttpSession session, Model model){
        if (id == null){
            return "redirect:/items/list";
        }
        Integer userId = Integer.parseInt(session.getAttribute("userId").toString());
        if (userId == 0){
            return "forward:/items/list";
        }
        ArrayList<ShoppingCart> shoppingCarts = shoppingService.addShopping(userId,id);
        if (shoppingCarts==null){
            return "forward:/items/list";
        }
        model.addAttribute("shoppingCarts",shoppingCarts);
        return "shopping";
    }

}
