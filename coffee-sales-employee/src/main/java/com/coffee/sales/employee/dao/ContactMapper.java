package com.coffee.sales.employee.dao;

import com.coffee.sales.employee.bean.Contact;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ContactMapper {
    /**
     * 获取所有用户反馈的信息
     *
     * @return 用户反馈信息
     */
    List<Contact> contactAllInFo();
}
