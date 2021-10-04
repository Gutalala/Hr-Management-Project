import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Employee } from 'src/app/models/Employee/employee.model';
import { FacilityReport } from 'src/app/models/FacilityReport/facilityreport.model';
import { House } from 'src/app/models/House/house.model';
import { EhousingService } from 'src/app/service/ehousingService/ehousing-service.service';
import { SessionService } from 'src/app/service/sessionService/session.service';

@Component({
  selector: 'app-ehousing',
  templateUrl: './ehousing.component.html',
  styleUrls: ['./ehousing.component.css']
})
export class EhousingComponent implements OnInit {

  constructor(private httpClient: HttpClient, private ehouseService: EhousingService, private sessionService: SessionService) { }

  house = new House();

  reportChoice: string;
  employee: Employee;

  scroll(el: HTMLElement) {
    el.scrollIntoView();
}

  nameFilter(employee: Employee){
    if (!employee.preferredName)
      return employee.firstName;
    else
      return employee.preferredName;
  }

  employeeList: Employee[];

  ngOnInit(): void {
    this.employee = JSON.parse(localStorage.getItem('currentEmployee'));
    this.ehouseService.getHouse(this.employee.house_id).subscribe(
      data => {
        this.house = data.body.house;
      }
    );
    
    this.ehouseService.getEmployeeList(this.employee.house_id).subscribe(
      data => {this.employeeList = data.body;
      }
    );
  }
}
