package com.nxs.mall.dao;

import com.nxs.mall.entity.Address;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 57014 on 2017/2/24.
 */
public interface AddressDao {
    //获取所有收货地址
    public List<Address> getAllAddressByUserId(@Param("userId") Integer userId);
    //获取默认收货地址
    public Address getDefAddressByUserId(@Param("userId") Integer userId);
    //根据地址id获取地址
    public Address getAddressByAddressId(@Param("userId") Integer addressId);
    //新增收货地址
    public int addAddress(Address address);
    //删除收货地址
    public int delAddress(@Param("userId") Integer userId,@Param("addressId") Integer addressId);
    //修改收货地址
    public int updateAddress(Address address);
    //将所有地址全部置为非默认
    public int setAddressDef(@Param("userId") Integer userId);
}
