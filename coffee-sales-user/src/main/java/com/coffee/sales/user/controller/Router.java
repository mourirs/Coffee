package com.coffee.sales.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Router {
    @RequestMapping("login")
    public String login() {
        return "login";
    }

    @RequestMapping("index")
    public String index() {
        return "index";
    }

    @RequestMapping("register")
    public String register() {
        return "register";
    }

    @RequestMapping("retrieve")
    public String retrieve() {
        return "retrieve";
    }

    @RequestMapping("information")
    public String information() {
        return "information";
    }

    @RequestMapping("shopping")
    public String shopping() {
        return "shopping";
    }

    @RequestMapping("shoppingCar")
    public String shoppingCar() {
        return "shoppingCar";
    }

    @RequestMapping("address")
    public String address() {
        return "address";
    }

    @RequestMapping("createOrder")
    public String createOrder() {
        return "createOrder";
    }

    @RequestMapping("orderInFo")
    public String orderInFo() {
        return "orderInFo";
    }

    @RequestMapping("contact")
    public String contact() {
        return "contact";
    }
}
