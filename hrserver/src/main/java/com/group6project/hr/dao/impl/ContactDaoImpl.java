package com.group6project.hr.dao.impl;

import com.group6project.hr.dao.AbstractHibernateDao;
import com.group6project.hr.dao.ContactDao;
import com.group6project.hr.domains.Contact;
import com.group6project.hr.domains.Employee;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ContactDaoImpl extends AbstractHibernateDao<Contact> implements ContactDao {

    @Override
    public List<Contact> getContactsByEmployeeId(Integer employee_id) {
        List<Contact> contacts = new ArrayList<>();
        String sql = "FROM Contact WHERE employee.id = " + employee_id;
        Query<Contact> query = getCurrentSession().createQuery(sql);
        try {
            contacts = query.getResultList();
        } catch (NoResultException e){
            System.out.println("Cannot find contact with employee_id = " + employee_id);
        }
        return contacts;
    }

    @Override
    public void updateContact(Contact contact){
        getCurrentSession().update(contact);
    }

    @Override
    public void updateContacts(Contact[] contacts){
        for(Contact contact : contacts){
            getCurrentSession().saveOrUpdate(contact);
        }
    }

    @Override
    public void deleteContact(Contact contact) {
        getCurrentSession().delete(contact);
    }
}
