import { Component, OnInit } from '@angular/core';
import { PersonalDocument } from 'src/app/models/PersonalDocument/personal-document';
import { HireService } from 'src/app/service/hire.service';
import { VisaService } from 'src/app/service/visa.service';
import { animate, state, style, transition, trigger } from '@angular/animations';
import { MatTableDataSource } from '@angular/material/table';
import { PersonalDocumentEnhanced } from 'src/app/models/PersonalDocument/PersonalDocumentEnhanced.model';
import { saveAs } from 'file-saver';
import * as FileSaver from 'file-saver';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-documentsreview',
  templateUrl: './documentsreview.component.html',
  styleUrls: ['./documentsreview.component.css']
})
export class DocumentsreviewComponent implements OnInit {

  fileUrl:any;
  displayedDocumentsColumnsList: string[] = [ 'name'  ,  'title', 'filename', 'createdDate'  ,'preview', 'download' ,'actions', 'addcomment' ];


  commentform = this.formBuilder.group({
    comment: '' 
   
  });


  //upload form for i983
  uploadForm: FormGroup; 
  isEmptyFile : boolean = false;

  constructor(private formBuilder: FormBuilder, private hireservice: HireService, private visaservice: VisaService) { }

  personalDocuments : PersonalDocumentEnhanced[] =[] ;
  dataDocumentList = new MatTableDataSource();


  ngOnInit() {
    this.uploadForm = this.formBuilder.group({
      file: ['']
});

      this.hireservice.getAllEnhancedDocumentsPending().subscribe(data=>{
        console.log(data.length);
        
         for(let i = 0 ; i<data.length;i++){
           

              let temppd = new PersonalDocumentEnhanced(data[i].firstName, data[i].lastName, data[i].email, data[i].id, data[i].employee_id, data[i].path, data[i].title, data[i].comment, data[i].createdDate, data[i].filename);
         

              this.personalDocuments.push(temppd);

              console.log(this.personalDocuments);
              this.dataDocumentList.data = this.personalDocuments;

         }

      
        
     
    }
 
  
    // this.hireservice.getAllEnhancedDocuments().subscribe(data=>{
    //     console.log(data.length);
        
    //      for(let i = 0 ; i<data.length;i++){
           

    //           let temppd = new PersonalDocumentEnhanced(data[i].firstName, data[i].lastName, data[i].email, data[i].id, data[i].employee_id, data[i].path, data[i].title, data[i].comment, data[i].createdDate, data[i].filename);
         

    //           this.personalDocuments.push(temppd);

    //           console.log(this.personalDocuments);
    //           this.dataDocumentList.data = this.personalDocuments;

    //      }

      
        
     
    // }
    
    
    ) ;
 
  }

  src : Blob;
  previewurl: any;
  previewFile(fileid:Number, filename:string){


    let strarray = filename.split('.');
    let last = strarray[strarray.length - 1];
    let type = 'application/pdf;charset=utf-8';

    if(last == 'docx'){
      type = 'application/vnd.openxmlformats-officedocument.wordprocessingml.document';
    }
    
    if(last == 'doc'){
      type = 'application/msword';
    }


    console.log(last);




    this.visaservice.getFileBlob(fileid).subscribe(data=>{
 
       var blob = new Blob([data],  {type: type   }  );

       let url = URL.createObjectURL(blob);
       this.previewurl = url;
       console.log(url);

       this.src =  data;
     // console.log( this.previewSrc);

    //  FileSaver.saveAs(blob, filename);
    });

  }


  downloadFile(fileid:Number, filename:string){


    let strarray = filename.split('.');
    let last = strarray[strarray.length - 1];
    let type = 'application/pdf;charset=utf-8';

    if(last == 'docx'){
      type = 'application/vnd.openxmlformats-officedocument.wordprocessingml.document';
    }
    
    if(last == 'doc'){
      type = 'application/msword';
    }


    console.log(last);




    this.visaservice.getFileBlob(fileid).subscribe(data=>{
      var blob = new Blob([data],  {type: type   }  );
      FileSaver.saveAs(blob, filename);
    });
    console.log();
  }

  onSubmit(empid:Number ): void {

    this.hireservice.addDocumentComment(empid, this.commentform.value.comment).subscribe(data=>console.log(data));

    this.commentform.reset();

    console.log("comment added");
  }


  approvedocument(empid:Number, fileid :Number){

      this.hireservice.approveDocument(empid, fileid).subscribe(data=>{console.log(data)});
       window.location.reload();

  }

  
  rejectdocument(empid:Number, fileid :Number){

    this.hireservice.rejectDocument(empid, fileid).subscribe(data=>{console.log(data)});
       window.location.reload();

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
