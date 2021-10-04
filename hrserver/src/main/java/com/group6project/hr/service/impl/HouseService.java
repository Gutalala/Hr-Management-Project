package com.group6project.hr.service.impl;

import com.group6project.hr.dao.HouseDao;
import com.group6project.hr.domains.House;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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

    @Transactional
    public void addHouse(House house){
        house.getFacility().setHouse(house);
        this.houseDao.addHouse(house);
    }

    @Transactional
    public List<House> listAllHouse(){
        return this.houseDao.listAllHouse();
    }

    @Transactional
    public void deleteHouse(long id){
        this.houseDao.deleteHouse(id);
    }

}
