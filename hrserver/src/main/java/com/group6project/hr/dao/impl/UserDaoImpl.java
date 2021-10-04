package com.group6project.hr.dao.impl;

import com.group6project.hr.Exception.InvalidUsernameException;
import com.group6project.hr.dao.AbstractHibernateDao;
import com.group6project.hr.dao.UserDao;
import com.group6project.hr.domains.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends AbstractHibernateDao<User> implements UserDao {

    @Override
    public int addUser(User user) throws InvalidUsernameException {
        return (int) getCurrentSession().save(user);
    }
}
