import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { HttpHeaders } from '@angular/common/http';
import { catchError } from 'rxjs/operators';
import { House } from 'src/app/models/House/house.model';

@Injectable({
  providedIn: 'root'
})
export class HrhousingService {

  constructor(private httpClient: HttpClient) { }

  addHouseEndpoint: string = 'api/housing/hr/addHouse/';
  listHouseEndpoint: string = 'api/housing/hr/listHouse/';
  deleteHouseEndpoint: string = 'api/housing/hr/deleteHouse/';


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

  public addHouse(house: House): Observable<any>{
    return this.httpClient.post(this.addHouseEndpoint, house).pipe(catchError(this.handleError));
  }

  public listHouse(): Observable<any>{
    return this.httpClient.post(this.listHouseEndpoint, null, {observe : 'response'}).pipe(catchError(this.handleError));
  }

  public deleteHouse(house_id: number): Observable<any>{
    return this.httpClient.delete(this.deleteHouseEndpoint+ house_id).pipe(catchError(this.handleError));
  }

}
