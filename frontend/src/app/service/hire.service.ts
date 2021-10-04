import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AnySoaRecord } from 'dns';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import {application} from "../models/application.mode"
import { ApplicationReviewResponse } from '../models/ApplicationReviewResponse.model';

@Injectable({
  providedIn: 'root'
})
export class HireService {

  application: application[];
  applicationReviewResponse : ApplicationReviewResponse;

  constructor(private http: HttpClient) { 
  }

  endPoint1: string = "http://localhost:9090/api/accounts";
  endPoint2: string = "http://localhost:9090/api/applicationreview";
  endPoint21: string ="http://localhost:9090/api/rejectApplication";
  endPoint3: string = "http://localhost:9090/api/checktoken/";
  endPoint4: string = "http://localhost:9090/api/getalldocuments";
  endPoint5: string = "http://localhost:9090/api/getallenhanceddocuments";
  endPoint6: string = "http://localhost:9090/api/adddocumentcomment";
  endPoint7: string = "http://localhost:9090/api/getallpendingpersonaldocuments";
  endPoint8: string = "http://localhost:9090/api/approvedocument";
  endPoint9: string = "http://localhost:9090/api/rejectdocument";
  endPoint10: string = "http://localhost:9090/api/gettoken";

  getData(api:string): Observable<any> {

    return this.http.get("http://localhost:9090/api/"+api, {
      headers: {
        "Allow-Cross-Origin-Origin0": "*"
      },
      responseType: "json"
    });
  }


  getFullEmployeeData(empid:Number): Observable<any> {

      return this.http.get("http://localhost:9090/api/getemployeeinfo/"+empid, {
        headers: {
          "Allow-Cross-Origin-Origin0": "*"
        },
        responseType: "json"
      });


  }
  approveDocument(empid: Number, fileid:Number){

    return this.http.get(this.endPoint8 + "?eid=" +empid +"&fileid=" +fileid , {
      headers: {
        "Allow-Cross-Origin-Origin0": "*"
      },
      responseType: "json"
    });


  }

  rejectDocument(empid: Number, fileid:Number){

    return this.http.get(this.endPoint9 + "?eid=" +empid +"&fileid=" +fileid , {
      headers: {
        "Allow-Cross-Origin-Origin0": "*"
      },
      responseType: "json"
    });


  }


  approveEmployeyApplication(empid: Number, comments: string){

    let postData = { 'employeeid': empid, 'comments': comments};
    console.log(postData);

    return this.http.post(
      this.endPoint2, postData,
      {
        headers:{
          "Allow-Cross-Origin-Origin": "*"
        }
      });
    // ).pipe(
    //   map(reviewResponse => {

    //     //console.log(reviewResponse);
    //     // this.applicationReviewResponse = <ApplicationReviewResponse>reviewResponse;
    //     // if(reviewResponse.status.success){
    //     //   console.log('success:' + reviewResponse);
    //     // //  localStorage.setItem('currentUser', JSON.stringify(userResponse.user));
    //     // } else {
    //     //   console.log('error:' + reviewResponse);
    //     //  // localStorage.setItem('message', JSON.stringify(userResponse.status.message));
    //     // }
    //     // return this.applicationReviewResponse;
    //   }
      
    //   )
    // );
  }

  rejectEmployeyApplication(empid: Number, comments: string){

    let postData = { 'employeeid': empid, 'comments': comments};
    console.log(postData);

    return this.http.post(
      this.endPoint21, postData,
      {
        headers:{
          "Allow-Cross-Origin-Origin": "*"
        }
      });
 
  }

  // send token service

  sendTokenEmail(email:String ): Observable<any> {

    return this.http.get(this.endPoint10 + "?email="+email  , {
      headers: {
        "Allow-Cross-Origin-Origin0": "*"
      },
      responseType: "text"
      });

   }


   validateToken(token:String) :Observable<any> {

    return this.http.get(this.endPoint3 +"?token="+ token  , {
      headers: {
        "Allow-Cross-Origin-Origin0": "*"
      },
      responseType: "json"
      });

   }

   getAllDocuments() : Observable<any> {

    return this.http.get(this.endPoint4  , {
      headers: {
        "Allow-Cross-Origin-Origin0": "*"
      },
      responseType: "json"
      });

   }

   getAllEnhancedDocuments() : Observable<any> {

    return this.http.get(this.endPoint5  , {
      headers: {
        "Allow-Cross-Origin-Origin0": "*"
      },
      responseType: "json"
      });

   }

   getAllEnhancedDocumentsPending() : Observable<any> {

    return this.http.get(this.endPoint7  , {
      headers: {
        "Allow-Cross-Origin-Origin0": "*"
      },
      responseType: "json"
      });

   }



   addDocumentComment(empid: Number, comment: string){

    let postData = { 'employeeid': empid, 'comment': comment};
    console.log(postData);

    return this.http.post(
      this.endPoint6, postData,
      {
        headers:{
          "Allow-Cross-Origin-Origin": "*"
        }
      });
 
  }


 

}
