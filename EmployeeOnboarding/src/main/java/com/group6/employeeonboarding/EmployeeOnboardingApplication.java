package com.group6.employeeonboarding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class EmployeeOnboardingApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeOnboardingApplication.class, args);
    }


}
