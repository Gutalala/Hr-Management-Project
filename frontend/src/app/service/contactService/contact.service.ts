import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Contact } from 'src/app/models/Contact/contact.model';

@Injectable({
  providedIn: 'root'
})
export class ContactService {

  updateEndPoint = "/api/updateContact";

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

  updateContact(contact: Contact[]): Observable<Contact>{
    return this.http.post<Contact>(this.updateEndPoint, contact, {
      headers:{
        "Allow-Cross-Origin-Origin": "*"
      }
    }).pipe(catchError(this.handleError));
  }
}
