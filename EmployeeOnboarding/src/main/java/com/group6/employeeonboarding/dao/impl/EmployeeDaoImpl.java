package com.group6.employeeonboarding.dao.impl;

import com.group6.employeeonboarding.dao.AbstractHibernateDAO;
import com.group6.employeeonboarding.dao.EmployeeDao;
import com.group6.employeeonboarding.domains.*;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class EmployeeDaoImpl extends AbstractHibernateDAO implements EmployeeDao {

    public EmployeeDaoImpl(){
        setClazz(Employee.class);
    }

    public int addEmployee(Employee employee) {
        int id = (Integer) getCurrentSession().save(employee);
        return id;
    }

    public int addContact(Contact contact){
        getCurrentSession().save(contact);
        return -1;
    }

    public int addAddress(Address address){
        getCurrentSession().save(address);
        return -1;
    }

    public int addVisaStatus(VisaStatus visaStatus){
        getCurrentSession().save(visaStatus);
        return -1;
    }

    public List<Employee> findEmployeeByHouse(int house_id){
        Query q = getCurrentSession().createQuery("SELECT e FROM Employee e WHERE e.house_id = :house_id", Employee.class);
        q.setParameter("house_id", house_id);
        List<Employee> employeeList = q.list();
        return employeeList;
    }

    public Employee findEmployeeById(int employee_id){
        Query q = getCurrentSession().createQuery("SELECT e FROM Employee e WHERE e.id = :employee_id", Employee.class);
        q.setParameter("employee_id", employee_id);
        return (Employee) q.getSingleResult();
    }

    public String findEmployeeNameById(int employee_id){
        Query q = getCurrentSession().createQuery("SELECT e.firstName FROM Employee e WHERE e.id = :employee_id", Employee.class);
        q.setParameter("employee_id", employee_id);
        return (String) q.getSingleResult();
    }
}
