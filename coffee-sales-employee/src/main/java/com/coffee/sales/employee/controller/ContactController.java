package com.coffee.sales.employee.controller;

import com.coffee.sales.employee.bean.Contact;
import com.coffee.sales.employee.service.ContactService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping("contactAllInFo")
    public PageInfo<Contact> contactAllInFo(@RequestParam(defaultValue = "1", name = "pageNumber") Integer pageNumber) {
        PageHelper.startPage(pageNumber, 6);
        return new PageInfo<>(contactService.contactAllInFo());
    }
}
