package com.coffee.sales.employee.service.impl;

import com.coffee.sales.employee.bean.UserMonitoring;
import com.coffee.sales.employee.dao.UserMonitoringMapper;
import com.coffee.sales.employee.service.UserMonitoringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserMonitoringServiceImpl implements UserMonitoringService {

    private final UserMonitoringMapper userMonitoringMapper;

    @Autowired
    public UserMonitoringServiceImpl(UserMonitoringMapper userMonitoringMapper) {
        this.userMonitoringMapper = userMonitoringMapper;
    }

    @Override
    public List<UserMonitoring> userMonitoringAllInFo() {
        return userMonitoringMapper.userMonitoringAllInFo();
    }

    @Override
    public Integer updateUserMonitoringTypeToFrozen(Integer id) {
        return userMonitoringMapper.updateUserMonitoringTypeToFrozen(id);
    }

    @Override
    public Integer updateUserMonitoringTypeToThaw(Integer id) {
        return userMonitoringMapper.updateUserMonitoringTypeToThaw(id);
    }
}
