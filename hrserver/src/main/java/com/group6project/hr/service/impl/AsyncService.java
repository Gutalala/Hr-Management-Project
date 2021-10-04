package com.group6project.hr.service.impl;


import com.group6project.hr.dao.HireDao;
import com.group6project.hr.dao.VisaManagementDao;
import com.group6project.hr.domains.Address6;
import com.group6project.hr.domains.Contact6;
import com.group6project.hr.domains.Employee6;
import com.group6project.hr.domains.VisaStatus6;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class AsyncService {

    HireDao hireDao;
    VisaManagementDao visaManagementDao;

    @Autowired
    public void setVisaManagementDao(VisaManagementDao visaManagementDao){this.visaManagementDao = visaManagementDao;}

    @Autowired
    public void setHireDao(HireDao hireDao){this.hireDao = hireDao;}

    @Async("taskExecutor")
    @Transactional
    public CompletableFuture<List<Employee6>> getEmployeesById(Integer id){
        log.info("getEmployeesById");
        return CompletableFuture.completedFuture(hireDao.getEmployees(id));

    }

    @Async("taskExecutor")
    @Transactional
    public CompletableFuture<List<Address6>> getAddressesById(Integer id){
        log.info("getAddressesById");
        return CompletableFuture.completedFuture(hireDao.getAddressById(id));
    }

    @Async("taskExecutor")
    @Transactional
    public CompletableFuture<List<Contact6>> getRefById(Integer id){
        log.info("getRefById");
        return CompletableFuture.completedFuture(hireDao.getRefById(id));
    }

    @Async("taskExecutor")
    @Transactional
    public CompletableFuture<List<Contact6>> getEmergencyById(Integer id){
        log.info("getAddressesById");
        return CompletableFuture.completedFuture(hireDao.getEmergencyById(id));
    }

    @Async("taskExecutor")
    @Transactional
    public CompletableFuture<VisaStatus6> getVisaStatus(Integer id){
        log.info("getVisaStatus");
        return CompletableFuture.completedFuture(visaManagementDao.getVisaStatus(id));
    }

}
