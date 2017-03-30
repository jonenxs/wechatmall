package com.nxs.mall.service.impl;

import com.nxs.mall.dao.AddressDao;
import com.nxs.mall.entity.Address;
import com.nxs.mall.service.AddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 57014 on 2017/2/24.
 */
@Service
public class AddressServiceImpl implements AddressService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private AddressDao addressDao;
    @Override
    public List<Address> getAllAddress(Integer userId) {
        return addressDao.getAllAddressByUserId(userId);
    }

    @Override
    public Address getDefAddress(Integer userId) {
        return addressDao.getDefAddressByUserId(userId);
    }

    @Override
    public Address getAddressByAddressId(Integer addressId) {
        return null;
    }


    /**
     * 使用注解控制事务方法的优点:
     * 1.开发团队达成一致约定，明确标注事务方法的编程风格
     * 2.保证事务方法的执行时间尽可能短，不要穿插其他网络操作RPC/HTTP请求或者剥离到事务方法外部
     * 3.不是所有的方法都需要事务，如只有一条修改操作、只读操作不要事务控制
     */
    @Override
    @Transactional
    public int addAddress(Address address) {
        //判断新增的地址是否为默认地址
        if(address.getDef() == 1){
            //若为默认地址，则将该联系人已有的地址全部置为非默认地址
            addressDao.setAddressDef(address.getUserId());
        }
        if(addressDao.addAddress(address) == 0){
            return 0;
        }
        return address.getAddressId();
    }

    @Override
    public String delAddress(Integer userId, Integer addressId) {
        if(addressDao.delAddress(userId,addressId) == 0){
            return "fail";
        }
        return "success";
    }

    @Override
    public String updateAddress(Address address) {
        //判断修改的地址是否为默认地址
        if(address.getDef() == 1){
            //若为默认地址，则将该联系人已有的地址全部置为非默认地址
            if(addressDao.setAddressDef(address.getUserId()) == 0){
                //修改失败
                return "fail";
            }
        }
        if(addressDao.updateAddress(address) == 0){
            return "fail";
        }
        return "success";
    }
}
