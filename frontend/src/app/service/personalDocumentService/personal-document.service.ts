import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError, map } from 'rxjs/operators';
import { PersonalDocument } from 'src/app/models/PersonalDocument/personal-document';

@Injectable({
  providedIn: 'root'
})
export class PersonalDocumentService {

  updateEndPoint = "/api/updatePersonalDocument";
  getDocumentsEndPoint = "/api/getPersonalDocuments/${id}";

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

  updatePersonalDocument(personalDocument: PersonalDocument): Observable<PersonalDocument>{
    return this.http.post<PersonalDocument>(this.updateEndPoint, personalDocument, {
      headers:{
        "Allow-Cross-Origin-Origin": "*"
      }
    }).pipe(catchError(this.handleError));
  }

  getPersonalDocumentsById(employee_id: number): Observable<PersonalDocument[]>{
    return this.http.post<PersonalDocument[]>(this.getDocumentsEndPoint, employee_id, {
      headers:{
        "Allow-Cross-Origin-Origin": "*"
      }
    }).pipe(map(employeeList => {
      console.log(<PersonalDocument[]>employeeList);
      return <PersonalDocument[]>employeeList;
    }));
  }
}
