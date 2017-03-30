package com.nxs.mall.service;

import com.nxs.mall.entity.Address;

import java.util.List;

/**
 * Created by 57014 on 2017/2/24.
 */
public interface AddressService {
    public List<Address> getAllAddress(Integer userId);
    public Address getDefAddress(Integer userId);
    public Address getAddressByAddressId(Integer addressId);
    public int addAddress(Address address);
    public String delAddress(Integer userId,Integer addressId);
    public String updateAddress(Address address);
}
