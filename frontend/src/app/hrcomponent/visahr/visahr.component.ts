import { Component, OnInit } from '@angular/core';
import { VisaDocument } from 'src/app/models/visadocument.model';
import { VisaStatus } from 'src/app/models/visastatus.model';
import { animate, state, style, transition, trigger } from '@angular/animations';
import { MatTableDataSource } from '@angular/material/table';
import { VisaService } from 'src/app/service/visa.service';
import * as FileSaver from 'file-saver';
import { saveAs } from 'file-saver';
import { FormBuilder, FormGroup } from '@angular/forms';
import { HireService } from 'src/app/service/hire.service';

@Component({
  selector: 'app-visahr',
  templateUrl: './visahr.component.html',
  styleUrls: ['./visahr.component.css'],
  animations: [
    trigger('detailExpand', [
      state('collapsed', style({ height: '0px', minHeight: '0' })),
      state('expanded', style({ height: '*' })),
      transition('expanded <=> collapsed', animate('225ms cubic-bezier(0.4, 0.0, 0.2, 1)')),
    ]),
  ]
})
export class VisahrComponent implements OnInit {

  isTableExpanded = false;
  employeeVisaData : VisaStatus[] = [];
  dataEmployeeVisaList = new MatTableDataSource();
  displayedVisaColumnsList: string[] = ['actions','name', 'work', 'exp', 'dayleft',   'notification'];
  nextStep :  string = '';
  isEmptyFile : boolean = false;

  uploadForm: FormGroup; 

  constructor( private hireservice: HireService, private visaservice: VisaService, private formBuilder: FormBuilder) { }

  ngOnInit() {

    this.uploadForm = this.formBuilder.group({
      file: ['']
});

    this.visaservice.getAllEmployeeVisaWhichNeedsNotification().subscribe(data=>{
      console.log(data.length);

      for(let i = 0 ; i < data.length ; i++){
        
        if(data[i].visaStatus == 'OPT Receipt'){
          data[i].nextStep = 'Please upload a copy of your OPT EAD';
        }
        else if(data[i].visaStatus == 'OPT EAD'){
          console.log('ead');
          data[i].nextStep = 'Please download and fill your I-983 form';
        }
        else if(data[i].visaStatus == 'I-983 Waiting For Approval'){
          data[i].nextStep = 'I-983 Ask for Signature';
  
        }   else if(data[i].visaStatus == 'I-983 Approved'){
          data[i].nextStep = 'Please send the I-983 with all necessary documents to your school and upload the new I-20';
  
        }   else if(data[i].visaStatus == 'I-20'){
          data[i].nextStep = 'Please upload your OPT STEM Receipt';
  
        }    else if(data[i].visaStatus == 'OPT STEM Receipt'){
          data[i].nextStep = 'Please upload your OPT STEM EAD';
  
        }


      }

      data.forEach((element: any) => {
        

          for(let i = 0; i< element.visaDocuments.length; i ++){

            let strarray = element.visaDocuments[i].filename.split('.');
            let last = strarray[strarray.length - 1];
            if(last == 'pdf'){
              element.visaDocuments[i].iconname = "https://upload.wikimedia.org/wikipedia/commons/thumb/8/87/PDF_file_icon.svg/1200px-PDF_file_icon.svg.png";
          }

          if(last == 'docx'){
            element.visaDocuments[i].iconname = "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fb/.docx_icon.svg/512px-.docx_icon.svg.png";
          }
          
          if(last == 'doc'){
            element.visaDocuments[i].iconname= "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fb/.docx_icon.svg/512px-.docx_icon.svg.png";
          }


          }
        
      });

     

      this.dataEmployeeVisaList.data = data;

    });

      // var visadocumentlist : VisaDocument[] = [];
      // let visadocument1 = new VisaDocument( 'word','rere');
      // visadocumentlist.push(visadocument1);
      // let tempVisaEmp = new VisaStatus(6,'Zack', 'yu', 'F1/OPT', 'OPT Receipt', '7/20/21','7/30/21', 10, 'send notification',  visadocumentlist);
      // let tempVisaEmp2 = new VisaStatus(6,'Danny', 'yu', 'F1/OPT', 'OPT Receipt EAD' ,'7/20/21','7/30/21', 10, 'send notification',  visadocumentlist);

      // this.employeeVisaData.push(tempVisaEmp);
      // this.employeeVisaData.push(tempVisaEmp2);

      // console.log(tempVisaEmp);
      // console.log( tempVisaEmp.visaDocuments);


      // this.dataEmployeeVisaList.data = this.employeeVisaData;
    

  }


  sendNotification1(status:string , email:string){

      if(status = 'OPT Receipt'){

          this.visaservice.sendNotificationEmail('optreceipt', email).subscribe(data=>console.log(200));

      }








  }

  sendNotification2(status:string , email:string){
  
    if(status = 'OPT EAD'){

      this.visaservice.sendNotificationEmail('optead', email).subscribe(data=>console.log(200));

  }
  
  }
  
  sendNotification3(status:string , email:string){
  
  
    if(status = 'I-983 Approved'){

      this.visaservice.sendNotificationEmail('i983approved', email).subscribe(data=>console.log(200));

  }
  
  }

  sendNotification4(status:string , email:string){
  
    if(status = 'I-20'){

      this.visaservice.sendNotificationEmail('i20', email).subscribe(data=>console.log(200));
  
  }
  
  }

  sendNotification5(status:string , email:string){
  
    if(status = 'OPT STEM Receipt'){

      this.visaservice.sendNotificationEmail('optstemreceipt', email).subscribe(data=>console.log(200));
    
    }
     
  
  }

  src : Blob;
  previewurl: any;

  previewFile(empid: Number ){

    console.log(empid);

      this.visaservice.geti983byempid(empid).subscribe(data=>{

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


        this.visaservice.getFileBlob(data.id).subscribe(data=>{
 
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

      this.visaservice.geti983byempid(empid).subscribe(data=>{

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


        this.visaservice.getFileBlob(data.id).subscribe(data=>{
 
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
       this.visaservice.uploadDocument(formData);
 
       console.log('call change status service');
 
      this.visaservice.changeVisaStatus(empid, 'I-983 Approved').subscribe(
         
         
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
