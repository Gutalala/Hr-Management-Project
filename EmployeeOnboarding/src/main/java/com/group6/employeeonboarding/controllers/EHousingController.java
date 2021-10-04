package com.group6.employeeonboarding.controllers;


import com.group6.employeeonboarding.Common.ResponseStatus;
import com.group6.employeeonboarding.Response.HouseResponse;
import com.group6.employeeonboarding.domains.Employee;
import com.group6.employeeonboarding.domains.FacilityReport;
import com.group6.employeeonboarding.domains.FacilityReportDetail;
import com.group6.employeeonboarding.domains.House;
import com.group6.employeeonboarding.service.EmployeeHousingService;
import com.group6.employeeonboarding.service.FacilityReportDetailService;
import com.group6.employeeonboarding.service.FacilityReportService;
import com.group6.employeeonboarding.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class EHousingController {

    EmployeeHousingService employeeHousingService;

    HouseService houseService;

    FacilityReportService facilityReportService;

    FacilityReportDetailService facilityReportDetailService;

    @Autowired
    public void setFacilityReportDetailService(FacilityReportDetailService facilityReportDetailService){this.facilityReportDetailService = facilityReportDetailService;}

    @Autowired
    public void setFacilityReportService(FacilityReportService facilityReportService){this.facilityReportService = facilityReportService;}

    @Autowired
    public void setHouseService(HouseService houseService){this.houseService = houseService;}

    @Autowired
    public void setEmployeeHousingService(EmployeeHousingService employeeHousingService){this.employeeHousingService = employeeHousingService;}

    @PostMapping(value = "api/housing/employees")
    public ResponseEntity getEmployeeByHouse(@RequestBody int house_id){
        List<Employee> employeeList = new ArrayList<>();
        try {
            employeeList = this.employeeHousingService.findEmployeeByHouse(house_id);
            return new ResponseEntity<>(employeeList, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(employeeList, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "api/housing/house")
    public HouseResponse getHouseById(@RequestBody int house_id){
        HouseResponse houseResponse = new HouseResponse();
        Optional<House> matchedHouse = Optional.ofNullable(houseService.findHouseById(house_id));

        if (!matchedHouse.isPresent()){
            ResponseStatus responseStatus = new ResponseStatus(false, "No house with matched id found");
            houseResponse.setResponseStatus(responseStatus);
            return houseResponse;
        }

        ResponseStatus responseStatus = new ResponseStatus(true, "House with Matched ID Found");
        houseResponse.setResponseStatus(responseStatus);
        houseResponse.setHouse(matchedHouse.get());
        return houseResponse;
    }

    @PostMapping(value = "api/housing/house/createReport")
    public ResponseEntity createReport(@RequestBody FacilityReport facilityReport){
        int report_id = -1;
        try {
            report_id = this.facilityReportService.createReport(facilityReport);
            return new ResponseEntity<>(report_id, HttpStatus.CREATED);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(report_id, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "api/housing/house/viewReport")
    public ResponseEntity getReportByHouseId(@RequestBody int house_id){
        List<FacilityReport> facilityReportList = new ArrayList<>();
        List<Employee> employeeList = new ArrayList<>();
        employeeList = this.employeeHousingService.findEmployeeByHouse(house_id);

        try {
            for (Employee employee: employeeList) {
                facilityReportList.addAll(this.facilityReportService.getReportByEmployeeId(employee.getId()));
            }
            return new ResponseEntity<>(facilityReportList, HttpStatus.CREATED);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(facilityReportList, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "api/housing/house/viewReport/addComment")
    public void addComment(@RequestBody FacilityReportDetail facilityReportDetail){
        try {
            this.facilityReportDetailService.addComment(facilityReportDetail);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @PutMapping(value = "api/housing/house/viewReport/updateComment")
    public void updateComment(@RequestBody FacilityReportDetail facilityReportDetail){
        try {
            this.facilityReportDetailService.updateComment(facilityReportDetail);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @PostMapping(value = "api/housing/house/viewReport/viewComment")
    public ResponseEntity getCommentsByReportId(@RequestBody int report_id){
        List<FacilityReportDetail> facilityReportDetailList = new ArrayList<>();
        try {
            facilityReportDetailList = this.facilityReportDetailService.getCommentsByReportId(report_id);
            return new ResponseEntity(facilityReportDetailList, HttpStatus.CREATED);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(facilityReportDetailList, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
