package com.group6project.hr.dao.impl;

import com.group6project.hr.dao.AbstractHibernateDao;
import com.group6project.hr.dao.AddressDao;
import com.group6project.hr.domains.Address;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class AddressDaoImpl extends AbstractHibernateDao<Address> implements AddressDao {

    @Override
    public void updateAddress(Address address){
        sessionFactory.getCurrentSession().update(address);
    }
}
