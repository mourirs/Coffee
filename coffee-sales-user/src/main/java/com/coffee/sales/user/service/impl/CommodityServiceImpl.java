package com.coffee.sales.user.service.impl;

import com.coffee.sales.user.bean.Commodity;
import com.coffee.sales.user.dao.CommodityMapper;
import com.coffee.sales.user.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor=Exception.class)
public class CommodityServiceImpl implements CommodityService {

    private final CommodityMapper commodityMapper;

    @Autowired
    public CommodityServiceImpl(CommodityMapper commodityMapper) {
        this.commodityMapper = commodityMapper;
    }

    @Override
    public List<Commodity> commodityList(Integer Id) {
        return commodityMapper.commodityList(Id);
    }

    @Override
    public Integer commodityListCount(Integer Id) {
        return commodityMapper.commodityListCount(Id);
    }
}
