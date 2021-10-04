import { Injectable } from '@angular/core';
import * as S3 from 'aws-sdk/clients/s3';


@Injectable({
  providedIn: 'root'
})
export class FileUploadService {

  constructor() { }

  bucket = new S3(
    {
        accessKeyId: '',
        secretAccessKey: '',
        region: 'us-east-2'
    }
  );

  uploadAvatar(file: any, username: string){
    const contentType = file.type;

      const params = {
        Bucket: '',
        Key: username + '/avatar/' + file.name,
        Body: file,
        ContentType: contentType
    };

    console.log("Uploading");
    
    this.bucket.upload(params, function (err: any, data: any) {
      if (err) {
          console.log('There was an error uploading your file: ', err);
          return false;
      }
      console.log('Successfully uploaded file.', data);
      return true;
  });
}

  uploadDocument(file: any){
    const contentType = file.type;
      const params = {
        Bucket: '',
        Key: file.name,
        Body: file,
        ContentType: contentType
    };

    console.log("Uploading");
    
    this.bucket.upload(params, function (err: any, data: any) {
      if (err) {
          console.log('There was an error uploading your file: ', err);
          return false;
      }
      console.log('Successfully uploaded file.', data);
      return true;
  });
  }
}
