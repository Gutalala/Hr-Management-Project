package com.group6project.hr.service.impl;


import com.group6project.hr.domains.Address6;
import com.group6project.hr.domains.Contact6;
import com.group6project.hr.domains.Employee6;
import com.group6project.hr.domains.VisaStatus6;
import com.group6project.hr.response.AsyncHireResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class AsyncHireService {

    private AsyncService asyncService;
    private HireService hireService;
    private VisaService visaService;

    @Autowired
    public void setVisaService(VisaService visaService){this.visaService = visaService;}

    @Autowired
    public void setHireService(HireService hireService){this.hireService = hireService;}

    @Autowired
    public void setAsyncService(AsyncService asyncService){this.asyncService = asyncService;}

    public AsyncHireResponse asyncCall(Integer id){
        CompletableFuture<List<Employee6>> employeeFuture = asyncService.getEmployeesById(id);
        CompletableFuture<List<Address6>> addressFuture = asyncService.getAddressesById(id);
        CompletableFuture<List<Contact6>> refsFuture = asyncService.getRefById(id);
        CompletableFuture<List<Contact6>> emergencyFuture = asyncService.getEmergencyById(id);
        CompletableFuture<VisaStatus6> visaStatusFuture = asyncService.getVisaStatus(id);



        CompletableFuture<AsyncHireResponse> responseFuture = CompletableFuture.allOf(
                employeeFuture,
                addressFuture,
                refsFuture,
                emergencyFuture,
                visaStatusFuture
        ).thenApply(
                (placeHolder) -> AsyncHireResponse.builder()
                        .employeeResponse(employeeFuture.join())
                        .addressResponse(addressFuture.join())
                        .refsResponse(refsFuture.join())
                        .emergencyResponse(emergencyFuture.join())
                        .visaStatusResponse(visaStatusFuture.join())
                        .build()
        );

        return responseFuture.join();

    }
}
