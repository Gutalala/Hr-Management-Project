package com.group6project.hr.service.impl;

import com.group6project.hr.dao.ContactDao;
import com.group6project.hr.dao.impl.ContactDaoImpl;
import com.group6project.hr.domains.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ContactService {

    private ContactDao contactDao;

    @Autowired
    public void setContactDao(ContactDaoImpl contactDao) {this.contactDao = contactDao;}

    @Transactional
    public void updateContact(Contact contact){
        contactDao.updateContact(contact);
    }

    @Transactional
    public void updateContacts(Contact[] contacts) { contactDao.updateContacts(contacts); }
}
