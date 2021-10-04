package com.group6project.hr.dao;

import com.group6project.hr.domains.FacilityReport;

import java.util.List;

public interface FacilityReportDao {
    int createReport(FacilityReport facilityReport);
    List<FacilityReport> getReportByEmployeeId(int house_id);
}
