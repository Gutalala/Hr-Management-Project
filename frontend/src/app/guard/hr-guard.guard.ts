import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { Employee } from '../models/Employee/employee.model';
import { User } from '../models/User.model';

@Injectable({
  providedIn: 'root'
})
export class HrGuardGuard implements CanActivate {

  user: User;
  employee: Employee;
  constructor(){
    this.user = JSON.parse(localStorage.getItem('currentUser'));
    this.employee = JSON.parse(localStorage.getItem('currentEmployee'));
  }

  canActivate(){
    if (this.user != null && this.employee.manager_id != null) { (3)
      return true;
    } else {
      window.alert("You don't have permission to view this page"); (4)
      return false;
    }
  }
  
}
