package com.coffee.sales.user.service;

import com.coffee.sales.user.bean.Address;

import java.util.List;

public interface AddressService {
    Integer addNewAddress(Address address);

    List<Address> addressList(Integer id);

    Integer deleteAddress(Integer id);

    Integer updateAddress(Address address);
}
