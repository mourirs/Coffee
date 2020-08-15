package com.coffee.sales.user.service.impl;

import com.coffee.sales.user.bean.Contact;
import com.coffee.sales.user.dao.ContactMapper;
import com.coffee.sales.user.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {
    private final ContactMapper contactMapper;

    @Autowired
    public ContactServiceImpl(ContactMapper contactMapper) {
        this.contactMapper = contactMapper;
    }

    @Override
    public Integer insertInFo(Contact contact) {
        return contactMapper.insertInFo(contact);
    }
}
