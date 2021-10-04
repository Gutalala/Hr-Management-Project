import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { HttpHeaders } from '@angular/common/http';
import { catchError } from 'rxjs/operators';
import { Token } from 'src/app/models/Token/token.model';

@Injectable({
  providedIn: 'root'
})
export class TokenApiService {

  constructor(private http: HttpClient) {  }

  endpoint : string = '/api/accountToken';

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

  public getToken(token: string): Observable<any>{
    return this.http.post<Token>(this.endpoint, token, {observe: 'response'}).pipe(catchError(this.handleError));
  }

}
