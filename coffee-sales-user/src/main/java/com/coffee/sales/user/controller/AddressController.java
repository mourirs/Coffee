package com.coffee.sales.user.controller;

import com.coffee.sales.user.bean.Address;
import com.coffee.sales.user.service.AddressService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class AddressController {
    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("addNewAddress")
    public Boolean addNewAddress(Address address, HttpServletRequest request) {
        address.setUId((Integer) request.getSession().getAttribute("userId"));
        return addressService.addNewAddress(address) > 0;
    }

    @PostMapping("addressPageInfo")
    public PageInfo<Address> addressPageInfo(@RequestParam(defaultValue = "1", name = "pageNumber") Integer pageNumber, HttpServletRequest request) {
        PageHelper.startPage(pageNumber, 8);
        List<Address> userId = addressService.addressList((Integer) request.getSession().getAttribute("userId"));
        return new PageInfo<>(userId);
    }

    @PostMapping("deleteAddress")
    public Boolean deleteAddress(Integer id) {
        return addressService.deleteAddress(id) > 0;
    }

    @PostMapping("updateAddress")
    public Boolean updateAddress(Address address) {
        return addressService.updateAddress(address) > 0;
    }

    @PostMapping("addressList")
    public List<Address> addressList(HttpServletRequest request) {
        return addressService.addressList((Integer) request.getSession().getAttribute("userId"));
    }
}
