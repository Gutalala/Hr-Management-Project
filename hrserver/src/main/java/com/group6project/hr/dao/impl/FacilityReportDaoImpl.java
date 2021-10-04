package com.group6project.hr.dao.impl;

import com.group6project.hr.dao.AbstractHibernateDao;
import com.group6project.hr.dao.FacilityReportDao;
import com.group6project.hr.domains.FacilityReport;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FacilityReportDaoImpl extends AbstractHibernateDao implements FacilityReportDao {

    @Override
    public int createReport(FacilityReport facilityReport) {
        return (int) getCurrentSession().save(facilityReport);
    }

    @Override
    public List<FacilityReport> getReportByEmployeeId(int employee_id) {
        Query q = getCurrentSession().createQuery("SELECT fr FROM FacilityReport fr WHERE fr.employee_id = :employee_id", FacilityReport.class);

        q.setParameter("employee_id", employee_id);

        return q.list();

    }
}
