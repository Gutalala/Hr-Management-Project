package com.groupsix.auth.service;

import com.groupsix.auth.bean.User;
import com.groupsix.auth.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginService {

    private UserDAO userHibernateDAO;

    @Autowired
    public void setUserHibernateDAO(UserDAO userDAO){this.userHibernateDAO = userDAO;}

    public User getUserByUsername(String username){
        return userHibernateDAO.getUserByUsername(username);
    }

    public User getUserByEmail(String email){
        return userHibernateDAO.getUserByEmail(email);
    }
}
