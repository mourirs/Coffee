package com.coffee.sales.employee.service.impl;

import com.coffee.sales.employee.bean.Order;
import com.coffee.sales.employee.dao.OrderMapper;
import com.coffee.sales.employee.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderMapper orderMapper;

    @Autowired
    public OrderServiceImpl(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @Override
    public List<Order> orderAllInFo() {
        return orderMapper.orderAllInFo();
    }
}
