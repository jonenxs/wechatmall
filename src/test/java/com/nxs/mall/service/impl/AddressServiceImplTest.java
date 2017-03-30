package com.nxs.mall.service.impl;

import com.nxs.mall.entity.Address;
import com.nxs.mall.service.AddressService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by 57014 on 2017/2/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"
})
public class AddressServiceImplTest {
    @Autowired
    private AddressService addressService;
    @Test
    public void getAllAddress() throws Exception {
        List<Address> addresses = addressService.getAllAddress(1);
        for (Address address:addresses) {
            System.out.println(address);
        }
    }

    @Test
    public void getDefAddress() throws Exception {
        System.out.println(addressService.getDefAddress(1));
    }

    @Test
    public void addAddress() throws Exception {
        Address address = new Address();
        address.setAddress("云娜省昆明市盘龙区白龙寺");
        address.setUserId(1);
        address.setDef(1);
        address.setPhoneNumber("123456789");
        System.out.println(addressService.addAddress(address));
    }

    @Test
    public void delAddress() throws Exception {
        System.out.println(addressService.delAddress(1,4));
    }

    @Test
    public void updateAddress() throws Exception {
        Address address = new Address();
        address.setAddress("云娜省昆明市五华区");
        address.setUserId(1);
        address.setDef(1);
        address.setPhoneNumber("123");
        address.setAddressId(4);
        System.out.println(addressService.updateAddress(address));
    }

}