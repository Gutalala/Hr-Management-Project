package com.group6.employeeonboarding.service;


import com.group6.employeeonboarding.dao.UserDao;
import com.group6.employeeonboarding.domains.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao){this.userDao = userDao;}

    @Transactional
    public int addUser(User user){
        return this.userDao.addUser(user);
    }

}
