package com.coffee.sales.employee.controller;

import com.coffee.sales.employee.bean.UserMonitoring;
import com.coffee.sales.employee.service.UserMonitoringService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserMonitoringController {

    private final UserMonitoringService userMonitoringService;

    @Autowired
    public UserMonitoringController(UserMonitoringService userMonitoringService) {
        this.userMonitoringService = userMonitoringService;
    }

    @PostMapping("userMonitoringAllInFo")
    public PageInfo<UserMonitoring> userMonitoringAllInFo(@RequestParam(defaultValue = "1", name = "pageNumber") Integer pageNumber) {
        PageHelper.startPage(pageNumber, 6);
        return new PageInfo<>(userMonitoringService.userMonitoringAllInFo());
    }

    @PostMapping("updateUserMonitoringTypeToFrozen")
    public Boolean updateUserMonitoringTypeToFrozen(Integer id) {
        return userMonitoringService.updateUserMonitoringTypeToFrozen(id) > 0;
    }

    @PostMapping("updateUserMonitoringTypeToThaw")
    public Boolean updateUserMonitoringTypeToThaw(Integer id) {
        return userMonitoringService.updateUserMonitoringTypeToThaw(id) > 0;
    }
}
