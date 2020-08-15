package com.coffee.sales.user.service.impl;

import com.coffee.sales.user.bean.Address;
import com.coffee.sales.user.dao.AddressMapper;
import com.coffee.sales.user.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class AddressServiceImpl implements AddressService {

    private final AddressMapper addressMapper;

    @Autowired
    public AddressServiceImpl(AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }

    @Override
    public Integer addNewAddress(Address address) {
        return addressMapper.addNewAddress(address);
    }

    @Override
    public List<Address> addressList(Integer id) {
        return addressMapper.addressList(id);
    }

    @Override
    public Integer deleteAddress(Integer id) {
        return addressMapper.deleteAddress(id);
    }

    @Override
    public Integer updateAddress(Address address) {
        return addressMapper.updateAddress(address);
    }
}
