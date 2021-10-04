import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { MatTableDataSource } from '@angular/material/table';
import * as FileSaver from 'file-saver';
import { PersonalDocument } from 'src/app/models/PersonalDocument/personal-document';
import { HireService } from 'src/app/service/hire.service';
import { VisaService } from 'src/app/service/visa.service';
 

@Component({
  selector: 'app-visaemployeedocuments',
  templateUrl: './visaemployeedocuments.component.html',
  styleUrls: ['./visaemployeedocuments.component.css']
})
export class VisaemployeedocumentsComponent implements OnInit {


  displayedDocumentsColumnsList: string[] = [ 'icon', 'filename', 'download'  ];
  dataDocumentList = new MatTableDataSource();
  personalDocuments: PersonalDocument[]=[];
  employeeId: Number;
  userid: Number;
  pdfSrc = "https://vadimdez.github.io/ng2-pdf-viewer/assets/pdf-test.pdf";
  
  constructor(private formBuilder: FormBuilder, private hireservice: HireService, private visaservice: VisaService) { 

   

  }



  ngOnInit(): void {
    this.userid = +JSON.parse(localStorage.getItem('currentUser')).id;
    
    this.visaservice.getEmployeeId(this.userid).subscribe(
      data=>{
      
           this.employeeId = data;
           console.log(this.employeeId);

           this.visaservice.getAllPersonalDocuments(this.employeeId).subscribe(data=>{

                for(let i = 0 ; i<data.length;i++){

                    let temppd = new PersonalDocument(data[i].id, data[i].employee_id, data[i].path, data[i].title , data[i].comment, data[i].createdDate, data[i].filename);
                  

                    let strarray = data[i].filename.split('.');
                    let last = strarray[strarray.length - 1];
                   
                  
                    if(last == 'pdf'){
                        temppd.imagesrc = "https://upload.wikimedia.org/wikipedia/commons/thumb/8/87/PDF_file_icon.svg/1200px-PDF_file_icon.svg.png";
                    }

                    if(last == 'docx'){
                      temppd.imagesrc = "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fb/.docx_icon.svg/512px-.docx_icon.svg.png";
                    }
                    
                    if(last == 'doc'){
                      temppd.imagesrc = "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fb/.docx_icon.svg/512px-.docx_icon.svg.png";
                    }


                    this.personalDocuments.push(temppd);
                }


                this.dataDocumentList.data = this.personalDocuments;


           }) 

      }) 
 
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

}
