import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator, PageEvent } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Employee } from 'src/app/models/Employee/employee.model';
import { EmployeeService } from 'src/app/service/employeeService/employee.service';
import { timer } from 'rxjs';

@Component({
  selector: 'app-view-profile',
  templateUrl: './view-profile.component.html',
  styleUrls: ['./view-profile.component.css']
})
export class ViewProfileComponent implements OnInit {

  displayColumns = ['name', 'ssn', 'startingDate', 'visaType', 'visaStartDate', 'visaEndDate'];
  dataSource: MatTableDataSource<Employee>;

  employeeList: Employee[];

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(private employeeService: EmployeeService) {
    this.getEmployeeList();
  }

  ngOnInit(){
    
  }

  getEmployeeList(){
    // this.employeeList = [];
    // this.employeeList.push(JSON.parse(localStorage.getItem('currentEmployee')));
    this.employeeService.getEmployeeList().subscribe(employeeList => {
      console.log(employeeList);
      this.employeeList = employeeList;
      this.dataSource = new MatTableDataSource(employeeList);
      this.dataSource.paginator = this.paginator;
      this.dataSource.sort = this.sort;
    });
  }

  applyFilter(event: any){
    var filter = event.target.value;
    filter = filter.trim();
    filter = filter.toLowerCase();
    this.dataSource.filter = filter;
  }
}
