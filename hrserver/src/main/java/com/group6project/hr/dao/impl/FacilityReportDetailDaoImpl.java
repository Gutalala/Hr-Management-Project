package com.group6project.hr.dao.impl;

import com.group6project.hr.dao.AbstractHibernateDao;
import com.group6project.hr.dao.FacilityReportDetailDao;
import com.group6project.hr.domains.FacilityReportDetail;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FacilityReportDetailDaoImpl extends AbstractHibernateDao implements FacilityReportDetailDao {

    @Override
    public List<FacilityReportDetail> getCommentsByReportId(int report_id){
        List<FacilityReportDetail> facilityReportDetailList = new ArrayList<>();
        Query q = getCurrentSession().createQuery("SELECT frd FROM FacilityReportDetail frd WHERE frd.facilityReport_id = :report_id" , FacilityReportDetail.class);
        q.setParameter("report_id", report_id);
        return q.list();
    };

    @Override
    public FacilityReportDetail getCommentById(int id){
        Query q = getCurrentSession().createQuery("SELECT frd FROM FacilityReportDetail frd WHERE frd.id = :id" , FacilityReportDetail.class);
        q.setParameter("id", id);
        return (FacilityReportDetail) q.getSingleResult();
    }

    @Override
    public void addComment(FacilityReportDetail facilityReportDetail){
        getCurrentSession().save(facilityReportDetail);
    };

    @Override
    public void updateComment(FacilityReportDetail facilityReportDetail){
        FacilityReportDetail newfacilityReportDetail = getCommentById(facilityReportDetail.getId());
        newfacilityReportDetail.setComments(facilityReportDetail.getComments());
        newfacilityReportDetail.setLastModificationDate(facilityReportDetail.getLastModificationDate());
        getCurrentSession().save(newfacilityReportDetail);
    };
}