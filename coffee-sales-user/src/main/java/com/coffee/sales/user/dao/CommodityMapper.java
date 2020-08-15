package com.coffee.sales.user.dao;

import com.coffee.sales.user.bean.Commodity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CommodityMapper {

    /**
     * 根据商品类型ID获取商品
     *
     * @param Id 商品类型ID
     * @return 商品信息
     */
    List<Commodity> commodityList(Integer Id);

    /**
     * 根据商品类型ID获取商品总数
     *
     * @param Id 商品类型ID
     * @return 商品总数
     */
    Integer commodityListCount(Integer Id);
}
