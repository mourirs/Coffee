package com.coffee.sales.user.controller;

import com.coffee.sales.user.bean.CommodityType;
import com.coffee.sales.user.service.CommodityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommodityTypeController {
    private final CommodityTypeService commodityTypeService;

    @Autowired
    public CommodityTypeController(CommodityTypeService commodityTypeService) {
        this.commodityTypeService = commodityTypeService;
    }

    @GetMapping("commodityTypeList")
    public List<CommodityType> commodityTypeList() {
        return commodityTypeService.commodityTypeList();
    }
}
