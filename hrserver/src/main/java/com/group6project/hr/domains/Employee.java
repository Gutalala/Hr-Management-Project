package com.group6project.hr.domains;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Employee")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Employee implements Serializable {

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Address address;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    @JsonManagedReference(value="employee_visastatus")
    private VisaStatus visaStatus;

    @OneToMany(mappedBy = "employee")
    @JsonManagedReference(value="employee_contact")
    private List<Contact> contact = new ArrayList<>();

    @OneToMany(mappedBy = "employee")
    @JsonManagedReference(value="employee_personalDocument")
    private List<PersonalDocument> personalDocuments = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @Column(name = "user_id")
    private int user_id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "middleName")
    private String middleName;

    @Column(name = "preferredName")
    private String preferredName;

    @Column(name = "email")
    private String email;

    @Column(name = "cellphone")
    private String cellphone;

    @Column(name = "alternatePhone")
    private String alternatePhone;

    @Column(name = "gender")
    private String gender;

    @Column(name = "ssn")
    private String ssn;

    @Column(name = "dob")
    private String dob;

    @Column(name = "title")
    private String title;

    @Column(name = "manager_id")
    private String manager_id;

    @Column(name = "startDate")
    private String startDate;

    @Column(name = "endDate")
    private String endDate;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "car")
    private String car;

    @Column(name = "driverLicense")
    private String driverLicense;

    @Column(name = "driverLicense_expirationDate")
    private String driverLicense_expirationDate;

    @Column(name = "house_id")
    private int house_id;



}