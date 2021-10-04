import { Component, OnInit } from '@angular/core';
import { Employee } from 'src/app/models/Employee/employee.model';
import { User } from 'src/app/models/User/user';

@Component({
  selector: 'app-employee-hr-navigator',
  templateUrl: './employee-hr-navigator.component.html',
  styleUrls: ['./employee-hr-navigator.component.css']
})
export class EmployeeHrNavigatorComponent implements OnInit {

  user: User;
  employee: Employee;
  constructor() { }

  ngOnInit() {
    this.user = JSON.parse(localStorage.getItem('currentUser'));
    this.employee = JSON.parse(localStorage.getItem('currentEmployee'));
    // getEmployee(this.user.id);
  }

  getEmployee(user_id: number){
    // this.employee = employeeService.getEmployee();
  }
}
