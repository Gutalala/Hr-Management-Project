import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/User/user';
import { Employee } from 'src/app/models/Employee/employee.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-employee-home-page',
  templateUrl: './employee-home-page.component.html',
  styleUrls: ['./employee-home-page.component.css']
})
export class EmployeeHomePageComponent implements OnInit {

  user: User;
  employee: Employee;
  constructor(private router: Router) { }

  ngOnInit() {
    
    console.log("currentUser: " + JSON.parse(localStorage.getItem('currentUser')));
    console.log("currentEmployee: " + JSON.parse(localStorage.getItem('currentEmployee')));
    this.user = JSON.parse(localStorage.getItem('currentUser'));
    this.employee = JSON.parse(localStorage.getItem('currentEmployee'));
  }
}
