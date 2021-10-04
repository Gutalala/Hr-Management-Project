package com.group6project.hr.dao.impl;

import com.group6project.hr.dao.AbstractHibernateDao;
import com.group6project.hr.dao.VisaStatusDao;
import com.group6project.hr.domains.VisaStatus;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class VisaStatusDaoImpl extends AbstractHibernateDao<VisaStatus> implements VisaStatusDao {

    @Override
    public void updateVisaStatus(VisaStatus visaStatus){
        getCurrentSession().update(visaStatus);
    }
}
