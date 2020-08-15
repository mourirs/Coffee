package com.coffee.sales.user.dao;

import com.coffee.sales.user.bean.Car;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CarMapper {
    /**
     * 给购物车添加商品
     *
     * @param car 购物车信息
     * @return 主键ID
     */
    Integer addCar(Car car);

    /**
     * 检查购物车是否已经有了这个商品
     *
     * @param car 购物车信息
     * @return 是否已经有了这件商品
     */
    Integer addCarCount(Car car);

    /**
     * 根据用户id和商品id查询购物车id
     *
     * @param car 购物车信息
     * @return 购物车ID
     */
    Car carId(Car car);

    /**
     * 根据购物车ID修改购物车商品数量
     *
     * @param car 购物车信息
     * @return 是否修改成功
     */
    Integer updateCar(Car car);

    /**
     * 根据用户ID获取用户购物车信息
     *
     * @param id 用户ID
     * @return 购物车信息
     */
    List<Car> carForUid(Integer id);

    /**
     * 根据购物车ID删除购物车信息
     *
     * @param id 购物车ID
     * @return 是否删除
     */
    Integer deleteCarForCId(Integer id);

    /**
     * 根据购物车ID删除购物车信息
     *
     * @param id 购物车ID
     * @return 成功删除的条数
     */
    Integer deleteCarForIdIsListId(List<Integer> id);
}
