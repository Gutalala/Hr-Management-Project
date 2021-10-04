package com.group6project.hr.dao;

import com.group6project.hr.Exception.InvalidUsernameException;
import com.group6project.hr.domains.User;

public interface UserDao {

    int addUser(User user) throws InvalidUsernameException;
}
