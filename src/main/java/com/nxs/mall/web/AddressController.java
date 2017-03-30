package com.nxs.mall.web;

import com.nxs.mall.entity.Address;
import com.nxs.mall.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by 57014 on 2017/2/24.
 */
@Component
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @RequestMapping("/list")
    @ResponseBody
    public List<Address> getAddressList(HttpSession session){
        Integer userId = Integer.parseInt(session.getAttribute("userId").toString());
        return addressService.getAllAddress(userId);
    }

    @RequestMapping("/add")
    @ResponseBody
    public int addresses(Address address, HttpSession session){
        Integer userId = Integer.parseInt(session.getAttribute("userId").toString());
        address.setUserId(userId);
        return addressService.addAddress(address);
    }


}
