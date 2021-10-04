package com.group6project.hr.request;

import com.group6project.hr.domains.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VisaStatusRequest {

    private int id;

    //Fix this line if necessary
    private Employee employee_id;
    private String visaType;
    private String active;
    private String modificationDate;
    private String visaStartDate;
    private String visaEndDate;
}
