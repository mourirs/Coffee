package com.coffee.sales.user.dao;

import com.coffee.sales.user.bean.Address;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AddressMapper {
    /**
     * 添加新的地址
     *
     * @param address 地址信息
     * @return 是否添加成功
     */
    Integer addNewAddress(Address address);

    /**
     * 地址集合
     *
     * @param id 用户ID
     * @return 地址集合
     */
    List<Address> addressList(Integer id);

    /**
     * 删除地址
     *
     * @param id 地址ID
     * @return 是否删除成功
     */
    Integer deleteAddress(Integer id);

    /**
     * 更新地址信息
     *
     * @param address 信息
     * @return 是否更新成功
     */
    Integer updateAddress(Address address);
}
