package com.group6project.hr.request;

import com.group6project.hr.domains.Contact;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ContactRequest {

    private Contact[] contact;
//    private int id;
//    private String firstName;
//    private String lastName;
//    private String cellphone;
//    private String email;
//    private int employee_id;
//    private String relationship;
//    private String title;
//    private boolean isReference;
//    private boolean isEmergency;
//    private boolean isLandlord;
}
