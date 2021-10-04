package com.group6project.hr.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;






@Configuration
@EnableTransactionManagement
public class HibernateConfig {
	
	
    @Autowired
    HibernateProperty hibernateProperty;
    
    
    @Bean
    protected LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(
                "com.group6project.hr.domains");
        sessionFactory.setHibernateProperties(hibernateProperties());

        return sessionFactory;
    }
    
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(hibernateProperty.getDriver());
        dataSource.setUrl(hibernateProperty.getUrl());
        dataSource.setUsername(hibernateProperty.getUsername());
        dataSource.setPassword(hibernateProperty.getPassword());

        return dataSource;
    }
    
    private final Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty(
                "hibernate.show_sql", hibernateProperty.getShowsql());
        hibernateProperties.setProperty(
                "hibernate.dialect", hibernateProperty.getDialect());
//        hibernateProperties.setProperty(
//                "hibernate.hbm2ddl.auto", "update");
 

        return hibernateProperties;
    }
    
    

}
