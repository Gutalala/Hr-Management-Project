import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MatTableDataSource } from '@angular/material/table';
import * as FileSaver from 'file-saver';
import { HireService } from 'src/app/service/hire.service';
import { VisaService } from 'src/app/service/visa.service';

@Component({
  selector: 'app-hrcomponenttrackingtable',
  templateUrl: './hrcomponenttrackingtable.component.html',
  styleUrls: ['./hrcomponenttrackingtable.component.css']
})
export class HrcomponenttrackingtableComponent implements OnInit {

  isEmptyFile : boolean = false;

  uploadForm: FormGroup; 
  dataEmployeeVisaList = new MatTableDataSource();
  displayedVisaColumnsList: string[] = [ 'name', 'work', 'exp', 'dayleft',   'notification'];

  
  constructor(private visaService:VisaService , private hireservice: HireService,private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.uploadForm = this.formBuilder.group({
      file: ['']
});

    this.visaService.getAllEmployeeVisaWhichNeedsNotification().subscribe(data=>{
      console.log(data.length);

 

      this.dataEmployeeVisaList.data = data;

    });

  }


  sendNotification1(status:string , email:string){

    if(status = 'OPT Receipt'){

        this.visaService.sendNotificationEmail('optreceipt', email).subscribe(data=>console.log(200));

    }








}

sendNotification2(status:string , email:string){

  if(status = 'OPT EAD'){

    this.visaService.sendNotificationEmail('optead', email).subscribe(data=>console.log(200));

}

}

sendNotification3(status:string , email:string){


  if(status = 'I-983 Approved'){

    this.visaService.sendNotificationEmail('i983approved', email).subscribe(data=>console.log(200));

}

}

sendNotification4(status:string , email:string){

  if(status = 'I-20'){

    this.visaService.sendNotificationEmail('i20', email).subscribe(data=>console.log(200));

}

}

sendNotification5(status:string , email:string){

  if(status = 'OPT STEM Receipt'){

    this.visaService.sendNotificationEmail('optstemreceipt', email).subscribe(data=>console.log(200));
  
  }
   

}


src : Blob;
previewurl: any;

previewFile(empid: Number ){

  console.log(empid);

    this.visaService.geti983byempid(empid).subscribe(data=>{

      let filename = data.filename;

      let strarray = filename.split('.');
      let last = strarray[strarray.length - 1];
      let type = 'application/pdf;charset=utf-8';
  
      if(last == 'docx'){
        type = 'application/vnd.openxmlformats-officedocument.wordprocessingml.document';
      }
      
      if(last == 'doc'){
        type = 'application/msword';
      }


      this.visaService.getFileBlob(data.id).subscribe(data=>{

        var blob = new Blob([data],  {type: type   }  );
 
        let url = URL.createObjectURL(blob);
        this.previewurl = url;
        console.log(url);
 
        this.src =  data;
      // console.log( this.previewSrc);
 
     //  FileSaver.saveAs(blob, filename);
     });


    });



}


downloadFile(empid: Number ){
  console.log(empid);

    this.visaService.geti983byempid(empid).subscribe(data=>{

      let filename = data.filename;

      let strarray = filename.split('.');
      let last = strarray[strarray.length - 1];
      let type = 'application/pdf;charset=utf-8';
  
      if(last == 'docx'){
        type = 'application/vnd.openxmlformats-officedocument.wordprocessingml.document';
      }
      
      if(last == 'doc'){
        type = 'application/msword';
      }


      this.visaService.getFileBlob(data.id).subscribe(data=>{

        var blob = new Blob([data],  {type: type   }  );
 
        FileSaver.saveAs(blob, filename);
      // console.log( this.previewSrc);
 
     //  FileSaver.saveAs(blob, filename);
     });


    });
  


}


onFileSelect(event:any) {
  if (event.target.files.length > 0) {
    const file = event.target.files[0];
    this.isEmptyFile = false;
    console.log(file.type);
    
    if(file.type.includes('jpeg') || file.type.includes('msword') || file.type.includes('pdf') || file.type.includes('officedocument') ){
      console.log("valid file");
      this.uploadForm.get('file').setValue(file);  


    }
  }
}


onSubmit2(empid:Number ) {





  const formData = new FormData();
  formData.append('title',   'I-983 Approved');
  formData.append('employeeid',  ''+ empid);
  formData.append('file', this.uploadForm.get('file').value);

  if(this.uploadForm.get('file').value.name != undefined  ){
    console.log("call upload file service");
     this.visaService.uploadDocument(formData);

     console.log('call change status service');

    this.visaService.changeVisaStatus(empid, 'I-983 Approved').subscribe(
       
       
       data=>{console.log(data);

        window.location.reload();

       
      }
       
       
  );
 }
 else{
   console.log('empty file');
   this.isEmptyFile = true;
 }



}


}
