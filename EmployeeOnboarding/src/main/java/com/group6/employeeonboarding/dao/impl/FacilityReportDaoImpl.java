package com.group6.employeeonboarding.dao.impl;

import com.group6.employeeonboarding.dao.AbstractHibernateDAO;
import com.group6.employeeonboarding.dao.FacilityReportDao;
import com.group6.employeeonboarding.domains.FacilityReport;
import com.group6.employeeonboarding.domains.House;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class FacilityReportDaoImpl extends AbstractHibernateDAO implements FacilityReportDao {

    @Override
    public int createReport(FacilityReport facilityReport){
        return (int) getCurrentSession().save(facilityReport);
    }

    @Override
    public List<FacilityReport> getReportByEmployeeId(int employee_id){
        Query q = getCurrentSession().createQuery("SELECT fr FROM FacilityReport fr WHERE fr.employee_id = :employee_id" , FacilityReport.class);

        q.setParameter("employee_id", employee_id);

        return q.list();

    }


}
