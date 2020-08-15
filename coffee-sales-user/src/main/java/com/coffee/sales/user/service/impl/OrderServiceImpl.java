package com.coffee.sales.user.service.impl;

import com.coffee.sales.user.bean.Order;
import com.coffee.sales.user.dao.CarMapper;
import com.coffee.sales.user.dao.OrderMapper;
import com.coffee.sales.user.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class OrderServiceImpl implements OrderService {

    private final OrderMapper orderMapper;

    private final CarMapper carMapper;

    @Autowired
    public OrderServiceImpl(OrderMapper orderMapper, CarMapper carMapper) {
        this.orderMapper = orderMapper;
        this.carMapper = carMapper;
    }

    @Override
    public Integer insertInFo(List<Order> orderList) {
        return orderMapper.insertInFo(orderList);
    }

    @Override
    public Integer deleteCarForIdIsListId(List<Integer> id) {
        return carMapper.deleteCarForIdIsListId(id);
    }

    @Override
    public List<Order> orderInFo(Integer id) {
        return orderMapper.orderInFo(id);
    }

    @Override
    public Integer deleteOrderInFo(Integer id) {
        return orderMapper.deleteOrderInFo(id);
    }
}
