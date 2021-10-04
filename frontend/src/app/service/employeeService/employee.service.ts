import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError, map } from 'rxjs/operators';
import { Employee } from 'src/app/models/Employee/employee.model';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  updateEndPoint = "/api/updateEmployee";
  EmployeeListEndPoint = "/api/getEmployeeList";
  getEmployeeEndPoint = "/api/getEmployee";
  getEndPoint = "/api/employeeById";

  private handleError(error: HttpErrorResponse) {
    if (error.status === 0) {
      // A client-side or network error occurred. Handle it accordingly.
      console.error('An error occurred:', error.error);
    } else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong.
      console.error(
        `Backend returned code ${error.status}, body was: `, error.error);
    }
    // Return an observable with a user-facing error message.
    return throwError(
      'Something bad happened; please try again later.');
  }

  constructor(private http: HttpClient) {}

  getEmployeeByUserid(user_id: number): Observable<any>{
    return this.http.post<Employee>(this.getEmployeeEndPoint, user_id, {observe: 'response'}).pipe(catchError(this.handleError));
  }

  updateEmployee(employee: Employee): Observable<Employee>{
    return this.http.post<Employee>(this.updateEndPoint, employee, {
      headers:{
        "Allow-Cross-Origin-Origin": "*"
      }
    }).pipe(catchError(this.handleError));
  }

  getEmployeeList(): Observable<Employee[]>{
    return this.http.get(this.EmployeeListEndPoint, {
      headers:{
        "Allow-Cross-Origin-Origin": "*"
      }
    }).pipe(map(employeeList => {
      console.log(<Employee[]>employeeList);
      return <Employee[]>employeeList;
    }));
  }
  
  getEmployeeNameById(id: number): Observable<any>{
    return this.http.post<Employee>(this.getEndPoint, id, {observe:'response'}).pipe(catchError(this.handleError));
  }
}







