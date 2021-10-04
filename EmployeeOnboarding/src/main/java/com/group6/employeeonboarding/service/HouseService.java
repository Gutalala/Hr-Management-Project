package com.group6.employeeonboarding.service;

import com.group6.employeeonboarding.dao.HouseDao;
import com.group6.employeeonboarding.domains.House;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class HouseService {
    @Autowired
    HouseDao houseDao;

    @Autowired
    public void setHouseDao(HouseDao houseDao){this.houseDao = houseDao;}

    @Transactional
    public House findHouseById(int id){
        return this.houseDao.findHouseById(id);
    }

}
