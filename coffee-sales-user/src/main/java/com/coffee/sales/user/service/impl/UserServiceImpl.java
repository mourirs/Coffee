package com.coffee.sales.user.service.impl;

import com.coffee.sales.user.bean.User;
import com.coffee.sales.user.dao.UserMapper;
import com.coffee.sales.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public Boolean userLogin(User user) {
        return userMapper.userLogin(user);
    }

    @Override
    public Integer userRegister(User user) {
        return userMapper.userRegister(user);
    }

    @Override
    public Boolean userRetrieve(User user) {
        return userMapper.userRetrieve(user);
    }

    @Override
    public Integer userRetrievePassword(User user) {
        return userMapper.userRetrievePassword(user);
    }

    @Override
    public User userInformation(User user) {
        return userMapper.userInformation(user);
    }

    @Override
    public Integer userCountPhone(User user) {
        return userMapper.userCountPhone(user);
    }

    @Override
    public Integer userUpdateInformation(User user) {
        return userMapper.userUpdateInformation(user);
    }
}
