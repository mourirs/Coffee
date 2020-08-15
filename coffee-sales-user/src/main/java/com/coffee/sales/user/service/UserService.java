package com.coffee.sales.user.service;

import com.coffee.sales.user.bean.User;


public interface UserService {
    Boolean userLogin(User user);

    Integer userRegister(User user);

    Boolean userRetrieve(User user);

    Integer userRetrievePassword(User user);

    User userInformation(User user);

    Integer userCountPhone(User user);

    Integer userUpdateInformation(User user);
}
