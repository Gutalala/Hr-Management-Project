package com.group6.employeeonboarding.dao.impl;


import com.group6.employeeonboarding.dao.AbstractHibernateDAO;
import com.group6.employeeonboarding.dao.HouseDao;
import com.group6.employeeonboarding.domains.House;
import com.group6.employeeonboarding.domains.RegistrationToken;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class HouseDaoImpl extends AbstractHibernateDAO implements HouseDao {

    @Override
    public House findHouseById(int id){
        House house = new House();
        Query q = getCurrentSession().createQuery("SELECT h FROM House h WHERE h.id = :id" , House.class);
        q.setParameter("id", id);
        return (House) q.getSingleResult();
    }
}
