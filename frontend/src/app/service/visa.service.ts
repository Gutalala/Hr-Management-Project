import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AnyNsRecord } from 'dns';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class VisaService {

  constructor(private httpClient: HttpClient) {
 
   }

   endPoint1: string = "http://localhost:9090/api/getempid/";
   endPoint2: string = "http://localhost:9090/api/getvisastatus2/";
   endPoint3: string = "http://localhost:9090/api/getvisastatus/";
   endPoint4: string = "http://localhost:9090/api/changeoptstatus";
   endPoint5: string = "http://localhost:9090/api/getallemployeevisadata";
   endPoint6: string = "http://localhost:9090/api/sendnotificationemail";
   endPoint7: string = "http://localhost:9090/api/getallpersonaldocuments/";
   endPoint8: string = "http://localhost:9090/api/geti983byempid/";


   employeeId : Number;

   getEmployeeId(userId:Number): Observable<any> {

       return this.httpClient.get(this.endPoint1 + userId, {
          headers: {
            "Allow-Cross-Origin-Origin0": "*"
          },
          responseType: "json"
           }) ;
 
   }

   getVisastatus(empid:  Number):  Observable<any> {

    return this.httpClient.get(this.endPoint3 + empid, {
    headers: {
      "Allow-Cross-Origin-Origin0": "*"
    },
    responseType: "json"
    });
    
    // .subscribe(data=> {
    
    //     console.log(data);

    //     localStorage.setItem('visastatus', JSON.stringify(data));
  
    // }
    
    // );

    // return ;

 }


   getOptstatus(empid:Number):  Observable<any> {

      return this.httpClient.get(this.endPoint2 + empid, {
      headers: {
        "Allow-Cross-Origin-Origin0": "*"
      },
      responseType: "text"
      });
      
      // .subscribe(data=> {
      
      //     console.log(data);

      //     localStorage.setItem('visastatus', JSON.stringify(data));
    
      // }
      
      // );

      // return ;

   }

   changeVisaStatus(empid:Number, status:String): Observable<any> {

    return this.httpClient.get(this.endPoint4 + "?empid="+empid+"&status="+status , {
      headers: {
        "Allow-Cross-Origin-Origin0": "*"
      },
      responseType: "text"
      });

   }

   uploadDocument(formData: any ){

      const SERVER_URL = "http://localhost:9090/api/uploadfile";

      return  this.httpClient.post<any>( SERVER_URL, formData).subscribe(
        (res) => console.log(res),
        (err) => console.log(err)
      );


   }


   getFile(): Observable<any>{

    const SERVER_URL = "http://localhost:9090/api/getfile";

    return  this.httpClient.get<any>( SERVER_URL);
  }

   
  getAllEmployeeVisaWhichNeedsNotification():  Observable<any> {

    return this.httpClient.get(this.endPoint5 , {
    headers: {
      "Allow-Cross-Origin-Origin0": "*"
    },
    responseType: "json"
    });
 

  }

  getFileBlob(fileid:any):  Observable<any> {

    return this.httpClient.get("http://localhost:9090/api/" + fileid + "/document/download" , {
    headers: {
      "Allow-Cross-Origin-Origin0": "*"
    },
    responseType: "blob"
    });
 

  }


  sendNotificationEmail(status:string , email:string){

    return this.httpClient.get(this.endPoint6 + "?status="+status +"&email="+email , {
      headers: {
        "Allow-Cross-Origin-Origin0": "*"
      },
      responseType: "json"
      });
  }



  getAllPersonalDocuments(empid:Number): Observable<any> {

    return this.httpClient.get(this.endPoint7 + empid, {
      headers: {
        "Allow-Cross-Origin-Origin0": "*"
      },
      responseType: "json"
    });


}


geti983byempid(empid:Number): Observable<any> {

  return this.httpClient.get(this.endPoint8 + empid, {
    headers: {
      "Allow-Cross-Origin-Origin0": "*"
    },
    responseType: "json"
  });


}



 


}
