package com.group6.employeeonboarding.dao;

import com.group6.employeeonboarding.domains.FacilityReportDetail;

import java.util.List;

public interface FacilityReportDetailDao {
    List<FacilityReportDetail> getCommentsByReportId(int report_id);
    void addComment(FacilityReportDetail facilityReportDetail);
    void updateComment(FacilityReportDetail facilityReportDetail);
    FacilityReportDetail getCommentById(int id);
}
