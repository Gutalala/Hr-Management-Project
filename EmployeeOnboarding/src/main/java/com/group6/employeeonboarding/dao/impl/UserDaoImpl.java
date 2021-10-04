package com.group6.employeeonboarding.dao.impl;


import com.group6.employeeonboarding.dao.AbstractHibernateDAO;
import com.group6.employeeonboarding.dao.UserDao;
import com.group6.employeeonboarding.domains.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends AbstractHibernateDAO implements UserDao {

    @Override
    public int addUser(User user){
        return (int) getCurrentSession().save(user);
    }

}
