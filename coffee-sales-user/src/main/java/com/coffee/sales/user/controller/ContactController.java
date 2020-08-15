package com.coffee.sales.user.controller;

import com.coffee.sales.user.bean.Contact;
import com.coffee.sales.user.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping("contactInFo")
    public Boolean contactInFo(Contact contact) {
        return contactService.insertInFo(contact) > 0;
    }

}
