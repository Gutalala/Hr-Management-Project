package com.group6.employeeonboarding.service;

import com.group6.employeeonboarding.dao.TokenDao;
import com.group6.employeeonboarding.domains.RegistrationToken;
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
