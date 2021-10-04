package com.group6project.hr.dao;

import com.group6project.hr.domains.Contact;

import java.util.List;

public interface ContactDao {
    List<Contact> getContactsByEmployeeId(Integer employee_id);
    void updateContact(Contact contact);
    void updateContacts(Contact[] contacts);
    void deleteContact(Contact contact);
}
