package com.coffee.sales.user.dao;

import com.coffee.sales.user.bean.Contact;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ContactMapper {

    /**
     * 用户意见
     *
     * @param contact 用户意见信息
     * @return 是否插入成功
     */
    Integer insertInFo(Contact contact);

}
