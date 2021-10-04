package com.group6project.hr.dao;

import com.group6project.hr.domains.EmployeeMongoDB;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeMongoDBDAO extends MongoRepository<EmployeeMongoDB, String> {

}
