package com.group6project.hr.service.impl;

import com.group6project.hr.dao.TokenDao;
import com.group6project.hr.domains.RegistrationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TokenService {

    @Autowired
    private TokenDao tokenDao;

    @Autowired
    public void setTokenDao(TokenDao tokenDao){this.tokenDao = tokenDao;}

    @Transactional
    public List<RegistrationToken> getToken(String token){
        return this.tokenDao.getToken(token);
    }

    @Transactional
    public RegistrationToken getSingleToken(String token){
        return this.tokenDao.getSingleToken(token);
    }


}