package com.coffee.sales.user.dao;

import com.coffee.sales.user.bean.CommodityType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CommodityTypeMapper {

    /**
     * 获取商品种类列表
     *
     * @return list 商品种类列表
     */
    List<CommodityType> commodityTypeList();
}
