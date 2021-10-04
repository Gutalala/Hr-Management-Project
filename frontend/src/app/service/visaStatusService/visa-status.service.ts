import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { VisaStatus } from 'src/app/models/VisaStatus/visa-status.model';

@Injectable({
  providedIn: 'root'
})
export class VisaStatusService {

  updateEndPoint = "/api/updateVisaStatus";

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

  updateVisaStatus(visaStatus: VisaStatus): Observable<VisaStatus>{
    return this.http.post<VisaStatus>(this.updateEndPoint, visaStatus, {
      headers:{
        "Allow-Cross-Origin-Origin": "*"
      }
    }).pipe(catchError(this.handleError));

  }
}
