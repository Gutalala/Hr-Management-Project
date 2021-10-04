package com.group6project.hr.service.impl;

import com.group6project.hr.dao.AddressDao;
import com.group6project.hr.dao.impl.AddressDaoImpl;
import com.group6project.hr.domains.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AddressService {

    private AddressDao addressDao;

    @Autowired
    public void setAddressDao(AddressDaoImpl addressDao) {this.addressDao = addressDao;}

    @Transactional
    public void updateAddress(Address address){
        System.out.println("In Address Service");
        addressDao.updateAddress(address);
    }
}
