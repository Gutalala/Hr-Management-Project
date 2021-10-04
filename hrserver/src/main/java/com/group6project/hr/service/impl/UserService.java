package com.group6project.hr.service.impl;

import com.group6project.hr.Exception.InvalidUsernameException;
import com.group6project.hr.dao.UserDao;
import com.group6project.hr.domains.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao){this.userDao = userDao;}

    @Transactional
    public int addUser(User user) throws InvalidUsernameException {
        return this.userDao.addUser(user);

    }

}