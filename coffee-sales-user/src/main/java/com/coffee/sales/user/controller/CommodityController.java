package com.coffee.sales.user.controller;

import com.coffee.sales.user.bean.Commodity;
import com.coffee.sales.user.service.CommodityService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommodityController {
    private final CommodityService commodityService;

    public CommodityController(CommodityService commodityService) {
        this.commodityService = commodityService;
    }

    @PostMapping("/commodityList")
    public PageInfo<Commodity> commodityList(@RequestParam(defaultValue = "1", name = "pageNumber") Integer pageNumber, Integer Id) {
        PageHelper.startPage(pageNumber, 4);
        List<Commodity> commodities = commodityService.commodityList(Id);
        return new PageInfo<>(commodities);
    }
}
