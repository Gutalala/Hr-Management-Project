package com.group6project.hr.dao.impl;

import com.group6project.hr.dao.AbstractHibernateDao;
import com.group6project.hr.dao.EmployeeDao;
import com.group6project.hr.domains.Address;
import com.group6project.hr.domains.Contact;
import com.group6project.hr.domains.Employee;
import com.group6project.hr.domains.VisaStatus;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDaoImpl extends AbstractHibernateDao<Employee> implements EmployeeDao{

    @Override
    public Employee getEmployeeByUserId(Integer user_id){
        Employee employee = null;
        String sql = "FROM Employee WHERE user_id = " + user_id;
        Query query = getCurrentSession().createQuery(sql);
        try {
            employee = (Employee) query.getSingleResult();
        } catch (NoResultException e){
            System.out.println("Cannot find Employee with user_id = " + user_id);
        }
        return employee;
    }

    @Override
    public List<Employee> getEmployeeList() {
        List<Employee> employeeList = new ArrayList<>();
        String sql = "FROM Employee";
        Query<Employee> query = getCurrentSession().createQuery(sql);
        try {
            employeeList = query.getResultList();
        } catch (NoResultException e){
            System.out.println("Cannot find Employee");
        }
        return employeeList;
    }

    @Override
    public void updateEmployee(Employee employee){
        getCurrentSession().update(employee);
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
