package com.coffee.sales.employee.dao;

import com.coffee.sales.employee.bean.UserMonitoring;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMonitoringMapper {

    /**
     * 获取所有的用户信息
     *
     * @return 用户信息
     */
    List<UserMonitoring> userMonitoringAllInFo();

    /**
     * 冻结用户
     *
     * @param id 用户ID
     * @return 影响的行数
     */
    Integer updateUserMonitoringTypeToFrozen(Integer id);

    /**
     * 解冻用户
     *
     * @param id 用户ID
     * @return 影响的行数
     */
    Integer updateUserMonitoringTypeToThaw(Integer id);
}
