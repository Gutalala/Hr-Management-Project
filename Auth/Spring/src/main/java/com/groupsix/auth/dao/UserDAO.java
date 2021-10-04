package com.groupsix.auth.dao;

import com.groupsix.auth.bean.User;

public interface UserDAO {
    User getUserByUsername(String username);
    User getUserByEmail(String email);
}
