package com.coffee.sales.employee.service.impl;

import com.coffee.sales.employee.bean.Contact;
import com.coffee.sales.employee.dao.ContactMapper;
import com.coffee.sales.employee.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    private final ContactMapper contactMapper;

    @Autowired
    public ContactServiceImpl(ContactMapper contactMapper) {
        this.contactMapper = contactMapper;
    }

    @Override
    public List<Contact> contactAllInFo() {
        return contactMapper.contactAllInFo();
    }
}
