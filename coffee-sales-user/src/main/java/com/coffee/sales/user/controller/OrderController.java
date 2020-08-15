package com.coffee.sales.user.controller;

import com.coffee.sales.user.bean.Order;
import com.coffee.sales.user.service.OrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("addOrderInFos")
    public Boolean addOrderInFo(HttpServletRequest request) {
        String order = request.getParameter("order");
        List<Map<String, Object>> collection = (List<Map<String, Object>>) net.sf.json.JSONArray.toCollection(JSONArray.fromObject(order), Map.class);
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        List<Order> orders = new ArrayList<>();
        List<Integer> carId = new ArrayList<>();
        for (Map<String, Object> stringObjectMap : collection) {
            carId.add(Integer.parseInt(String.valueOf(stringObjectMap.get("cId"))));
            orders.add(new Order(
                    userId,
                    String.valueOf(stringObjectMap.get("oNumber")),
                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()),
                    Integer.parseInt(String.valueOf(stringObjectMap.get("oGold"))),
                    Integer.parseInt(String.valueOf(stringObjectMap.get("oTransaction"))),
                    Integer.parseInt(String.valueOf(stringObjectMap.get("aId"))),
                    String.valueOf(stringObjectMap.get("oName")),
                    Integer.parseInt(String.valueOf(stringObjectMap.get("oPrice"))),
                    Integer.parseInt(String.valueOf(stringObjectMap.get("oNUm")))
            ));
        }

        if (orderService.insertInFo(orders) > 0) {
            orderService.deleteCarForIdIsListId(carId);
            return true;
        } else {
            return false;
        }

    }

    @PostMapping("orderPageInFo")
    public PageInfo<Order> getOrderInFo(@RequestParam(defaultValue = "1", name = "pageNumber") Integer pageNumber, HttpServletRequest request) {
        PageHelper.startPage(pageNumber, 10);
        List<Order> orders = orderService.orderInFo((Integer) request.getSession().getAttribute("userId"));
        return new PageInfo<>(orders);
    }

    @PostMapping("deleteOrderInFo")
    public Boolean deleteOrderInFo(Integer id) {
        return orderService.deleteOrderInFo(id) > 0;
    }
}
