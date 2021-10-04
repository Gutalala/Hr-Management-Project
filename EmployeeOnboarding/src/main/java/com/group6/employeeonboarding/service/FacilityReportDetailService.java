package com.group6.employeeonboarding.service;


import com.group6.employeeonboarding.dao.FacilityReportDetailDao;
import com.group6.employeeonboarding.domains.FacilityReportDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FacilityReportDetailService {

    @Autowired
    FacilityReportDetailDao facilityReportDetailDao;

    @Autowired
    public void setFacilityReportDetailDao(FacilityReportDetailDao facilityReportDetailDao){this.facilityReportDetailDao = facilityReportDetailDao;}

    @Transactional
    public List<FacilityReportDetail> getCommentsByReportId(int report_id){
        return this.facilityReportDetailDao.getCommentsByReportId(report_id);
    }

    @Transactional
    public FacilityReportDetail getCommentById(int id){
        return this.facilityReportDetailDao.getCommentById(id);
    }

    @Transactional
    public void addComment(FacilityReportDetail facilityReportDetail) {
        this.facilityReportDetailDao.addComment(facilityReportDetail);
    }

    @Transactional
    public void updateComment(FacilityReportDetail facilityReportDetail){
        this.facilityReportDetailDao.updateComment(facilityReportDetail);
    }

}
