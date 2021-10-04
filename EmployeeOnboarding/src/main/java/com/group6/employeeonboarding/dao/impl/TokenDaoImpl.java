package com.group6.employeeonboarding.dao.impl;


import com.group6.employeeonboarding.dao.AbstractHibernateDAO;
import com.group6.employeeonboarding.dao.TokenDao;
import com.group6.employeeonboarding.domains.RegistrationToken;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TokenDaoImpl extends AbstractHibernateDAO<RegistrationToken> implements TokenDao {

    @Override
    public void generateToken() {

    }

    @Override
    public List<RegistrationToken> getToken(String token) {

        Query q = getCurrentSession().createQuery("SELECT t FROM RegistrationToken t WHERE t.token = \'" +token + "\' " , RegistrationToken.class);

        return q.list();
    }

    @Override
    public RegistrationToken getSingleToken(String token) {

        Query q = getCurrentSession().createQuery("SELECT t FROM RegistrationToken t WHERE t.token = \'" +token + "\' " , RegistrationToken.class);

        return (RegistrationToken) q.getSingleResult();
    }


    @Override
    public void saveToken(RegistrationToken token) {
        getCurrentSession().save(token);

    }


}