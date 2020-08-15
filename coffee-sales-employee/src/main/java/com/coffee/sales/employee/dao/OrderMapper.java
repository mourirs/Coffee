package com.coffee.sales.employee.dao;

import com.coffee.sales.employee.bean.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface OrderMapper {
    /**
     * 获取订单信息
     *
     * @return 订单信息
     */
    List<Order> orderAllInFo();
}
