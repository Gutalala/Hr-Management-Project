package com.groupsix.auth.dao.impl;

import com.groupsix.auth.bean.User;
import com.groupsix.auth.dao.AbstractHibernateDAO;
import com.groupsix.auth.dao.UserDAO;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;

@Repository("userHibernateDAO")
public class UserHibernateDAO extends AbstractHibernateDAO<User> implements UserDAO {

    @Override
    public User getUserByUsername(String username) {
        User user = null;
        String sql = "FROM User WHERE username = '" + username + "'";
        Query query = sessionFactory.getCurrentSession().createQuery(sql);
        try {
            user = (User) query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println("User does not exists using username");
        }
        return user == null ? getUserByEmail(username) : user;
    }

    @Override
    public User getUserByEmail(String email) {
        User user = null;
        String sql = "FROM User WHERE email = '" + email + "'";
        Query query = sessionFactory.getCurrentSession().createQuery(sql);
        try {
            user = (User) query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println("User doest not exists using email");
        }
        return user;
    }
}
