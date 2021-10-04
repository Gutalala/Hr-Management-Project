package com.group6project.hr.dao;

import com.group6project.hr.domains.FacilityReportDetail;

import java.util.List;

public interface FacilityReportDetailDao {
    List<FacilityReportDetail> getCommentsByReportId(int report_id);
    void addComment(FacilityReportDetail facilityReportDetail);
    void updateComment(FacilityReportDetail facilityReportDetail);
    FacilityReportDetail getCommentById(int id);
}
