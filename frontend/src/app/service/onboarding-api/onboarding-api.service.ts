import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { HttpHeaders } from '@angular/common/http';
import { catchError } from 'rxjs/operators';
import { Employee } from 'src/app/models/Employee/employee.model';



const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
    Authorization: 'my-auth-token'
  })
};

@Injectable({
  providedIn: 'root'
})

export class OnboardingApiService {

  // onboardingUrl : string = 'https://afc3443e-e440-4aac-8659-cfe7926a64e3.mock.pstmn.io';

  onboardingUrl : string = '/api/onboarding';

  onboardingMongo: string = '/api/onboardingMongo';

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


  //remember to convert date format on backend.

  constructor(private http: HttpClient) {}

  postOnboardingData(employee: Employee): Observable<Employee>{
    return this.http.post<Employee>(this.onboardingMongo, employee)
              .pipe(catchError(this.handleError));

  }
}
