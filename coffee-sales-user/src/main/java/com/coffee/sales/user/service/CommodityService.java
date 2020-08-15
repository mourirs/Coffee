package com.coffee.sales.user.service;


import com.coffee.sales.user.bean.Commodity;

import java.util.List;

public interface CommodityService {

    List<Commodity> commodityList(Integer Id);

    Integer commodityListCount(Integer Id);
}
