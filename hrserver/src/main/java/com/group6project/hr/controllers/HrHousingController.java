package com.group6project.hr.controllers;


import com.group6project.hr.domains.House;
import com.group6project.hr.service.impl.HouseService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HrHousingController {

    HouseService houseService;

    @Autowired
    public void setHouseService(HouseService houseService){this.houseService = houseService;}

    @PostMapping(value = "api/housing/hr/addHouse/")
    @ApiOperation(value = "Add A House To Database")
    public void addHouse(@RequestBody House house){
        try {
            this.houseService.addHouse(house);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @ApiOperation(value = "List all house", response = Iterable.class)
    @PostMapping(value = "api/housing/hr/listHouse/")
    public List<House> listHouse(){
        List<House> houseList = new ArrayList<>();
        try {
            houseList = this.houseService.listAllHouse();
            return houseList;
        } catch (Exception e){
            e.printStackTrace();
            return houseList;
        }
    }

    @DeleteMapping(value = "api/housing/hr/deleteHouse/{id}")
    @ApiOperation(value = "Delete A House From Database Using House Id")
    public void deleteHouse(@PathVariable long id){
        System.out.println(id);
        try {
            this.houseService.deleteHouse(id);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
