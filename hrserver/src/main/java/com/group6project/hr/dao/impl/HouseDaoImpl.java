package com.group6project.hr.dao.impl;

import com.group6project.hr.dao.AbstractHibernateDao;
import com.group6project.hr.dao.HouseDao;
import com.group6project.hr.domains.House;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class HouseDaoImpl extends AbstractHibernateDao implements HouseDao {
    @Override
    public House findHouseById(int id){
        House house = new House();
        Query q = getCurrentSession().createQuery("SELECT h FROM House h WHERE h.id = :id" , House.class);
        q.setParameter("id", id);
        return (House) q.getSingleResult();
    }

    @Override
    public void addHouse(House house){
        getCurrentSession().save(house);
    }

    @Override
    public List<House> listAllHouse(){
        List<House> houseList = new ArrayList<>();
        Query q = getCurrentSession().createQuery("SELECT h FROM House h", House.class);
        return q.getResultList();
    }

    @Override
    public void deleteHouse(long id){
        getCurrentSession().remove(findHouseById((int) id));
    }

}
