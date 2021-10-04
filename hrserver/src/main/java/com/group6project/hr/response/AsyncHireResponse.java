package com.group6project.hr.response;


import com.group6project.hr.domains.Address6;
import com.group6project.hr.domains.Contact6;
import com.group6project.hr.domains.Employee6;
import com.group6project.hr.domains.VisaStatus6;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class AsyncHireResponse {
    private List<Employee6> employeeResponse;
    private List<Address6> addressResponse;
    private List<Contact6> refsResponse;
    private List<Contact6> emergencyResponse;
    private VisaStatus6 visaStatusResponse;
}
