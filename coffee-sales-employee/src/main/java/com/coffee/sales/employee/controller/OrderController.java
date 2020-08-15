package com.coffee.sales.employee.controller;

import com.coffee.sales.employee.bean.Order;
import com.coffee.sales.employee.service.OrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("orderAllInFo")
    public PageInfo<Order> orderAllInFo(@RequestParam(defaultValue = "1", name = "pageNumber") Integer pageNumber) {
        PageHelper.startPage(pageNumber, 6);
        return new PageInfo<>(orderService.orderAllInFo());
    }
}
