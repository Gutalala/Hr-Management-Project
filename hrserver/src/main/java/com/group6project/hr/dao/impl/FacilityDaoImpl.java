package com.group6project.hr.dao.impl;

import com.group6project.hr.dao.AbstractHibernateDao;
import com.group6project.hr.dao.FacilityDao;
import com.group6project.hr.domains.Facility;
import org.springframework.stereotype.Repository;

@Repository
public class FacilityDaoImpl extends AbstractHibernateDao implements FacilityDao {

    @Override
    public void addFacility(Facility facility){
        getCurrentSession().save(facility);
    }

    @Override
    public void deleteFacility(Facility facility){
        getCurrentSession().remove(facility);
    }

}
