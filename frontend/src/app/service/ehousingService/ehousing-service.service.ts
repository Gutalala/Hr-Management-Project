import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { HttpHeaders } from '@angular/common/http';
import { catchError } from 'rxjs/operators';
import { FacilityReport } from 'src/app/models/FacilityReport/facilityreport.model';
import { Facilityreportdetail } from 'src/app/models/FacilityReportDetail/facilityreportdetail.model';


@Injectable({
  providedIn: 'root'
})


export class EhousingService {

  houseEndPoint: string = 'api/housing/house';
  employeeListEndpoint: string = 'api/housing/employees';
  createReportEndpoint: string = 'api/housing/house/createReport';
  viewReportEndpoint: string = 'api/housing/house/viewReport';
  viewCommentEndpoint: string = 'api/housing/house/viewReport/viewComment';
  addCommentEndpoint: string = 'api/housing/house/viewReport/addComment';
  updateCommentEndpoint: string = 'api/housing/house/viewReport/updateComment';


  constructor(private httpClient: HttpClient) { }

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

  public getHouse(house_id: number): Observable<any>{
    return this.httpClient.post(this.houseEndPoint, house_id, {observe: 'response'}).pipe(catchError(this.handleError));
  }

  public getEmployeeList(house_id: number): Observable<any>{
    return this.httpClient.post(this.employeeListEndpoint, house_id, {observe: 'response'}).pipe(catchError(this.handleError));
  }

  public createReport(facilityReport: FacilityReport): Observable<any>{
    return this.httpClient.post(this.createReportEndpoint, facilityReport, {observe: 'response'}).pipe(catchError(this.handleError));
  }

  public viewReport(house_id: number): Observable<any>{
    return this.httpClient.post(this.viewReportEndpoint, house_id, {observe: 'response'}).pipe(catchError(this.handleError));
  }

  public viewComment(report_id: number): Observable<any>{
    return this.httpClient.post(this.viewCommentEndpoint, report_id, {observe: 'response'}).pipe(catchError(this.handleError));
  }

  public addComment(report: Facilityreportdetail): Observable<any>{
    return this.httpClient.post(this.addCommentEndpoint, report).pipe(catchError(this.handleError));
  }

  
  public updateComment(report: Facilityreportdetail): Observable<any>{
    return this.httpClient.put(this.updateCommentEndpoint, report).pipe(catchError(this.handleError));
  }



}
