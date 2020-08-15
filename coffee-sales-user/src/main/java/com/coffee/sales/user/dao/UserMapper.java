package com.coffee.sales.user.dao;

import com.coffee.sales.user.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    /**
     * 用户登录
     *
     * @param user 用户信息
     * @return 是否有这个用户
     */
    Boolean userLogin(User user);

    /**
     * 用户注册
     *
     * @param user 用户信息
     * @return 是否注册成功
     */
    Integer userRegister(User user);

    /**
     * 用户申诉
     *
     * @param user 用户信息
     * @return 是否申诉成功
     */
    Boolean userRetrieve(User user);

    /**
     * 用户通过申诉修改密码
     *
     * @param user 用户信息
     * @return 是否修改成功
     */
    Integer userRetrievePassword(User user);

    /**
     * 查询用户所有信息
     *
     * @param user 用户名与密码
     * @return 用户信息
     */
    User userInformation(User user);

    /**
     * 查询用户手机号码是否重复
     *
     * @param user 用户手机号码
     * @return 是否重复
     */
    Integer userCountPhone(User user);

    /**
     * 用户修改信息
     *
     * @param user 用户信息
     * @return 是否更新成功
     */
    Integer userUpdateInformation(User user);
}
