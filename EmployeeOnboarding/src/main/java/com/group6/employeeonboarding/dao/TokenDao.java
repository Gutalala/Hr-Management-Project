package com.group6.employeeonboarding.dao;

import com.group6.employeeonboarding.domains.RegistrationToken;

import java.util.List;

public interface TokenDao {


    void saveToken(RegistrationToken token);

    void generateToken();

    List<RegistrationToken> getToken(String token);

    RegistrationToken getSingleToken(String token);

}