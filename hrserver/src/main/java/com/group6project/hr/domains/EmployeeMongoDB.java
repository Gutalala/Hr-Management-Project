package com.group6project.hr.domains;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@Document(collection = "Employee")
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeMongoDB {
//    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
//    @PrimaryKeyJoinColumn
//    private Address address;
//
//    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
//    @PrimaryKeyJoinColumn
//    @JsonManagedReference(value="employee_visastatus")
//    private VisaStatus visaStatus;
//
//    @OneToMany(mappedBy = "employee")
//    @JsonManagedReference(value="employee_contact")
    private List<Contact> contact = new ArrayList<>();
//
//    @OneToMany(mappedBy = "employee")
//    @JsonManagedReference(value="employee_personalDocument")
//    private List<PersonalDocument> personalDocuments = new ArrayList<>();

    @Id
    private String id;

    private int user_id;

    private String firstName;

    private String lastName;

    private String middleName;

    private String preferredName;

    private String email;

    private String cellphone;

    private String alternatePhone;

    private String gender;

    private String ssn;

    private String dob;

    private String title;

    private String manager_id;

    private String startDate;

    private String endDate;

    private String avatar;

    private String car;

    private String driverLicense;

    private String driverLicense_expirationDate;

    private int house_id;

}
