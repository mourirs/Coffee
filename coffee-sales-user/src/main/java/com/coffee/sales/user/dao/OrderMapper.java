package com.coffee.sales.user.dao;

import com.coffee.sales.user.bean.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface OrderMapper {

    /**
     * 在订单中插入信息
     *
     * @param orderList 订单信息
     * @return 主键ID
     */
    Integer insertInFo(List<Order> orderList);

    /**
     * 根据用户ID查询用户订单信息
     *
     * @param id 用户ID
     * @return 订单信息
     */
    List<Order> orderInFo(Integer id);

    /**
     * 根据订单ID删除订单信息
     *
     * @param id 订单ID
     * @return 是否成功
     */
    Integer deleteOrderInFo(Integer id);
}
