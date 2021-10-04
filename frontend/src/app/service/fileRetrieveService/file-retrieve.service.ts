import { Injectable } from '@angular/core';
import * as S3 from 'aws-sdk/clients/s3';
import { Observable, of } from 'rxjs';
import { FileUpload } from 'src/app/models/FileUpload/fileupload.model';


@Injectable({
  providedIn: 'root'
})


export class FileRetrieveService {

  bucket = new S3(
    {
        accessKeyId: '',
        secretAccessKey: '',
        region: 'us-east-1'
    }
  );

  retrieveDocument(): Observable<any>{
    const fileUploads = new Array();
    const params = {
        Bucket: '',
        Prefix: ''
    };

    console.log("Uploading");
    
    this.bucket.listObjects(params, function (err, data) {
      const fileDatas = data.Contents;
      fileDatas.forEach(function (file) {
        fileUploads.push(new FileUpload(file.Key, 'https://s3.us-east-2.amazonaws.com/' + params.Bucket + '/' + file.Key))
      });
    });

    return of(fileUploads);
  }



  constructor() { }
}
