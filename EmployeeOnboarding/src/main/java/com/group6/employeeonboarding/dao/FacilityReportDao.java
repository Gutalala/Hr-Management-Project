package com.group6.employeeonboarding.dao;

import com.group6.employeeonboarding.domains.FacilityReport;

import java.util.List;

public interface FacilityReportDao {
    int createReport(FacilityReport facilityReport);
    List<FacilityReport> getReportByEmployeeId(int house_id);
}
