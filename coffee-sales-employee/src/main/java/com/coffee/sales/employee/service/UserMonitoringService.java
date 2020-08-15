package com.coffee.sales.employee.service;


import com.coffee.sales.employee.bean.UserMonitoring;

import java.util.List;

public interface UserMonitoringService {

    List<UserMonitoring> userMonitoringAllInFo();

    Integer updateUserMonitoringTypeToFrozen(Integer id);

    Integer updateUserMonitoringTypeToThaw(Integer id);
}
