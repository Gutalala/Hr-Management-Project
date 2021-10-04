import { Component, OnInit } from '@angular/core';
import { House } from 'src/app/models/House/house.model';
import { HrhousingService } from 'src/app/service/hrHousingService/hrhousing.service';
import {MatPaginator} from '@angular/material/paginator';
import {MatTableDataSource} from '@angular/material/table';
import { Employee } from 'src/app/models/Employee/employee.model';
import { EhousingService } from 'src/app/service/ehousingService/ehousing-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view-facility',
  templateUrl: './view-facility.component.html',
  styleUrls: ['./view-facility.component.css']
})
export class ViewFacilityComponent implements OnInit {


  constructor(private hrHousingService: HrhousingService, private eHouseService: EhousingService, private router: Router) {
    this.isHouseList = true;
    this.isViewDetail = false;
    this.isViewReport = false;
    this.isEmployeeList = false;
   }

  houseList: House[];

  employeeList: Employee[];

  currHouse = new House();

  displayedColumns: string[] = ['position', 'name', 'weight', 'symbol'];
  dataSource: any;

  isHouseList: boolean;
  isViewDetail: boolean;
  isViewReport: boolean;
  isEmployeeList: boolean;

  ngOnInit(): void {
    this.hrHousingService.listHouse().subscribe(
      data => {
        console.log(data.body);
        this.houseList = data.body;
      }
    )
  }

  viewDetailCheck(){
    this.isHouseList = false;
    this.isViewDetail = true;
    this.isViewReport = false;
    this.isEmployeeList = false;
  }

  viewReportCheck(){
    this.isHouseList = false;
    this.isViewDetail = false;
    this.isViewReport = true;
    this.isEmployeeList = false;
  }

  viewEmployeeListCheck(){
    this.isHouseList = false;
    this.isViewDetail = false;
    this.isViewReport = false;
    this.isEmployeeList = true;
  }

  viewEmployeeList(){
    this.eHouseService.getEmployeeList(this.currHouse.id).subscribe(
      data => {
        this.employeeList = data.body;
        this.dataSource = new MatTableDataSource<Employee>(this.employeeList);
      }
    );
  }

  deleteHouse(){
    this.hrHousingService.deleteHouse(this.currHouse.id).subscribe();
    this.hrHousingService.listHouse().subscribe(
      data => {
        console.log(data.body);
        this.houseList = data.body;
      }
    )
  }

  routeEmployeeProfile(employee_id: number){
    this.router.navigate(['hr/employeeProfile']);
  }




}
