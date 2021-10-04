import { Component, OnInit } from '@angular/core';
import { VisaService } from 'src/app/service/visa.service';
import { FormBuilder, FormGroup } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-visaemployee',
  templateUrl: './visaemployee.component.html',
  styleUrls: ['./visaemployee.component.css']
})
export class VisaemployeeComponent implements OnInit {

  constructor(private visaService : VisaService,private formBuilder: FormBuilder , private httpClient: HttpClient, private router: Router ) { }

  userid: Number;

  employeeId: Number;

  visaType: String;

  optStatus: String;

  uploadForm: FormGroup; 
  isEmptyFile : boolean = false;

  optEadDayLeft: Number;

  ngOnInit( ) {
     this.uploadForm = this.formBuilder.group({
               file: ['']
    });

 


      this.userid = +JSON.parse(localStorage.getItem('currentUser')).id;
      console.log(this.userid);

       this.visaService.getEmployeeId(this.userid).subscribe(
       data=>{
            this.employeeId = data;
                   this.visaService.getOptstatus(+data).subscribe(

                        data=>{
                          console.log(data);

                          this.visaType =  data ;

                          console.log(this.visaType);
                  } ) ;

                   
                  this.visaService.getVisastatus(+data).subscribe( data=>{

                        var startDate = new Date(data.visaStartDate);
                        var endDate =   new Date(data.visaEndDate);
                        var differentinms = endDate.valueOf() - startDate.valueOf();
                        var differentindays = differentinms / (1000*24*60*60);

                        this.optEadDayLeft = differentindays;

                        console.log(differentindays);




                  });
       }
      ) ;
 
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

 

  onSubmit(optname:string) {

    let optstatus = optname;


  
    const formData = new FormData();
    formData.append('title',   optstatus);
    formData.append('employeeid',  ''+this.employeeId);
    formData.append('file', this.uploadForm.get('file').value);
  
    if(this.uploadForm.get('file').value.name != undefined  ){
        console.log("call upload file service");
        this.visaService.uploadDocument(formData);

        console.log('call change status service');

        this.visaService.changeVisaStatus(this.employeeId, optstatus).subscribe(
          
          
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

 testlink: string;
  FilePreview( ) {

   

   this.testlink = "https://spring-amazon-storage-group6.s3.us-east-2.amazonaws.com/040348e9-b86f-4619-92b2-6a387e61c862/I-983.pdf";

    
    
  }
  pdfSrc = "https://vadimdez.github.io/ng2-pdf-viewer/assets/pdf-test.pdf";
  
  ngAfterViewInit() {

    this.visaService.getFile().subscribe(data=>{
   
      console.log(data);
      
    });
   
  }




}
