package com.group6project.hr.dao;

import com.group6project.hr.domains.House;

import java.util.List;

public interface HouseDao {
    House findHouseById(int id);
    void addHouse(House house);
    List<House> listAllHouse();
    void deleteHouse(long id);
}