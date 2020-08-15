package com.coffee.sales.user.controller;

import com.coffee.sales.user.bean.User;
import com.coffee.sales.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@Slf4j
@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("userLogin")
    @ResponseBody
    public Boolean userLogin(User user, HttpServletRequest request) {
        if (userService.userLogin(user) != null && userService.userLogin(user)) {
            request.getSession().setAttribute("userId", userService.userInformation(user).getUId());
            request.getSession().setAttribute("userName", user.getUName());
            return true;
        } else {
            return false;
        }
    }

    @PostMapping("userRegister")
    @ResponseBody
    public Boolean userRegister(User user) {
        return userService.userRegister(user) > 0;
    }

    @RequestMapping("userLogout")
    public String userLogout(HttpServletRequest request) {
        request.getSession().removeAttribute("userName");
        request.getSession().removeAttribute("userId");
        return "index";
    }

    @PostMapping("userRetrieve")
    @ResponseBody
    public Boolean userRetrieve(User user) {
        return userService.userRetrieve(user);
    }

    @PostMapping("userRetrievePassword")
    @ResponseBody
    public Boolean userRetrievePassword(User user) {
        return userService.userRetrievePassword(user) > 0;
    }

    @PostMapping("userInformation")
    @ResponseBody
    public User userInformation(HttpServletRequest request) {
        User user = new User();
        user.setUId((Integer) request.getSession().getAttribute("userId"));
        return userService.userInformation(user);
    }

    @PostMapping("userUpdateInformation")
    @ResponseBody
    public Boolean userUpdateInformation(User user) {
        if (userService.userCountPhone(user) == 0) {
            return userService.userUpdateInformation(user) > 0;
        } else {
            return false;
        }
    }
}
