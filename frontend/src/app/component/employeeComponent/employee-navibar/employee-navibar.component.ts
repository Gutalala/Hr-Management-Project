import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from 'src/app/models/Employee/employee.model';

@Component({
  selector: 'app-employee-navibar',
  templateUrl: './employee-navibar.component.html',
  styleUrls: ['./employee-navibar.component.css']
})
export class EmployeeNavibarComponent implements OnInit {

  employee: Employee;
  constructor(private router: Router) { }

  ngOnInit() {
    this.employee = JSON.parse(localStorage.getItem('currentEmployee'));
  }

  loadPersonalInformation(){
    // when clicked, fetch information
  }

  logout(){
    localStorage.removeItem('currentUser');
    localStorage.removeItem('currentEmployee');
    this.router.navigate(['/'])
    .then(() => {
      window.location.reload();
    });
  }
}
