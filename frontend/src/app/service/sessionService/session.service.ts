import { Injectable } from '@angular/core';
import { Employee } from 'src/app/models/Employee/employee.model';

@Injectable({
  providedIn: 'root'
})
export class SessionService {

  constructor() {
    this.employee.house_id = 1;
    this.employee.id = 68;
  }

  employee = new Employee();
}
