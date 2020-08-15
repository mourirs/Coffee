package com.coffee.sales.employee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserRoleController {
    private static final String PREFIX = "user/";

    @GetMapping({"assignPermission"})
    public String assignPermission() {
        return "user/assignPermission";
    }

    @GetMapping({"assignRole"})
    public String assignRole() {
        return "user/assignRole";
    }

    @GetMapping({"role"})
    public String role() {
        return "user/role";
    }

    @GetMapping({"user"})
    public String user() {
        return "user/user";
    }

    @GetMapping({"order_monitoring"})
    public String authCert() {
        return "user/order_monitoring";
    }

    @GetMapping({"condition_monitoring"})
    public String authProject() {
        return "user/condition_monitoring";
    }

    @GetMapping({"feedback_monitoring"})
    public String projectType() {
        return "user/feedback_monitoring";
    }
}
