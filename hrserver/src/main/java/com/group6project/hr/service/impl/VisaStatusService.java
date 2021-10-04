package com.group6project.hr.service.impl;

import com.group6project.hr.dao.VisaStatusDao;
import com.group6project.hr.dao.impl.VisaStatusDaoImpl;
import com.group6project.hr.domains.VisaStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class VisaStatusService {

    private VisaStatusDao visaStatusDao;

    @Autowired
    public void setVisaStatusDao(VisaStatusDaoImpl visaStatusDao) {this.visaStatusDao = visaStatusDao;}

    @Transactional
    public void updateVisaStatus(VisaStatus visaStatus){
        visaStatusDao.updateVisaStatus(visaStatus);
    }
}
