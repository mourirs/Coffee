package com.coffee.sales.user.service;

import com.coffee.sales.user.bean.Order;

import java.util.List;

public interface OrderService {
    Integer insertInFo(List<Order> orderList);

    Integer deleteCarForIdIsListId(List<Integer> id);

    List<Order> orderInFo(Integer id);

    Integer deleteOrderInFo(Integer id);
}
