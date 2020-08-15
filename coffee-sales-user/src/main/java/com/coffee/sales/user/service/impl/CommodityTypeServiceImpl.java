package com.coffee.sales.user.service.impl;

import com.coffee.sales.user.bean.CommodityType;
import com.coffee.sales.user.dao.CommodityTypeMapper;
import com.coffee.sales.user.service.CommodityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor=Exception.class)
public class CommodityTypeServiceImpl implements CommodityTypeService {

    private final CommodityTypeMapper commodityTypeMapper;

    @Autowired
    public CommodityTypeServiceImpl(CommodityTypeMapper commodityTypeMapper) {
        this.commodityTypeMapper = commodityTypeMapper;
    }

    @Override
    public List<CommodityType> commodityTypeList() {
        return commodityTypeMapper.commodityTypeList();
    }
}
