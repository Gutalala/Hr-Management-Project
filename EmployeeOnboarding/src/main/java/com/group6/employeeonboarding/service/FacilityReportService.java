package com.group6.employeeonboarding.service;

import com.group6.employeeonboarding.dao.FacilityReportDao;
import com.group6.employeeonboarding.domains.FacilityReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FacilityReportService {

    @Autowired
    FacilityReportDao facilityReportDao;

    @Autowired
    public void setFacilityReportDao(FacilityReportDao facilityReportDao){this.facilityReportDao = facilityReportDao;}

    @Transactional
    public int createReport(FacilityReport facilityReport){
        return this.facilityReportDao.createReport(facilityReport);
    }

    @Transactional
    public List<FacilityReport> getReportByEmployeeId(int employee_id){
        return this.facilityReportDao.getReportByEmployeeId(employee_id);
    }


}
