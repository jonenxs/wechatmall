package com.nxs.mall.dao;

import com.nxs.mall.entity.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by 57014 on 2017/2/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class AddressDaoTest {
    @Resource
    private AddressDao addressDao;
    @Test
    public void getAllAddressByUserId() throws Exception {
        List<Address> addresses = addressDao.getAllAddressByUserId(1);
        for (Address address:addresses) {
            System.out.println(address);
        }
    }

    @Test
    public void getDefAddressByUserId() throws Exception {
        Address address = addressDao.getDefAddressByUserId(1);
        System.out.println(address);
    }

    @Test
    public void addAddress() throws Exception {
        Address address = new Address();
        address.setAddress("云南省昆明市公安局");
        address.setDef(0);
        address.setPhoneNumber("110");
        address.setUserId(1);
        System.out.println(addressDao.addAddress(address));
    }

    @Test
    public void delAddress() throws Exception {
        System.out.println(addressDao.delAddress(1,3));
    }

    @Test
    public void updateAddress() throws Exception {
        Address address = new Address();
        address.setAddress("云南省昆明市第一人民医院");
        address.setDef(0);
        address.setPhoneNumber("120");
        address.setUserId(1);
        address.setAddressId(4);
        System.out.println(addressDao.updateAddress(address));
    }

    @Test
    public void setAddressDef() throws Exception {
        System.out.println(addressDao.setAddressDef(1));
    }

}